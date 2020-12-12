package rubin.ru.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import rubin.ru.model.Report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ReportMapper implements RowMapper {

    @Override
    public Report mapRow(ResultSet rs, int i) throws SQLException {
        Report report = new Report();

        report.setId(rs.getObject("id", Long.class));
        report.setFileName(rs.getObject("file_name", String.class));
        report.setIdPoint(rs.getObject("id_point", Long.class));
        report.setCreateDateTime(rs.getObject("create_date_time", LocalDateTime.class));

        return report;
    }
}
