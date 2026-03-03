package com.code4future.springbootthymeleafdemo.repository.custom;

import com.code4future.springbootthymeleafdemo.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> findAll();

    List<Order> findByCustomer(String fullName);

}
