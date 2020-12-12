package rubin.ru.dao;

import rubin.ru.model.Report;

import java.util.List;

public interface ReportDao {

    String getFileNameById(Long id);

    List<Report> getReports();

    Long save(Report report);

    void delete(Long id);

    void deleteAll();
}
