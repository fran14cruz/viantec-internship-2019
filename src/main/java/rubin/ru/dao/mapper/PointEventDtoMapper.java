package rubin.ru.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import rubin.ru.dao.enums.Coding;
import rubin.ru.dao.utils.PointEventUtils;
import rubin.ru.dto.PointEventDto;
import rubin.ru.model.PointList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PointEventDtoMapper implements RowMapper {

    @Override
    public PointEventDto mapRow(ResultSet rs, int i) throws SQLException {

        PointEventDto pointEvent = new PointEventDto();

        pointEvent.setId(rs.getObject("ID", Long.class));
        pointEvent.setMac(rs.getObject("MAC", String.class));
        pointEvent.setName(rs.getObject("POINT_NAME", String.class));
        pointEvent.setVendor(rs.getObject("VENDOR_NAME", String.class));
        pointEvent.setFlat(rs.getObject("FLAT", Integer.class));
        pointEvent.setFirstDateTime(rs.getObject("FIRST_DATE_TIME", LocalDateTime.class));
        pointEvent.setActive(rs.getObject("ACTIVE", Boolean.class));
        pointEvent.setCoding(Coding.setCoding(rs.getObject("CODING", String.class)));
        pointEvent.setPackages(rs.getObject("PACKAGES", Integer.class));
        pointEvent.setLevel(rs.getObject("POINT_LEVEL", Integer.class));
        pointEvent.setCount(rs.getObject("FULL_COUNT", Long.class));
        pointEvent.setClientCount(rs.getObject("CLIENT_COUNT", Long.class));

        PointList pointList = new PointList();
        pointList.setId(rs.getObject("ID_LIST", Long.class));
        pointList.setName(rs.getObject("LIST_NAME", String.class));
        pointEvent.setPointList(pointList);

        Integer frequency = rs.getObject("FREQUENCY", Integer.class);
        pointEvent.setFrequency(PointEventUtils.channelFrequencyFormatter(frequency));
        pointEvent.setStandard(PointEventUtils.getStandard(frequency));

        LocalDateTime lastDateTime = rs.getObject("LAST_DATE_TIME", LocalDateTime.class);
        pointEvent.setLastDateTime(lastDateTime);
        pointEvent.setTimeFrame(PointEventUtils.getTimeFrame(lastDateTime));

        return pointEvent;
    }

}
