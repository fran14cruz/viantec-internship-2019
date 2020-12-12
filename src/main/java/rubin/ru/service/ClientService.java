package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rubin.ru.dao.Impl.ClientEventDaoImpl;
import rubin.ru.dto.ClientEventDto;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientEventDaoImpl clientEventDao;

    public List<ClientEventDto> getClientEventByPoint(Long pointId) {
        return clientEventDao.getClientEventByPoint(pointId);
    }


}
