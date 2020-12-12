package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rubin.ru.model.Report;
import rubin.ru.service.ReportService;

import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/report/{id}")
    public ResponseEntity<Resource> getOneReport(@PathVariable Long id) throws IOException {
        Resource resource = reportService.getReportFile(id);
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping(value = "/report")
    public List<Report> getReports() {
        return reportService.getReports();
    }

    @PostMapping(value = "/report")
    public Long createReport(@RequestBody Report report) {
        return reportService.save(report);
    }

    @DeleteMapping(value = "/report/{id}")
    public void delete(@PathVariable Long id) throws IOException {
        reportService.delete(id);
    }

    @DeleteMapping(value = "/report")
    public void deleteAll() throws IOException {
        reportService.deleteAll();
    }
}
