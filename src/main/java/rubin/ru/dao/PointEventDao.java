package rubin.ru.dao;

import rubin.ru.dto.PointEventDto;
import rubin.ru.model.Sort;

import java.util.List;

public interface PointEventDao {

    List<PointEventDto> getPointEvent(Integer offset, Integer limit, Sort sort);


}
