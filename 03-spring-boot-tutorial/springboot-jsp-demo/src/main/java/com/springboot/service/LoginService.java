package com.springboot.service;

import com.springboot.entity.User;

import java.util.List;

public interface LoginService {

    boolean isLoggedIn(String email, String password);

    List<User> fetchAllUsers();
}
