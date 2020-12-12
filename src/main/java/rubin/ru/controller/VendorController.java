package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import rubin.ru.service.VendorService;
import java.io.IOException;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping(value = "/vendor")
    public void createVendor(
      @RequestParam("file") MultipartFile file
    ) throws IOException {

        vendorService.updateAndSaveVendor(file);

    }
}


