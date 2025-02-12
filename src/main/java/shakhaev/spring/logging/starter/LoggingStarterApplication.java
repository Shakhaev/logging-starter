package shakhaev.spring.logging.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@Slf4j
public class LoggingStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggingStarterApplication.class, args);
    }

}
