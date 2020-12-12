package rubin.ru.dao;

import rubin.ru.model.PointList;

import java.util.List;

public interface PointListDao {

    List<PointList> getPointLists();

    Long addPointList(PointList pointList);

    Long updatePointList(Long id, PointList pointList);

    Long removePointList(Long id);

    Long getPointListIdByName(String name);

}
