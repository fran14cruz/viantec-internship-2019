package rubin.ru.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import rubin.ru.model.Device;
import rubin.ru.model.Position;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DeviceMapper implements RowMapper {
    @Override
    public Device mapRow(ResultSet resultSet, int i) throws SQLException {

        Position position = new Position();
        position.setX(resultSet.getObject("x", Integer.class));
        position.setY(resultSet.getObject("y", Integer.class));
        position.setR(resultSet.getObject("r", Integer.class));
        position.setFlat(resultSet.getObject("flat", Integer.class));

        Device device = new Device();
        device.setPosition(position);
        device.setId(resultSet.getObject("id", Long.class));
        device.setMac(resultSet.getObject("mac", String.class));
        device.setFirstMac(resultSet.getObject("first_mac", String.class));
        device.setSecondMac(resultSet.getObject("second_mac", String.class));
        device.setIp(resultSet.getObject("ip", String.class));
        device.setLastDateTime(resultSet.getObject("last_date_time", LocalDateTime.class));
        device.setFirmwareVersion(resultSet.getObject("firmware_version", String.class));

        return device;
    }

}
