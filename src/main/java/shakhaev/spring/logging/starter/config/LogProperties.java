package shakhaev.spring.logging.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;

@ConfigurationProperties(prefix = "logging.custom")
public class LogProperties {

    private boolean enabled;
    private HashMap<String, String> loggingLevel;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public HashMap<String, String> getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(HashMap<String, String> loggingLevel) {
        this.loggingLevel = loggingLevel;
    }
}
