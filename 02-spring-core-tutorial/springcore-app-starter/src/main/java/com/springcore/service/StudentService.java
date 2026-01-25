package com.springcore.service;

import org.springframework.stereotype.Service;

public class StudentService {

    public void save(String name) {
        System.out.println("Saving student: " + name);
    }
}
