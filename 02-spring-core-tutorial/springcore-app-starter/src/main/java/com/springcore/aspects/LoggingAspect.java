package com.springcore.aspects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
@Aspect
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* com.springcore.service.StudentService.save(..))")
    public void logBefore() {
        logger.info("LoggingAspect.logBefore execution of student's save()");
    }
    @After("execution(* com.springcore.service.StudentService.save(..))")
    public void logAfter() {
        logger.info("LoggingAspect.logAfter execution of student's save()");
    }
}
