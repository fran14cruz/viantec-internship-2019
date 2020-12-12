package rubin.ru.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PointRegister {
    private Long id;
    private Long idMac;
    private Long idName;
    private Long idVendor;
    private Long idSensor;
    private LocalDateTime lastActiveDate;
    private Integer packages;
    private Short frequency;

}
