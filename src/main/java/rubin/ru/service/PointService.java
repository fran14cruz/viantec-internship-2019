package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rubin.ru.dao.PointDao;
import rubin.ru.model.Point;
import rubin.ru.model.PointList;

import java.util.List;

@Service
public class PointService {

    @Autowired
    private PointDao pointDao;

    public Long addPoint(Point point) {
        return pointDao.addPoint(point);
    }

    public List<Point> getPoints() {
        return pointDao.getPoints();
    }

    public Long updatePointList(Long pointID, PointList pointList) {
        return pointDao.updatePointList(pointID, pointList.getId());
    }

}
