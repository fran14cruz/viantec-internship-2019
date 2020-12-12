package rubin.ru.dao;

import rubin.ru.dto.UserDto;
import rubin.ru.model.User;

import java.util.List;

public interface UserDao {
    List<UserDto> getUsers();

    Long addUser(UserDto user);

    Long updateUser(Long id, UserDto user);

    Long removeUser(Long id);

    User getUserByUsernameForAuth(String name);

    UserDto getUser(Long id);

    Long updateLastLogin(String username);

}
