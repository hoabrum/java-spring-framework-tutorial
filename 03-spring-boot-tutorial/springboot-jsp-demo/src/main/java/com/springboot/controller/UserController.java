package com.springboot.controller;

import com.springboot.entity.User;
import com.springboot.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-details")
    public String userDetails(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        User user = userService.fetchUserDetails(id);
        request.setAttribute("user", user);
        return "user-details";
    }

    @GetMapping("/add-user")
    public String gotoAddUser(HttpServletRequest request) {
        return "add-user";
    }

    @PostMapping("/add-user")
    public String addUser(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        User user = new User(email, password, address);
        userService.saveUser(user);
        return "redirect:/home";
    }
}
