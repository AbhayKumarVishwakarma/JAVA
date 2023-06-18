package com.masai.controller;

import com.masai.model.Customer;
import com.masai.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/welcome")
	public String welcomeHandler() {
		return "Welcome to Rest API with JWT Authentication application...";
	}
	
	/*
	  {
        "name": "ram",
        "email": "ram@gmail.com",
        "password": "1234",
        "address": "delhi",
        "role": "admin"
    }
	 */
	
	
	@PostMapping("/register")
	public ResponseEntity<Customer> saveCustomerHandler(@Valid  @RequestBody Customer customer){
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customer.setRole("ROLE_" + customer.getRole().toUpperCase());
		Customer registeredCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<>(registeredCustomer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/signIn")
	public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){
		System.out.println(auth);  // this Authentication object having Principle object details
		Customer customer = customerService.getCustomerDetailsByEmail(auth.getName());
		return new ResponseEntity<>(customer.getName() + " logged In Successfully", HttpStatus.ACCEPTED);
	}
}
