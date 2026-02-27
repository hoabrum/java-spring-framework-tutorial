package com.code4future.springbootthymeleafdemo.repository;

import com.code4future.springbootthymeleafdemo.dto.response.CustomerResponse;
import com.code4future.springbootthymeleafdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT new com.code4future.springbootthymeleafdemo.dto.response.CustomerResponse(c.fullName, o.id, o.shippingAddress)"
            + "  FROM Customer c JOIN c.orders o")
    List<CustomerResponse> fetchCustomersWithOrders();

    @Query(" SELECT COUNT(c) FROM Customer c JOIN c.orders o")
    Long countCustomersWithOrders();

    @Query(value = "SELECT * \n" +
            "FROM Customers c WHERE c.Customer_ID IN\n" +
            "(\n" +
            "     SELECT Customer_ID FROM Orders\n" +
            ")", nativeQuery = true)
    List<Customer> fetchCustomerWithOrdersNativeQuery();
}
