package rubin.ru.model;

import lombok.Getter;
import lombok.Setter;
import rubin.ru.dao.enums.UserRole;

@Getter
@Setter
public class Role {

    private Long id;
    private UserRole name;

}
