package com.code4future.springbootthymeleafdemo.service.impl;

import com.code4future.springbootthymeleafdemo.entity.Employee;
import com.code4future.springbootthymeleafdemo.exception.RecordNotFoundException;
import com.code4future.springbootthymeleafdemo.repository.EmployeeRepository;
import com.code4future.springbootthymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }
    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Employee with id " + id + " not found"));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
