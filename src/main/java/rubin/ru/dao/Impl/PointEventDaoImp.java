package rubin.ru.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import rubin.ru.dao.PointEventDao;
import rubin.ru.dao.mapper.PointEventDtoMapper;
import rubin.ru.dao.utils.PointEventUtils;
import rubin.ru.dto.PointEventDto;
import rubin.ru.model.Sort;

import java.util.List;

@Component
public class PointEventDaoImp implements PointEventDao {

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    @Override
    public List<PointEventDto> getPointEvent(Integer offset, Integer limit, Sort sort) {
        String pointInfo = "WITH POINT_INFO AS (" +
                "SELECT pe.ID ID, " +
                "pe.CODING CODING, " +
                "pe.PACKAGES PACKAGES, " +
                "pe.FREQUENCY FREQUENCY, " +
                "pe.LEVEL POINT_LEVEL, " +
                "pe.FIRST_DATE_TIME FIRST_DATE_TIME, " +
                "pe.LAST_DATE_TIME LAST_DATE_TIME, " +
                "pe.ACTIVE ACTIVE, " +
                "pe.FLAT FLAT, " +
                "p.MAC MAC, " +
                "pn.NAME POINT_NAME, " +
                "v.NAME VENDOR_NAME, " +
                "l.ID ID_LIST, " +
                "l.NAME LIST_NAME, " +
                "COUNT(*) OVER() AS FULL_COUNT " +
                "FROM POINT_EVENT pe " +
                "INNER JOIN POINT p ON (p.ID = pe.ID_MAC) " +
                "INNER JOIN POINT_NAME pn ON (p.ID_NAME = pn.ID) " +
                "INNER JOIN VENDOR v ON (p.ID_VENDOR = v.ID) " +
                "INNER JOIN POINT_LIST l ON (p.STATUS = l.ID)) ";

        String query = pointInfo +
                " SELECT " +
                    "*, " +
                    "(SELECT COUNT(*) CLIENT_COUNT FROM CLIENT_EVENT WHERE pi.ID = CLIENT_EVENT.ID_POINT) " +
                "FROM POINT_INFO AS pi " +
                (PointEventUtils.buildPartSortQuery(sort)) +
                " OFFSET :offset LIMIT :limit";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("offset", offset)
                .addValue("limit", limit);

        return namedTemplate.query(query, parameterSource, new PointEventDtoMapper());
    }
}
