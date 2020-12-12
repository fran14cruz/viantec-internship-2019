package rubin.ru.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Report {

    private Long id;
    private String fileName;
    private Long idPoint;
    private LocalDateTime createDateTime;

}
