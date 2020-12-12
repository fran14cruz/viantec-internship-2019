package rubin.ru.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import rubin.ru.dao.PointListDao;
import rubin.ru.dao.mapper.PointListMapper;
import rubin.ru.model.PointList;

import java.util.List;

@Component
public class PointListDaoImp implements PointListDao {

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;


    @Override
    public List<PointList> getPointLists() {
        String query = "SELECT * FROM point_list";

        return namedTemplate.query(query, new PointListMapper());
    }

    @Override
    public Long addPointList(PointList pointList) {
        String query = "INSERT INTO point_list VALUES(:id,:name)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("name", pointList.getName());

        namedTemplate.update(query, sqlParameterSource, keyHolder);

        return (Long) keyHolder.getKeyList().get(0).get("id");
    }

    @Override
    public Long updatePointList(Long id, PointList pointList) {
        String query = "UPDATE point_list SET name = :name WHERE id = :id";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("name", pointList.getName())
                .addValue("id", id);

        namedTemplate.update(query, sqlParameterSource, keyHolder);

        return (Long) keyHolder.getKeyList().get(0).get("id");
    }

    @Override
    public Long removePointList(Long id) {
        String query = "DELETE FROM point_list WHERE id = :id";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id);

        namedTemplate.update(query, sqlParameterSource, keyHolder);

        return id;
    }

    @Override
    public Long getPointListIdByName(String name) {
        String query = "SELECT id FROM point_list WHERE name = :name";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("name", name);

        return namedTemplate.queryForObject(query, sqlParameterSource, Long.class);
    }

}
