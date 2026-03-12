package com.code4future.javafxdemo.dao.impl;

import com.code4future.javafxdemo.dao.StudentDao;
import com.code4future.javafxdemo.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final Connection con;

    @Autowired
    public StudentDaoImpl(Connection con) {
        this.con = con;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        PreparedStatement pst = con.prepareStatement("SELECT id, name, phone, course FROM registration");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Student st = new Student();
            st.setId(rs.getString("id"));
            st.setName(rs.getString("name"));
            st.setPhone(rs.getString("phone"));
            st.setCourse(rs.getString("course"));
            students.add(st);
        }
        return students;
    }

    @Override
    public void insert(Student student) throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT INTO registration(name, phone, course) VALUES (?, ?, ?)");
        pst.setString(1, student.getName());
        pst.setString(2, student.getPhone());
        pst.setString(3, student.getCourse());
        pst.executeUpdate();
    }

    @Override
    public void update(Student student) throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE registration SET name = ?, phone = ?, course = ? WHERE id = ?");
        pst.setString(1, student.getName());
        pst.setString(2, student.getPhone());
        pst.setString(3, student.getCourse());
        pst.setInt(4, Integer.parseInt(student.getId()));
        pst.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement pst = con.prepareStatement("DELETE FROM registration WHERE id = ?");
        pst.setInt(1, id);
        pst.executeUpdate();
    }
}
