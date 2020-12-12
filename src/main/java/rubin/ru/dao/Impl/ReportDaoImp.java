package rubin.ru.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import rubin.ru.dao.ReportDao;
import rubin.ru.dao.mapper.ReportMapper;
import rubin.ru.model.Report;

import java.util.List;

@Component
public class ReportDaoImp implements ReportDao {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public String getFileNameById(Long id) {
        String query = "SELECT file_name FROM report WHERE id = :id";

        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);

        return namedJdbcTemplate.queryForObject(query, parameterSource, String.class);
    }

    @Override
    public List<Report> getReports() {
        String query = "SELECT * FROM report";

        return namedJdbcTemplate.query(query, new ReportMapper());
    }

    @Override
    public Long save(Report report) {
        String query = "INSERT INTO report (file_name, id_point, create_date_time) VALUES (:file_name, :id_point, :create_date_time)";

        KeyHolder holder = new GeneratedKeyHolder();

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("file_name", report.getFileName())
                .addValue("id_point", report.getIdPoint())
                .addValue("create_date_time", report.getCreateDateTime());

        namedJdbcTemplate.update(query, parameterSource, holder);

        return (Long) holder.getKeyList().get(0).get("id");
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM report WHERE id = :id";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", id);

        namedJdbcTemplate.update(query, namedParameters);
    }

    @Override
    public void deleteAll() {
        String query = "TRUNCATE TABLE report";
        namedJdbcTemplate.query(query, new BeanPropertyRowMapper<>(Report.class));
    }

}
