module com.example.studentproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires spring.context;
    requires spring.beans;
    requires spring.core;

    opens com.code4future.javafxdemo to javafx.fxml, spring.core;
    exports com.code4future.javafxdemo;
    exports com.code4future.javafxdemo.config;
    opens com.code4future.javafxdemo.config to spring.core, spring.beans, spring.context;
    exports com.code4future.javafxdemo.controller;
    opens com.code4future.javafxdemo.controller to javafx.fxml, spring.core, spring.beans, spring.context;
    exports com.code4future.javafxdemo.entity;
    opens com.code4future.javafxdemo.entity to javafx.fxml;
    exports com.code4future.javafxdemo.dao;
    exports com.code4future.javafxdemo.dao.impl;
    opens com.code4future.javafxdemo.dao.impl to spring.core, spring.beans, spring.context;
    exports com.code4future.javafxdemo.service;
    exports com.code4future.javafxdemo.service.impl;
    opens com.code4future.javafxdemo.service.impl to spring.core, spring.beans, spring.context;
}
