package com.springboot.service.impl;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isLoggedIn(String email, String password) {
        User entityUser = userRepository.findByEmailAndPassword(email, password);
        return (entityUser != null);
    }

    @Override
    public List<User> fetchAllUsers() {
        return (List<User>)userRepository.findAll();
    }
}
