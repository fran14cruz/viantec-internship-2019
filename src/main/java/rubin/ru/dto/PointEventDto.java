package rubin.ru.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import rubin.ru.dao.enums.Coding;
import rubin.ru.dao.enums.TimeFrame;
import rubin.ru.model.PointList;

import java.time.LocalDateTime;

// TODO: Добавить позицию, пока без нее.
@Getter
@Setter
public class PointEventDto {

    private Long id;
    private TimeFrame timeFrame;
    private String mac;
    private String name;
    private String vendor;
    private Integer flat; //TODO: Подумать нужно ли? Так как есть позиция
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime firstDateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastDateTime;
    private Boolean active;
    private Coding coding;
    private String standard;
    private Integer packages;
    private String frequency;
    private PointList pointList;
    private Integer level;
    private Long count;
    private Long clientCount;
}

