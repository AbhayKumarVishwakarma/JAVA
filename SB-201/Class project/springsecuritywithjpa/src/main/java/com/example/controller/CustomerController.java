package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * anyone can access
     * @return a welcome message
     */
    @GetMapping("/hello")
    public String testHandler() {
        return "Welcome to Spring Security";
    }


    /**
     * anyone can access and register himself
     * @param customer
     * @return ResponseEntity with customer
     */
    @PostMapping("/customers")
    public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer registeredCustomer = customerService.registerCustomer(customer);
        return new ResponseEntity<>(registeredCustomer,HttpStatus.ACCEPTED);
    }


    /**
     * access by login user and he/she can search customer by email
     * @param email
     * @return ResponseEntity with customer
     */
    @GetMapping("/customers/{email}")
    public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email){
        Customer customer = customerService.getCustomerDetailsByEmail(email);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    // access by login user

    /**
     * access by login user and he/she can see all customers
     * @return ResponseEntity with list of customers
     */
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomerHandler(){
        List<Customer> customers = customerService.getAllCustomerDetails();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    /**
     * only register user can access and signIn
     * @param auth
     * @return ResponseEntity with message
     */
    @GetMapping("/signIn")
    public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){
        System.out.println(auth); // this Authentication object having Principle object details
        Customer customer = customerService.getCustomerDetailsByEmail(auth.getName());
        return new ResponseEntity<>(customer.getName() + " logged in successfully!", HttpStatus.ACCEPTED);
    }
}
