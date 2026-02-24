package com.code4future.springbootthymeleafdemo.config;

import com.code4future.springbootthymeleafdemo.entity.Customer;
import com.code4future.springbootthymeleafdemo.entity.Employee;
import com.code4future.springbootthymeleafdemo.entity.Order;
import com.code4future.springbootthymeleafdemo.repository.CustomerRepository;
import com.code4future.springbootthymeleafdemo.repository.EmployeeRepository;
import com.code4future.springbootthymeleafdemo.service.EmployeeService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;

    public DataInitializer(EmployeeRepository employeeRepository, CustomerRepository customerRepository) {
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Tom Cruise", "tom@gmail.com", "USA"));
        employees.add(new Employee("Tony Bin", "tony@gmail.com", "USA"));
        employees.add(new Employee("John Doe", "john@gmail.com", "Japan"));
        employees.add(new Employee("Tom Cruise", "tom@gmail.com", "China"));
        employees.add(new Employee("Jane Smith", "jane@gmail.com", "UK"));
        employees.add(new Employee("Mickey Mouse", "mickey@gmail.com", "Turkey"));
        employeeRepository.saveAll(employees);

        //save customer with orders
       Customer customer = new Customer();
       customer.setFullName("Ronaldo");

       Order order1 = new Order(LocalDateTime.now(), "Thach That Ha Noi",  customer);
       Order order2 = new Order(LocalDateTime.now(), "Chuong My Ha Noi",  customer);
       List<Order> orders = Arrays.asList(order1, order2);
       customer.setOrders(orders);
       customerRepository.save(customer);

    }
}
