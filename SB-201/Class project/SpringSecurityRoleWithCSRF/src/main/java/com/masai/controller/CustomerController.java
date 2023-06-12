package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/hello")
	public String testHandler() {
		return "Welcome to Spring Security";
	}
	
	/*
	  {
        "name": "ram",
        "email": "ram@gmail.com",
        "password": "1234",
        "address": "delhi",
        "role": "ROLE_ADMIN"
    }
	 */
	// add another Customer with only the role "ROLE_USER"
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customer.setRole("ROLE_" + customer.getRole().toUpperCase());
		Customer registeredCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<>(registeredCustomer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email){
		Customer customer = customerService.getCustomerDetailsByEmail(email);
		return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler(){
		List<Customer> customers = customerService.getAllCustomerDetails();
		return new ResponseEntity<>(customers,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/signIn")
	public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){
		System.out.println(auth); // this Authentication object having Principle object details
		Customer customer = customerService.getCustomerDetailsByEmail(auth.getName());
		return new ResponseEntity<>(customer.getName() + " logged In Successfully", HttpStatus.ACCEPTED);
	}

	@PostMapping("/contact")
	public String postDemo1() {
		return "Not harm full POST operation";
	}
	
	@PutMapping("/notice")
	public String putDemo1() {
		return "Not harm full PUT operation";
	}
	
	@PostMapping("/writeUs")
	public String postDemo3() {
		return "It is harm full POST operation";
	}
	
	
}
