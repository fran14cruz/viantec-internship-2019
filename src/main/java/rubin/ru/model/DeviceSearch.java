package rubin.ru.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceSearch {

    private Boolean success;
    private String description;
    private DeviceInfo deviceInfo;

}
