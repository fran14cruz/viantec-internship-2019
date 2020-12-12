package rubin.ru.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import rubin.ru.dao.enums.TimeFrame;
import rubin.ru.model.PointList;

import java.time.LocalDateTime;

@Getter
@Setter
public class ClientEventDto {

    private Long id;
    private TimeFrame timeFrame;
    private String mac;
    private String vendor;
    private Integer flat; //TODO: Подумать нужно ли? Так как есть позиция
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime firstDateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastDateTime;
    private Boolean active;
    private Integer packages;
    private String frequency;
    private PointList pointList;
    private Integer level;

}
