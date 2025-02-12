package shakhaev.spring.logging.starter.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import shakhaev.spring.logging.starter.config.LoggingConfig;

@Aspect
public class LogAspect {

    private final LoggingConfig loggingConfig;

    @Autowired
    public LogAspect(LoggingConfig loggingConfig) {
        this.loggingConfig = loggingConfig;
    }

    @Pointcut("@annotation(shakhaev.spring.logging.starter.aop.LoggingMethod)")
    public void loggingMethods() {
    }

    @Before("loggingMethods()")
    public void logBefore(JoinPoint joinPoint) {
        loggingConfig.logMessage("Entering the method: {}", joinPoint.getSignature());
    }

    @After("loggingMethods()")
    public void logAfter(JoinPoint joinPoint) {
        loggingConfig.logMessage("Output of the method: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "loggingMethods()", returning = "result")
    public void handleResult(JoinPoint joinPoint, Object result) {
        loggingConfig.logMessage("After returning {}", joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "loggingMethods()", throwing = "e")
    public void handleException(JoinPoint joinPoint, Exception e) {
        loggingConfig.logMessage("After exception {}", joinPoint.getSignature().toShortString());
        loggingConfig.logMessage("An error occurred: ", e);
    }
}
