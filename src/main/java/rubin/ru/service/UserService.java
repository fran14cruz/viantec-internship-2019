package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rubin.ru.dao.UserDao;
import rubin.ru.dto.UserDto;
import rubin.ru.model.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<UserDto> getUsers() {
        return userDao.getUsers();
    }

    public Long addUser(UserDto user) throws IllegalArgumentException {
        return userDao.addUser(user);
    }

    public Long updateUser(Long id, UserDto user) throws IllegalArgumentException {
        return userDao.updateUser(id, user);
    }

    public Long removeUser(Long id) {
        return userDao.removeUser(id);
    }

    public UserDto getUser(Long id) {
        return userDao.getUser(id);
    }

    public User getUserByNameForAuth(String name) {
        return userDao.getUserByUsernameForAuth(name);
    }

    public Long updateLastLogin(String username) {
        return userDao.updateLastLogin(username);
    }

    public Long getAuthUserId() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = getUserByNameForAuth(userDetails.getUsername());

        return user.getId();
    }
}
