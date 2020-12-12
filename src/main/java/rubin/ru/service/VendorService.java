package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import rubin.ru.model.Vendor;
import rubin.ru.dao.VendorDao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class VendorService {

    @Autowired
    private VendorDao vendorDao;

    @Value("${upload.path}")
    private String uploadPath;

    public void updateAndSaveVendor(MultipartFile file) throws IOException {
        String pathFile = saveFileCreatePath(file);
        processFile(pathFile);
        deleteFile(pathFile);
    }

    private String saveFileCreatePath(MultipartFile file) throws IOException {

        String pathFile = null;

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            pathFile = uploadDir.getAbsolutePath() +  "/" + UUID.randomUUID().toString() + "." + file.getOriginalFilename();
            file.transferTo(new File(pathFile));
        }
        return pathFile;
    }

    private void processFile(String path) throws IOException {

        Vendor vendor = new Vendor();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("(hex)")) {
                String[] macInfo = line.trim().split("  +|\\t+"); //split by space or tab
                vendor.setName(macInfo[2]);
                vendor.setShortMac(macInfo[0].replaceAll("-", ":"));
                vendorDao.update(vendor);
            }
        }
        br.close();
    }

    private void deleteFile(String path) throws IOException {
        Files.deleteIfExists(Paths.get(path));
    }
}



