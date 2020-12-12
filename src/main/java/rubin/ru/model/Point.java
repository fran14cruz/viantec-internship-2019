package rubin.ru.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Point {

    private Long id;
    private String mac;
    private Long idName;
    private Long idVendor;
    private Long idSensor;
    private Long idSensorLast;
    private Long idList;
    private LocalDateTime lastActiveDate;

}

