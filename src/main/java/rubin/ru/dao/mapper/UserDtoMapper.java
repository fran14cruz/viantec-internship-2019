package rubin.ru.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import rubin.ru.dao.enums.UserRole;
import rubin.ru.dto.UserDto;
import rubin.ru.model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserDtoMapper implements RowMapper {
    @Override
    public UserDto mapRow(ResultSet resultSet, int i) throws SQLException {
        UserDto user = new UserDto();

        user.setId(resultSet.getObject("id", Long.class));
        user.setUsername(resultSet.getObject("username", String.class));
        user.setFullName(resultSet.getObject("full_name", String.class));
        user.setEmail(resultSet.getObject("email", String.class));
        user.setLastLogin(resultSet.getObject("last_login", LocalDateTime.class));

        Role role = new Role();
        role.setId(resultSet.getObject("role_id", Long.class));
        role.setName(UserRole.valueOf(resultSet.getObject("name", String.class)));
        user.setRole(role);

        return user;
    }

}
