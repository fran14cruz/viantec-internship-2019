package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rubin.ru.dto.ClientEventDto;
import rubin.ru.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientEventController {

    @Autowired
    private ClientService clientService;

    @GetMapping(path = "/clientEvent/{pointId}")
    public List<ClientEventDto> getClientEventByPoint(@PathVariable("pointId") Long pointId) {
        return clientService.getClientEventByPoint(pointId);
    }
}
