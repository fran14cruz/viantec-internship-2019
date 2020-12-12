package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rubin.ru.model.Point;
import rubin.ru.model.PointList;
import rubin.ru.service.PointService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PointController {

    @Autowired
    private PointService pointService;

    @PostMapping(path = "/point")
    public Long addNewPoint (@RequestBody Point point) {
        return pointService.addPoint(point);
    }

    @GetMapping(path = "/point")
    public List<Point> getPoints () {
        return pointService.getPoints();
    }

    @PutMapping(path = "/point/{pointId}/list")
    public Long updatePointList(
        @PathVariable("pointId") Long pointId,
        @RequestBody PointList pointList
    ) {
        return pointService.updatePointList(pointId, pointList);
    }

}
