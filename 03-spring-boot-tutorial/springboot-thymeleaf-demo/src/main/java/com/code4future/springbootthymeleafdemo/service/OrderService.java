package com.code4future.springbootthymeleafdemo.service;

import com.code4future.springbootthymeleafdemo.entity.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);

    List<Order> findAll();

    List<Order> findByCustomer(String fullName);
}
