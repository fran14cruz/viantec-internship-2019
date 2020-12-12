package rubin.ru.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import rubin.ru.dao.utils.PointEventUtils;
import rubin.ru.dto.ClientEventDto;
import rubin.ru.model.PointList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

//TODO:: Подумать над общим маппером для клиента и точки
public class ClientEventDtoMapper implements RowMapper {

    @Override
    public ClientEventDto mapRow(ResultSet rs, int i) throws SQLException {

        ClientEventDto clientEvent = new ClientEventDto();

        clientEvent.setId(rs.getObject("ID", Long.class));
        clientEvent.setMac(rs.getObject("MAC", String.class));
        clientEvent.setVendor(rs.getObject("VENDOR_NAME", String.class));
        clientEvent.setFlat(rs.getObject("FLAT", Integer.class));
        clientEvent.setFirstDateTime(rs.getObject("FIRST_DATE_TIME", LocalDateTime.class));
        clientEvent.setActive(rs.getObject("ACTIVE", Boolean.class));
        clientEvent.setPackages(rs.getObject("PACKAGES", Integer.class));
        clientEvent.setLevel(rs.getObject("CLIENT_LEVEL", Integer.class));

        PointList pointList = new PointList();
        pointList.setId(rs.getObject("ID_LIST", Long.class));
        pointList.setName(rs.getObject("LIST_NAME", String.class));
        clientEvent.setPointList(pointList);

        Integer frequency = rs.getObject("FREQUENCY", Integer.class);
        clientEvent.setFrequency(PointEventUtils.channelFrequencyFormatter(frequency));

        LocalDateTime lastDateTime = rs.getObject("LAST_DATE_TIME", LocalDateTime.class);
        clientEvent.setLastDateTime(lastDateTime);
        clientEvent.setTimeFrame(PointEventUtils.getTimeFrame(lastDateTime));

        return clientEvent;
    }
}
