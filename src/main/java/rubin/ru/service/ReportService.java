package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import rubin.ru.dao.ReportDao;
import rubin.ru.model.Report;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Path;

@Service
public class ReportService {

    @Autowired
    private ReportDao reportDao;

    @Value("${reportFolder.path}")
    private String reportFolderPath;

    public Resource getReportFile(Long id) throws IOException {

        Path filePath = createPathToFile(reportDao.getFileNameById(id));
        return new UrlResource(filePath.toUri());
    }

    public List<Report> getReports() {
        return reportDao.getReports();
    }

    public Long save(Report report) {
        return reportDao.save(report);
    }

    public void delete(Long reportId) throws IOException { //from folder and database

        deleteFile(createPathToFile(reportDao.getFileNameById(reportId)));
        reportDao.delete(reportId);
    }

    public void deleteAll() throws IOException {  //from folder and database

        for(Report report : reportDao.getReports()) {
            deleteFile(createPathToFile(report.getFileName()));
        }
        reportDao.deleteAll();
    }

    private Path createPathToFile(String fileName) {
        return Paths.get(reportFolderPath + "/" + fileName);
    }

    private void deleteFile(Path filePath) throws IOException {
        Files.deleteIfExists(filePath);
    }
}
