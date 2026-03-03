package com.code4future.springbootthymeleafdemo.controller;

import com.code4future.springbootthymeleafdemo.entity.Order;
import com.code4future.springbootthymeleafdemo.repository.custom.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/add")
    public @ResponseBody String  createOrder() {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setShippingAddress("FPT University Thach That");
        orderRepository.save(order);
        return order.toString();
    }

    @GetMapping("/filter/{fullName}")
    public @ResponseBody List<Order> fetOrdersByCustomer(@PathVariable String fullName) {
        List<Order> orders = orderRepository.findByCustomer(fullName);
        return orders;
    }
}
