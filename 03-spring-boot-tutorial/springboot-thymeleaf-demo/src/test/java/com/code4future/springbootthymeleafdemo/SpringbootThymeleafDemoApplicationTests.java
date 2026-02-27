package com.code4future.springbootthymeleafdemo;

import com.code4future.springbootthymeleafdemo.dto.response.CustomerResponse;
import com.code4future.springbootthymeleafdemo.entity.Customer;
import com.code4future.springbootthymeleafdemo.repository.CustomerRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringbootThymeleafDemoApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
        //List<CustomerResponse> customers = customerRepository.fetchCustomersWithOrders();
        //System.out.println(customers);
        //Long totalOrders = customerRepository.countCustomersWithOrders();
        //System.out.println(totalOrders);
        List<Customer> customers = customerRepository.fetchCustomerWithOrdersNativeQuery();
    }

}
