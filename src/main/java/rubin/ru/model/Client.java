package rubin.ru.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Client {

    private Long id;
    private String mac;
    private Long idPoint;
    private Long idVendor;
    private Long idSensor;
    private Long idSensorLast;
    private Long idList; // TODO: В базе status заменить на list
    private LocalDateTime lastActiveDate;

}
