package rubin.ru.dao.mapper;

import org.springframework.jdbc.core.RowMapper;

import rubin.ru.model.Tag;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagMapper implements RowMapper {

    @Override
    public Tag mapRow(ResultSet rs, int i) throws SQLException {
        Tag tag = new Tag();

        tag.setId(rs.getObject("id", Long.class));
        tag.setName(rs.getObject("name", String.class));

        return tag;
    }
}
