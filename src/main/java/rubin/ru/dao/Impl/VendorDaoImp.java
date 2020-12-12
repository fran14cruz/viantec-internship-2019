package rubin.ru.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import rubin.ru.model.Vendor;
import rubin.ru.dao.VendorDao;

@Component
public class VendorDaoImp implements VendorDao {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public void update(Vendor vendor) {
        String query = "INSERT INTO vendor (name, short_mac) " +
                "VALUES (:name, :short_mac) " +
                "ON CONFLICT (short_mac) DO UPDATE " +
                "SET name = excluded.name";

        KeyHolder holder = new GeneratedKeyHolder();

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", vendor.getName())
                .addValue("short_mac", vendor.getShortMac());

        namedJdbcTemplate.update(query, parameterSource, holder);
    }

    @Override
    public Long getVendorIdByMac(String shortMac) {
        String query = "SELECT id FROM vendor WHERE short_mac = :mac";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("mac", shortMac);

        try {
            return namedJdbcTemplate.queryForObject(query, sqlParameterSource, Long.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
