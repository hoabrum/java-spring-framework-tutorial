package com.springboot.controller;

import com.springboot.entity.User;
import com.springboot.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/home")
    public String home(HttpServletRequest req) {
        System.out.println("Home Page");
        String year = req.getParameter("year");

        List<User> users = loginService.fetchAllUsers();

        HttpSession session = req.getSession();
        String loggedInUser = (String) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }
        String message = "Welcome " + loggedInUser;
        req.setAttribute("message", message);
        req.setAttribute("users", users);
        return "home";
    }
}
