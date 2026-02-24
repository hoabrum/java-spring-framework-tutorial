package com.code4future.springbootthymeleafdemo.controller;

import com.code4future.springbootthymeleafdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers/{id}")
    public @ResponseBody String deleteCustomer(@PathVariable Long id) {

        customerRepository.deleteById(id);

        return "Customer - id: " + id + " deleted";
    }
}
