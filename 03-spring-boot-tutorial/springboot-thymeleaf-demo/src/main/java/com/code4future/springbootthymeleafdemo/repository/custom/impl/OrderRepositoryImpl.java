package com.code4future.springbootthymeleafdemo.repository.custom.impl;

import com.code4future.springbootthymeleafdemo.entity.Customer;
import com.code4future.springbootthymeleafdemo.entity.Order;
import com.code4future.springbootthymeleafdemo.repository.custom.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }

    @Override
    public List<Order> findByCustomer(String fullName) {
        TypedQuery<Order> query = entityManager.createQuery("FROM Order o WHERE o.customer.fullName =: fullName",
                Order.class);
        query.setParameter("fullName", fullName);
        return query.getResultList();
    }
}
