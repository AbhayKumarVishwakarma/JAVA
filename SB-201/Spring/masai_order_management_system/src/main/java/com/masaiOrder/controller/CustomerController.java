package com.masaiOrder.controller;

import com.masaiOrder.model.Customer;
import com.masaiOrder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/masaiOrder")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/welcome")
    public String testHandler() {
        return "Welcome to Masai Order Management System";
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRole("ROLE_" + customer.getRole().toUpperCase());
        Customer registeredCustomer = customerService.registerCustomer(customer);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/user/login")
    public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){
        System.out.println(auth);  // this Authentication object having Principle object details
        Customer customer = customerService.getCustomerDetailsByEmail(auth.getName());
        return new ResponseEntity<>(customer.getName() + " logged In Successfully", HttpStatus.OK);
    }

}
