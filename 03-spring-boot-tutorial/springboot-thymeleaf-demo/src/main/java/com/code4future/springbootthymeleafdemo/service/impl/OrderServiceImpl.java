package com.code4future.springbootthymeleafdemo.service.impl;

import com.code4future.springbootthymeleafdemo.entity.Order;
import com.code4future.springbootthymeleafdemo.repository.custom.OrderRepository;
import com.code4future.springbootthymeleafdemo.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByCustomer(String fullName) {
        return orderRepository.findByCustomer(fullName);
    }
}
