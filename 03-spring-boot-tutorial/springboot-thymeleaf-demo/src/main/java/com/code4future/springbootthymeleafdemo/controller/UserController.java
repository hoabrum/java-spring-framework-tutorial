package com.code4future.springbootthymeleafdemo.controller;

import com.code4future.springbootthymeleafdemo.dto.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute UserForm userForm){
        System.out.println(userForm);
        return "register";
    }
}
