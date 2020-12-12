package rubin.ru.dao.mapper;

import rubin.ru.model.FilterDto;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilterDtoMapper implements RowMapper {

    @Override
    public FilterDto mapRow(ResultSet rs, int i) throws SQLException {
        FilterDto filterDto = new FilterDto();

        filterDto.setId(rs.getObject("id", Long.class));
        filterDto.setUserId(rs.getObject("user_id", Long.class));
        filterDto.setName(rs.getObject("name", String.class));
        filterDto.setFields(rs.getObject("fields", String.class));

        return filterDto;
    }
}
