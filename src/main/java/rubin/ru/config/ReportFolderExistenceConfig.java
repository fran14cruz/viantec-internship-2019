package rubin.ru.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class ReportFolderExistenceConfig {

    @Value("${reportFolder.path}")
    private String reportFolderPath;

    @Bean
    public void createPathToFolder() {
        File reportFolder = new File(reportFolderPath);

        if (!reportFolder.exists()) {
            reportFolder.mkdir();
        }
    }

}
