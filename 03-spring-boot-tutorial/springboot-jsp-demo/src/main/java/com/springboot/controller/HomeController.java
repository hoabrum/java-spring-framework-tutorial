package com.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/springboot")
public class HomeController {

    @GetMapping("/home")
    //@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpServletRequest req) {
        System.out.println("Home Page");
        String year = req.getParameter("year");

        HttpSession session = req.getSession();
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        String message = "Welcome " + loggedInUser;
        req.setAttribute("message", message);
        return "home";
    }
}
