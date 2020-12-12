package rubin.ru.dao;

import rubin.ru.model.Device;
import rubin.ru.model.DeviceDto;

import java.util.List;

public interface DeviceDao {

    List<Device> getDevices();

    Long addDevice(Device device);

    Long updateDevice(Long id, Device device);

    Long removeDevice(Long id);

    Device accessCheckDevice(DeviceDto deviceDto);

    Long getDeviceIdByIp(String ip);

    void updateDeviceFirmware(DeviceDto deviceDto);

    Long updateLastDateTime(String ip);

}
