package rubin.ru.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ClientEvent {

    private Long id;
    private Long idMac;
    private Long idPoint;
    private Long idPos;
    private Integer flat; //TODO: Подумать нужно ли? Так как есть позиция
    private LocalDateTime firstDateTime;
    private LocalDateTime lastDateTime;
    private Boolean active;
    private Integer packages;
    private Integer frequency;
    private PointList pointList;
    private Integer level;

}