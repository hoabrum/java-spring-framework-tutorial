package com.code4future.springbootthymeleafdemo.controller;

import com.code4future.springbootthymeleafdemo.dto.LoginForm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login(Model model) {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("loginForm", new LoginForm());
        return mv;
    }


    @PostMapping("/login")
    public String doLogin(@ModelAttribute LoginForm loginForm) {
        System.out.println(loginForm);
        return "redirect:/home";
    }
}
