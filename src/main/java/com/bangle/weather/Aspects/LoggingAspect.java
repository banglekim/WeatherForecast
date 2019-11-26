package com.bangle.weather.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {
    }

    @Around(value = "executeLogging()")
    public Object logMethodCalled( ProceedingJoinPoint joinPoint ) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnValue= joinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName()).append(", ");
        message.append("execution time = ").append(duration).append("ms, ");
        Object[] args = joinPoint.getArgs();
        if (args!=null && args.length>0) {
            message.append("args =[");
            Arrays.asList(args).forEach(arg -> {
                message.append("arg=").append(arg).append(" | ");
            });
            message.append("]");
        }
        LOGGER.info(message.toString());
        return returnValue;
    }

}
