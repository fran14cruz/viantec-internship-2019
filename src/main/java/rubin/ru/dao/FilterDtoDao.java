package rubin.ru.dao;

import rubin.ru.model.FilterDto;

import java.util.List;

public interface FilterDtoDao {

    List<FilterDto> getFiltersByUserId(Long userId);

    Long save(FilterDto filterDto);

    Long update(Long id, FilterDto filterDto);

    void delete(Long id);

}
