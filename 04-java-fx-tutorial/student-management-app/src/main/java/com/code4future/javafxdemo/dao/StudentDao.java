package com.code4future.javafxdemo.dao;

import com.code4future.javafxdemo.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> findAll() throws SQLException;
    void insert(Student student) throws SQLException;
    void update(Student student) throws SQLException;
    void delete(int id) throws SQLException;
}
