package rubin.ru.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import rubin.ru.dao.enums.Coding;
import rubin.ru.dao.enums.DeviceType;

import java.time.LocalDateTime;

@Getter
@Setter
public class DataDto {
    @JsonProperty("Name_dev")
    private String name;
    @JsonProperty("Datatime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    @JsonProperty("Pacets")
    private Integer packages;
    @JsonProperty("Mac_Rasp")
    private String deviceMac;
    @JsonProperty("Level")
    private Short level;
    @JsonProperty("Coding")
    private Coding coding;
    @JsonProperty("Freq")
    private Short frequency;
    @JsonProperty("Type_dev")
    private DeviceType deviceType;
    @JsonProperty("Mac_dev")
    private String mac;
    @JsonProperty("Ip_Rasp")
    private String ip;
}
