package rubin.ru.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import rubin.ru.model.Point;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class PointMapper implements RowMapper {

    @Override
    public Point mapRow(ResultSet rs, int i) throws SQLException {
        Point point = new Point();

        point.setId(rs.getObject("id", Long.class));
        point.setMac(rs.getObject("mac", String.class));
        point.setIdName(rs.getObject("id_name", Long.class));
        point.setIdVendor(rs.getObject("id_vendor", Long.class));
        point.setIdSensor(rs.getObject("id_sensor", Long.class));
        point.setIdSensorLast(rs.getObject("id_sensor_last", Long.class));
        point.setIdList(rs.getObject("status", Long.class));
        point.setLastActiveDate(rs.getObject("last_active_date", LocalDateTime.class));

        return point;
    }
}
