package rubin.ru.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import rubin.ru.dao.DeviceDao;
import rubin.ru.dao.mapper.DeviceMapper;
import rubin.ru.model.Device;
import rubin.ru.model.DeviceDto;
import rubin.ru.model.Position;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DeviceDaoImp implements DeviceDao {

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;


    @Override
    public List<Device> getDevices() {
        String query = "SELECT * FROM device";

        return namedTemplate.query(query, new DeviceMapper());
    }

    @Override
    public Long addDevice(Device device) {
        String query = "INSERT INTO device(x, y, r, flat, mac,first_mac, second_mac, ip, last_date_time, firmware_version)" +
                "VALUES (:x, :y, :r, :flat, :mac, :first_mac,:second_mac, :ip, :last_date_time, :firmware_version)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        Map<String, Object> mapSqlWithParam = createMapSqlWithValue(device);
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource(mapSqlWithParam);

        namedTemplate.update(query, mapSqlParameterSource, keyHolder);
        return (Long) keyHolder.getKeyList().get(0).get("id");
    }

    @Override
    public Long updateDevice(Long id, Device device) {
        String query = "UPDATE device SET " +
                "x = :x, " +
                "y = :y, " +
                "r = :r, " +
                "flat = :flat, " +
                "mac = :mac," +
                "first_mac = :first_mac, " +
                "second_mac = :second_mac, " +
                "ip = :ip, " +
                "last_date_time = :last_date_time, " +
                "firmware_version = :firmware_version " +
                "WHERE id = :id";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        Map<String, Object> mapSqlWithParam = createMapSqlWithValue(device);
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource(mapSqlWithParam)
                .addValue("id", id);

        namedTemplate.update(query, mapSqlParameterSource, keyHolder);

        return (Long) keyHolder.getKeyList().get(0).get("id");
    }


    @Override
    public Long removeDevice(Long id) {
        String query = "DELETE FROM device WHERE id = :id";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", id);

        namedTemplate.update(query, sqlParameterSource);

        return id;
    }

    @Override
    public Device accessCheckDevice(DeviceDto deviceDto) {
        String query = "SELECT * FROM device WHERE mac = :mac";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("mac", deviceDto.getMac());

        return namedTemplate.queryForObject(query, sqlParameterSource, Device.class);
    }

    @Override
    public void updateDeviceFirmware(DeviceDto deviceDto) {
        String query = "UPDATE device SET firmware_version = :firmware_version WHERE mac = :mac";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("firmware_version", deviceDto.getFirmwareVersion())
                .addValue("mac", deviceDto.getMac());

        namedTemplate.update(query, sqlParameterSource);

    }

    @Override
    public Long getDeviceIdByIp(String ip) {
        String query = "SELECT id FROM device WHERE ip = :ip";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("ip", ip);

        try {
            return namedTemplate.queryForObject(query, sqlParameterSource, Long.class);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Device does not exists");
        }

    }

    @Override
    public Long updateLastDateTime(String ip) {
        String query = "UPDATE device SET last_date_time = :date WHERE ip = :ip";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("ip", ip)
                .addValue("date", LocalDateTime.now(ZoneOffset.UTC));

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedTemplate.update(query, sqlParameterSource, keyHolder);

        return (Long) keyHolder.getKeyList().get(0).get("id");

    }

    private Map<String, Object> createMapSqlWithValue(Device device) {
        Map<String, Object> mapSql = new HashMap<>();

        Position position = device.getPosition();

        mapSql.put("y", position.getY());
        mapSql.put("r", position.getR());
        mapSql.put("flat", position.getFlat());
        mapSql.put("mac", device.getMac());
        mapSql.put("first_mac", device.getFirstMac());
        mapSql.put("second_mac", device.getSecondMac());
        mapSql.put("ip", device.getIp());
        mapSql.put("last_date_time", device.getLastDateTime());
        mapSql.put("firmware_version", device.getFirmwareVersion());

        return mapSql;
    }

}
