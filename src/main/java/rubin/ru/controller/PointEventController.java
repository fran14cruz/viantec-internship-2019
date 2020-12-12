package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rubin.ru.dto.PointEventDto;
import rubin.ru.model.Sort;
import rubin.ru.service.PointEventService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PointEventController {

    @Autowired
    private PointEventService pointEventService;

    @GetMapping(path = "/pointevent")
    public List<PointEventDto> getPoints (
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String sortBy
    ) {
        Sort sort = new Sort();
        if(sortBy != null) {
            String[] sortPart = sortBy.split("\\."); // sort type is NAME.DESC firs is field, second is direction
            sort.setField(sortPart[0]);
            sort.setDirection(sortPart[1]);
        }
        return pointEventService.getPointEventDto(offset, limit, sort);
    }
}
