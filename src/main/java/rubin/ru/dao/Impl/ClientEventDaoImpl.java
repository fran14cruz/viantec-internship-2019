package rubin.ru.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import rubin.ru.dao.ClientEventDao;
import rubin.ru.dao.mapper.ClientEventDtoMapper;
import rubin.ru.dto.ClientEventDto;
import rubin.ru.model.ClientEvent;
import rubin.ru.model.Sort;

import java.util.List;

@Component
public class ClientEventDaoImpl implements ClientEventDao {

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    @Override
    public List<ClientEvent> getClientEvent(Integer offset, Integer limit, Sort sort) {
        return null;
    }

    @Override
    public List<ClientEventDto> getClientEventByPoint(Long idPoint) {
        String query = "SELECT " +
                "ce.ID ID, " +
                "ce.PACKAGES PACKAGES, " +
                "ce.FREQUENCY FREQUENCY, " +
                "ce.LEVEL CLIENT_LEVEL, " +
                "ce.FIRST_DATE_TIME FIRST_DATE_TIME, " +
                "ce.LAST_DATE_TIME LAST_DATE_TIME, " +
                "ce.ACTIVE ACTIVE, " +
                "ce.FLAT FLAT, " +
                "c.MAC MAC, " +
                "v.NAME VENDOR_NAME, " +
                "l.ID ID_LIST, " +
                "l.NAME LIST_NAME " +
                "FROM CLIENT_EVENT ce " +
                "INNER JOIN CLIENT c ON (c.ID = ce.ID_MAC) " +
                "INNER JOIN VENDOR v ON (v.ID = c.ID_VENDOR) " +
                "INNER JOIN LIST l ON (c.STATUS = l.ID) " +
                "WHERE ce.ID_POINT = :idPoint";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("idPoint", idPoint);


        return namedTemplate.query(query, parameterSource, new ClientEventDtoMapper());
    }
}
