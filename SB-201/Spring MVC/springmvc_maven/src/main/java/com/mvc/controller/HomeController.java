package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        System.out.println("Inside home section...");
        return "index";
    }


    // Sending data from controller to view (about, help, more)

    /**
     * Using model class
     * Passing the value from controller to jsp page
     * @param model
     * @return
     */
    @GetMapping("/about")
    public String about(Model model){
        System.out.println("Inside about section...");

        model.addAttribute("name", "Suraj");
        model.addAttribute("mobile", "9898989898");

        return "about";
    }

    /**
     * Using modelAndView class
     * Passing the value from controller to jsp page
     * @return
     */
    @GetMapping("/help")
    public ModelAndView help(){
        System.out.println("Inside help section...");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Ankit");
        modelAndView.addObject("rollNo", 330);

        modelAndView.setViewName("help");

        return modelAndView;
    }

    /**
     * Using modelAndView class
     * Passing the value from controller to jsp page with the help of JSP expression
     * @return
     */
    @GetMapping("/more")
    public ModelAndView more(){
        System.out.println("Inside more section...");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("java", "Java was introduces in 1991.");
        modelAndView.addObject("js", "JavaScript is popular for frontend.");

        List<Integer> list = new ArrayList<>();
        list.add(321);
        list.add(362);
        list.add(987);
        list.add(766);
        list.add(123);

        modelAndView.addObject("Mlist", list);

        modelAndView.setViewName("more");

        return modelAndView;
    }


    // Sending data from view to controller

    @GetMapping("/addDetails")
    public String showForm(){
        return "addDetails";
    }

    @PostMapping("/processForm")
    public String formHandler(@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model){
        System.out.println(username +"\n"+ email +"\n"+ password);
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        return "viewDetails";
    }

}
