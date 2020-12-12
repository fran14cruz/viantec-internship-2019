package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rubin.ru.dto.UserDto;
import rubin.ru.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user/{id}")
    public @ResponseBody
    UserDto getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/user")
    public Long addUser(@RequestBody UserDto user) throws IllegalArgumentException {
        return userService.addUser(user);
    }

    @PutMapping(value = "/user/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserDto user) throws IllegalArgumentException {
        return userService.updateUser(id, user);
    }

    @DeleteMapping(value = "/user/{id}")
    public Long removeUser(@PathVariable Long id) {
        return userService.removeUser(id);
    }


}
