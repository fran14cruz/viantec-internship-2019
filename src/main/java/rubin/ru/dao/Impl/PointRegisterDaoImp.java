package rubin.ru.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import rubin.ru.dao.PointRegisterDao;
import rubin.ru.model.PointRegister;

import java.util.List;

@Component
public class PointRegisterDaoImp implements PointRegisterDao {

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    @Override
    public void addPointRegisters(List<PointRegister> pointRegisters) {
        String query = "INSERT INTO POINT_REGISTER(id_mac, id_name, id_vendor, id_sensor, last_active_date, packages, frequency) " +
                "VALUES(:idMac, :idName, :idVendor, :idSensor, :lastActiveDate, :packages, :frequency)";

        SqlParameterSource[] sqlParameterSource = SqlParameterSourceUtils.createBatch(pointRegisters);

        namedTemplate.batchUpdate(query, sqlParameterSource);
    }

}
