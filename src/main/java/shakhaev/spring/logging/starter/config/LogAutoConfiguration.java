package shakhaev.spring.logging.starter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shakhaev.spring.logging.starter.aop.LogAspect;

@Configuration
@EnableConfigurationProperties(LogProperties.class)
public class LogAutoConfiguration {

    private final LogProperties logProperties;

    public LogAutoConfiguration(LogProperties logProperties) {
        this.logProperties = logProperties;
    }

    @Bean
    public LoggingConfig loggingConfig() {
        return new LoggingConfig(logProperties.getLoggingLevel());
    }

    @Bean
    @ConditionalOnProperty(name = "logging.custom.enabled", havingValue = "true", matchIfMissing = false)
    public LogAspect logAspect(LoggingConfig loggingConfig) {
        return new LogAspect(loggingConfig);
    }
}
