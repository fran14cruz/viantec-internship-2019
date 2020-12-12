package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rubin.ru.dao.*;
import rubin.ru.dao.enums.DeviceType;
import rubin.ru.dto.DataDto;
import rubin.ru.model.PointRegister;
import rubin.ru.model.Point;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    @Autowired
    private VendorDao vendorDao;

    @Autowired
    private PointListDao pointListDao;

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private PointDao pointDao;

    @Autowired
    private PointRegisterDao pointRegisterDao;

    public void createAndSavePoints(List<DataDto> dataDto) {
        List<PointRegister> pointRegisters = new ArrayList<>();

        for (DataDto dto : dataDto) {
            if (dto.getDeviceType() == DeviceType.BS) {
                Point point = createPoint(dto);
                Long pointId = pointDao.addPoint(point);

                point.setId(pointId);
                PointRegister pointRegister = createPointRegisters(dto, point);

                pointRegisters.add(pointRegister);
            }
        }

        pointRegisterDao.addPointRegisters(pointRegisters);
    }

    private Point createPoint(DataDto dataDto) {
        String mac = dataDto.getMac();
        String ip = dataDto.getIp();
        String pointName = dataDto.getName();
        Long idName = pointDao.getPointNameId(pointName);
        Long deviceId = deviceDao.getDeviceIdByIp(ip);
        deviceDao.updateLastDateTime(ip);

        Point point = new Point();
        point.setMac(mac);
        point.setLastActiveDate(dataDto.getDate());
        point.setIdVendor(vendorDao.getVendorIdByMac(mac.substring(0, 9)));
        point.setIdList(pointListDao.getPointListIdByName("Опасная"));
        point.setIdName(idName == null ? pointDao.addPointName(pointName) : idName);
        point.setIdSensor(deviceId);
        point.setIdSensorLast(deviceId);

        return point;
    }

    private PointRegister createPointRegisters(DataDto dataDto, Point point) {

        PointRegister pointRegister = new PointRegister();
        pointRegister.setIdMac(point.getId());
        pointRegister.setIdName(point.getIdName());
        pointRegister.setIdVendor(point.getIdVendor());
        pointRegister.setIdSensor(point.getIdSensor());
        pointRegister.setLastActiveDate(point.getLastActiveDate());
        pointRegister.setPackages(dataDto.getPackages());
        pointRegister.setFrequency(dataDto.getFrequency());

        return pointRegister;
    }

}
