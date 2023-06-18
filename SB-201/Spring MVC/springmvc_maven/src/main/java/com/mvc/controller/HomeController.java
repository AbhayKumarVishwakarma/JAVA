package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        System.out.println("Inside home section...");
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        System.out.println("Inside about section...");
        return "about";
    }
}
