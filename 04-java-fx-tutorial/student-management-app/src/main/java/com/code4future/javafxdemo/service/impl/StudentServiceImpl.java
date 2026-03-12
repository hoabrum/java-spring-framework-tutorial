package com.code4future.javafxdemo.service.impl;

import com.code4future.javafxdemo.dao.StudentDao;
import com.code4future.javafxdemo.entity.Student;
import com.code4future.javafxdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        return studentDao.findAll();
    }

    @Override
    public void insert(Student student) throws SQLException {
        studentDao.insert(student);
    }

    @Override
    public void update(Student student) throws SQLException {
        studentDao.update(student);
    }

    @Override
    public void delete(int id) throws SQLException {
        studentDao.delete(id);
    }
}
