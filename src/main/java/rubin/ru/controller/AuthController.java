package rubin.ru.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import rubin.ru.dto.AuthDto;



@RestController
@RequestMapping("/api")
public class AuthController {

    @RequestMapping(path = "/login")
    public AuthDto sayHello() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        AuthDto authDto = new AuthDto();
        authDto.setUsername(user.getUsername());
        authDto.setToken(RequestContextHolder.currentRequestAttributes().getSessionId());
        return authDto;
    }
}
