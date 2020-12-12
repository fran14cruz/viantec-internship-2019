package rubin.ru.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import rubin.ru.model.Role;

import java.time.LocalDateTime;

@Setter
@Getter
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private Role role;
    private String fullName;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLogin;

}
