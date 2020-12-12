package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rubin.ru.model.Device;
import rubin.ru.model.DeviceSearch;
import rubin.ru.service.DeviceService;
import rubin.ru.model.DeviceDto;

import java.util.List;


@RestController
@RequestMapping("/api")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping(value = "/device")
    public List<Device> getDevices() {
        return deviceService.getDevices();
    }

    @PostMapping(value = "/device")
    public Long addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @PutMapping(value = "/device/{id}")
    public Long updateDevice(@PathVariable Long id, @RequestBody Device device) {
        return deviceService.updateDevice(id, device);
    }

    @DeleteMapping(value = "/device/{id}")
    public Long removeDevice(@PathVariable Long id) {
        return deviceService.removeDevice(id);
    }

    @PutMapping(value = "/device/accessCheck")
    public DeviceSearch accessCheckDevice(@RequestBody DeviceDto deviceDto) {
        return deviceService.accessCheckDevice(deviceDto);
    }

}
