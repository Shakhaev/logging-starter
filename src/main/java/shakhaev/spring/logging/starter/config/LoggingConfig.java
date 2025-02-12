package shakhaev.spring.logging.starter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Slf4j
@Configuration
public class LoggingConfig {

    private final HashMap<String, String> loggingLevel;

    public LoggingConfig(HashMap<String, String> loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public String getLevel(String key) {
        return loggingLevel.getOrDefault(key, "INFO");
    }

    public HashMap<String, String> getLoggingLevel() {
        return loggingLevel;
    }

    public void logMessage(String message, Object... args) {
        String loggingLevel = getLevel("level").toUpperCase();

        switch (loggingLevel) {
            case "DEBUG":
                log.debug(message, args);
                break;
            case "INFO":
                log.info(message, args);
                break;
            case "WARN":
                log.warn(message, args);
                break;
            case "ERROR":
                log.error(message, args);
                break;
            default:
                log.info(message, args);
        }
    }
}
