package rubin.ru.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import rubin.ru.dao.PointDao;
import rubin.ru.model.Point;
import rubin.ru.dao.mapper.PointMapper;

import java.util.List;

@Component
public class PointDaoImp implements PointDao {

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    @Override
    public Long addPoint(Point point) {

        String query = "INSERT INTO POINT(mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date) " +
                "VALUES(:mac, :idName, :idVendor, :idSensor, :idSensorLast, :status, :lastActiveDate)";

        KeyHolder holder = new GeneratedKeyHolder();

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", 0)
                .addValue("mac", point.getMac())
                .addValue("idName", point.getIdName())
                .addValue("idVendor", point.getIdVendor())
                .addValue("idSensor", point.getIdSensor())
                .addValue("idSensorLast", point.getIdSensorLast())
                .addValue("status", point.getIdList())
                .addValue("lastActiveDate", point.getLastActiveDate());

        namedTemplate.update(query, parameterSource, holder);

        return (Long) holder.getKeyList().get(0).get("id");
    }

    @Override
    public List<Point> getPoints() {
        String query = "SELECT * FROM POINT";

        return namedTemplate.query(query, new PointMapper());
    }

    @Override
    public Long updatePointList(Long pointId, Long listId) {
        String query = "UPDATE POINT SET STATUS = :listId WHERE ID = :id";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", pointId)
                .addValue("listId", listId);

        namedTemplate.update(query, parameterSource);

        return pointId;
    }

    @Override
    public Long addPointName(String name) {

        String query = "INSERT INTO point_name (name) VALUES (:name)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("name", name);

        namedTemplate.update(query, sqlParameterSource, keyHolder);

        return (Long) keyHolder.getKeyList().get(0).get("id");
    }

    @Override
    public Long getPointNameId(String name) {
        String query = "SELECT id FROM point_name WHERE name = :name";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("name", name);

        try {
            return namedTemplate.queryForObject(query, sqlParameterSource, Long.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}