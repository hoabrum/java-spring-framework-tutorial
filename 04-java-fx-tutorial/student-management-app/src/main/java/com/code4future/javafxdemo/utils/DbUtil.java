package com.code4future.javafxdemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

    public static Connection getConnection() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
