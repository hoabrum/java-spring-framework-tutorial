package com.code4future.javafxdemo.config;

import com.code4future.javafxdemo.utils.DbUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
@ComponentScan("com.code4future.javafxdemo")
public class AppConfig {

    @Bean
    public Connection connection() {
        return DbUtil.getConnection();
    }
}
