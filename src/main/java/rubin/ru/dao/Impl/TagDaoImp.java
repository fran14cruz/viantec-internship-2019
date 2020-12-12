package rubin.ru.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import rubin.ru.dao.TagDao;
import rubin.ru.model.Tag;
import rubin.ru.dao.mapper.TagMapper;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

@Component
public class TagDaoImp implements TagDao {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public List<Tag> getTags() {
        String query = "SELECT * FROM tag";

        return namedJdbcTemplate.query(query, new TagMapper());
    }

    @Override
    public Long save(Tag tag) {
        String query = "INSERT INTO tag (name) VALUES (:name)";

        KeyHolder holder = new GeneratedKeyHolder();

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", tag.getName());

        namedJdbcTemplate.update(query, parameterSource, holder);

        return (Long) holder.getKeyList().get(0).get("id");
    }

    @Override
    public Long update(Long tagId, Tag tag) {
        String query = "UPDATE tag SET name = :name WHERE id = :id";

        KeyHolder holder = new GeneratedKeyHolder();

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", tagId)
                .addValue("name", tag.getName());

        namedJdbcTemplate.update(query, parameterSource, holder);

        return (Long) holder.getKeyList().get(0).get("id");
    }

    @Override
    public Long delete(Long tagId) {
        String query = "DELETE FROM tag WHERE id = :id";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", tagId);

        namedJdbcTemplate.update(query, namedParameters);

        return tagId;
    }

}