package rubin.ru.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import rubin.ru.dao.enums.UserRole;
import rubin.ru.model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper {
    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {
        Role role = new Role();

        role.setId(resultSet.getObject("id", Long.class));
        role.setName(UserRole.valueOf(resultSet.getObject("name", String.class)));

        return role;
    }

}
