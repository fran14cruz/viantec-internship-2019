package rubin.ru.dao;


import rubin.ru.dto.ClientEventDto;
import rubin.ru.model.ClientEvent;
import rubin.ru.model.Sort;

import java.util.List;

public interface ClientEventDao {

    List<ClientEvent> getClientEvent(Integer offset, Integer limit, Sort sort);

    List<ClientEventDto> getClientEventByPoint(Long idPoint);

}
