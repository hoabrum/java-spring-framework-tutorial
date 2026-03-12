package com.code4future.javafxdemo.service;

import com.code4future.javafxdemo.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<Student> findAll() throws SQLException;
    void insert(Student student) throws SQLException;
    void update(Student student) throws SQLException;
    void delete(int id) throws SQLException;
}
