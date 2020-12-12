package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rubin.ru.model.PointList;
import rubin.ru.service.PointListService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ListController {

    @Autowired
    private PointListService pointListService;

    @GetMapping(path = "/pointList")
    public List<PointList> getPoints () {
        return pointListService.getPointLists();
    }
}
