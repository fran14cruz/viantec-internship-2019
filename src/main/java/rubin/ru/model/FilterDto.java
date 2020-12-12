package rubin.ru.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDto {

    private Long id;
    private Long userId;
    private String name;
    private String fields;

}
