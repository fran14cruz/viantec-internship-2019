package rubin.ru.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import rubin.ru.dao.FilterDtoDao;
import rubin.ru.dao.mapper.FilterDtoMapper;
import rubin.ru.model.FilterDto;

import java.util.List;

@Component
public class FilterDtoDaoImp implements FilterDtoDao {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public List<FilterDto> getFiltersByUserId(Long userId) {
        String query = "SELECT * FROM filter WHERE user_id IS NULL OR user_id = :user_id";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("user_id", userId);

        return namedJdbcTemplate.query(query, parameterSource, new FilterDtoMapper());
    }

    @Override
    public Long save(FilterDto filterDto) {
        String query = "INSERT INTO filter (user_id, name, fields) " +
                "VALUES (:user_id, :name, :fields)";

        KeyHolder holder = new GeneratedKeyHolder();

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("user_id", filterDto.getUserId())
                .addValue("name", filterDto.getName())
                .addValue("fields", filterDto.getFields());

        namedJdbcTemplate.update(query, parameterSource, holder);

        return (Long) holder.getKeyList().get(0).get("id");
    }

    @Override
    public Long update(Long id, FilterDto filterDto) {
        String query = "UPDATE filter SET user_id = :user_id, name = :name, " +
                "fields = :fields WHERE id = :id";

        KeyHolder holder = new GeneratedKeyHolder();

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("user_id", filterDto.getUserId())
                .addValue("name", filterDto.getName())
                .addValue("fields", filterDto.getFields());

        namedJdbcTemplate.update(query, parameterSource, holder);

        return (Long) holder.getKeyList().get(0).get("id");

    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM filter WHERE id = :id";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", id);

        namedJdbcTemplate.update(query, parameterSource);
    }

}
