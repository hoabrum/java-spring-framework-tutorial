package com.springcore.config;

import com.springcore.aspects.LoggingAspect;
import com.springcore.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.springcore")
public class AppConfig {
    @Bean
    public StudentService studentService() {
        return new StudentService();
    }
    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
