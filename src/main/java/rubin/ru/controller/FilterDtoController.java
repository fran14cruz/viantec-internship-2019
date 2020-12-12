package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rubin.ru.model.FilterDto;
import rubin.ru.service.FilterDtoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilterDtoController {
    @Autowired
    private FilterDtoService filterDtoService;

    @GetMapping(value = "/filter")
    public List<FilterDto> getFilters() {
        return filterDtoService.getFilters();
    }

    @PostMapping(value = "/filter")
    public Long save(@RequestBody FilterDto filterDto) {
        return filterDtoService.save(filterDto);
    }

    @PutMapping(value = "/filter/{id}")
    public Long update(@PathVariable Long id, @RequestBody FilterDto filterDto) {
        return filterDtoService.update(id, filterDto);
    }

    @DeleteMapping(value = "/filter/{id}")
    public void delete(@PathVariable Long id) {
        filterDtoService.delete(id);
    }

}
