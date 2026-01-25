package com.springboot.service.impl;

import com.springboot.service.LoginService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private Environment env;
    public LoginServiceImpl(Environment evn) {
        this.env = evn;
    }

    @Override
    public boolean isLoggedIn(String email, String password) {
        String username = env.getProperty("login.username");
        String inputPassword = env.getProperty("login.password");

        if (email.equals(username) && password.equals(inputPassword)) {
            return true;
        }
        return false;
    }
}
