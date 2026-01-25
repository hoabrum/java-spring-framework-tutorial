package com.springboot.controller;

import com.springboot.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private LoginService loginService;
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("login page");
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean isLoggedIn = loginService.isLoggedIn(email, password);
        if (isLoggedIn) {
            return "redirect:/home";
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("loggedInUser", email);
        request.setAttribute("error", "Invalid email or password");
        return "login";
    }
}
