package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    /**
     * anyone can access
     * @return message type of string
     */
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<String>("Welcome to Masai App without security", HttpStatus.ACCEPTED);
    }

    /**
     * only login user can access
     * @return message type of string
     */
    @GetMapping("/welcomeP")
    public ResponseEntity<String> welcomeP(){
        return new ResponseEntity<String>("Welcome to Masai App with Security", HttpStatus.ACCEPTED);
    }

    /**
     * only login admin can access
     * @return message type of string
     */
    @GetMapping("/admin")
    public ResponseEntity<String> admin(){
        return new ResponseEntity<>("Welcome to Masai app for admin", HttpStatus.ACCEPTED);
    }
}
