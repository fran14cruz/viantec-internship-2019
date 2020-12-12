package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rubin.ru.dao.PointEventDao;
import rubin.ru.dto.PointEventDto;
import rubin.ru.model.Sort;

import java.util.List;

@Service
public class PointEventService {

    @Autowired
    private PointEventDao pointEventDao;

    public List<PointEventDto> getPointEventDto(Integer offset, Integer limit, Sort sort) {
        return pointEventDao.getPointEvent(offset, limit, sort);
    }
}
