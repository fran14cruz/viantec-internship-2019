package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rubin.ru.model.PointList;
import rubin.ru.service.PointListService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class PointListController {

    @Autowired
    private PointListService pointListService;

    @GetMapping(value = "/pointlist")
    public List<PointList> getPointLists() {
        return pointListService.getPointLists();
    }

//    @PostMapping(value = "/pointlist")
//    public long addPointList(@RequestBody PointList pointList) {
//        return pointListService.(pointList);
//    }
//
//    @PutMapping(value = "/pointlist/{id}")
//    public long updatePointList(@PathVariable Long id, @RequestBody PointList pointList) {
//        return pointListService.updatePointList(id, pointList);
//    }
//
//    @DeleteMapping(value = "/pointlist/{id}")
//    public long removePointList(@PathVariable Long id) {
//        return pointListService.removePointList(id);
//    }


}
