package com.code4future.springbootthymeleafdemo.service;

import com.code4future.springbootthymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployee();

    void save(Employee employee);

    Employee findById(Long id);

    void deleteById(Long id);
}
