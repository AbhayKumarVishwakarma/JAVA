package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        System.out.println("Inside home section...");
        return "index";
    }

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

        modelAndView.setViewName("more");

        return modelAndView;
    }
}
