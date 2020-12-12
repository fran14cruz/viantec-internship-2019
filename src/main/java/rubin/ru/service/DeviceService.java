package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rubin.ru.dao.DeviceDao;
import rubin.ru.model.Device;
import rubin.ru.model.DeviceDto;
import rubin.ru.model.DeviceInfo;
import rubin.ru.model.DeviceSearch;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    public List<Device> getDevices() {
        return deviceDao.getDevices();
    }

    public long addDevice(Device device) {
        return deviceDao.addDevice(device);
    }

    public long updateDevice(Long id, Device device) {
        return deviceDao.updateDevice(id, device);
    }

    public long removeDevice(Long id) {
        return deviceDao.removeDevice(id);
    }

    public DeviceSearch accessCheckDevice(DeviceDto deviceDto) {

        Device device = deviceDao.accessCheckDevice(deviceDto);
        DeviceSearch deviceSearch = new DeviceSearch();

        if (device != null) {
            deviceDao.updateDeviceFirmware(deviceDto);

            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.setIp(device.getIp());
            deviceInfo.setDate(LocalDateTime.now(ZoneOffset.UTC));

            deviceSearch.setSuccess(true);
            deviceSearch.setDeviceInfo(deviceInfo);
        } else {
            deviceSearch.setSuccess(false);
            deviceSearch.setDescription("Sensor for mac: " + deviceDto.getMac() + "not found.");
        }

        return deviceSearch;

    }
}
