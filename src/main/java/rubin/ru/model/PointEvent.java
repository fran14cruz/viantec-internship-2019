package rubin.ru.model;

import lombok.Getter;
import lombok.Setter;
import rubin.ru.dao.enums.Coding;

import java.time.LocalDateTime;

@Getter
@Setter
public class PointEvent {

    private Long id;
    private Long idMac;
    private Long idPos;
    private Integer flat; //TODO: Подумать нужно ли? Так как есть позиция
    private LocalDateTime firstDateTime;
    private LocalDateTime lastDateTime;
    private Boolean active;
    private Coding coding;
    private Integer packages;
    private Integer frequency;
    private PointList pointList;
    private Integer level;

}
