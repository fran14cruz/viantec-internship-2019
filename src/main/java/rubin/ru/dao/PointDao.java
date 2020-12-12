package rubin.ru.dao;

import rubin.ru.model.Point;

import java.util.List;

public interface PointDao {

    Long addPoint(Point point);

    List<Point> getPoints();

    Long updatePointList(Long pointId, Long listId);

    Long addPointName(String name);

    Long getPointNameId(String name);

}
