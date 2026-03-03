package com.code4future.springbootthymeleafdemo;

import com.code4future.springbootthymeleafdemo.dto.response.CustomerResponse;
import com.code4future.springbootthymeleafdemo.entity.Customer;
import com.code4future.springbootthymeleafdemo.entity.Order;
import com.code4future.springbootthymeleafdemo.repository.CustomerRepository;
import com.code4future.springbootthymeleafdemo.repository.custom.OrderRepository;
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
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void contextLoads() {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setShippingAddress("FPTU Hoa Lac Ha Noi");
        orderRepository.save(order);

        //List<CustomerResponse> customers = customerRepository.fetchCustomersWithOrders();
        //System.out.println(customers);
        //Long totalOrders = customerRepository.countCustomersWithOrders();
        //System.out.println(totalOrders);
        //List<Customer> customers = customerRepository.fetchCustomerWithOrdersNativeQuery();
    }

}
