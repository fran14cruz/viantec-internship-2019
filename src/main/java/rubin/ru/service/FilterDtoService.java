package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rubin.ru.dao.FilterDtoDao;
import rubin.ru.model.FilterDto;

import java.util.List;

@Service
public class FilterDtoService {

    @Autowired
    private FilterDtoDao filterDtoDao;

    private UserService userService = new UserService();

    public List<FilterDto> getFilters() {
        return filterDtoDao.getFiltersByUserId(userService.getAuthUserId());
    }

    public Long save(FilterDto filterDto) {

        filterDto.setUserId(userService.getAuthUserId());
        return filterDtoDao.save(filterDto);
    }

    public Long update(Long filterId, FilterDto filterDto) {

        filterDto.setUserId(userService.getAuthUserId());
        return filterDtoDao.update(filterId, filterDto);
    }

    public void delete(Long filterId) {
        filterDtoDao.delete(filterId);
    }

}
