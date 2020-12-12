package rubin.ru.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rubin.ru.dto.DataDto;
import rubin.ru.service.DataService;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping(value = "/data")
    public void dataCollect(@RequestBody List<DataDto> dataDtos) {
        dataService.createAndSavePoints(dataDtos);
    }

}
