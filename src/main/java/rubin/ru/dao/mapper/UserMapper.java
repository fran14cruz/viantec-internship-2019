package rubin.ru.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import rubin.ru.dao.enums.UserRole;
import rubin.ru.model.Role;
import rubin.ru.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setId(resultSet.getObject("id", Long.class));
        user.setUsername(resultSet.getObject("username", String.class));
        user.setPassword(resultSet.getObject("password", String.class));

        Role role = new Role();
        role.setId(resultSet.getObject("role_id", Long.class));
        role.setName(UserRole.valueOf(resultSet.getObject("name", String.class)));
        user.setRole(role);

        return user;
    }

}
