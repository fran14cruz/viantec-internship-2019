package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rubin.ru.dao.PointListDao;
import rubin.ru.model.PointList;

import java.util.List;

@Service
public class PointListService {

    @Autowired
    private PointListDao pointListDao;

    public List<PointList> getPointLists() {
        return pointListDao.getPointLists();
    }


}
