package rubin.ru.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import rubin.ru.model.PointList;


import java.sql.ResultSet;
import java.sql.SQLException;

public class PointListMapper implements RowMapper {

    @Override
    public PointList mapRow(ResultSet rs, int i) throws SQLException {
        PointList pointList = new PointList();

        pointList.setId(rs.getObject("id", Long.class));
        pointList.setName(rs.getObject("name", String.class));

        return pointList;
    }

}
