package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	/**
	 * any logged-in user can access (ADMIN,USER)
	 * @return welcome message of type String
	 */
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
        "role": "admin"
    }
	 */
	
	// add another Customer with only the role "user"

	/**
	 * any user can access and create a account
	 * @param customer
	 * @return response entity of saved customers
	 */
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customer.setRole("ROLE_"+customer.getRole().toUpperCase());
		Customer registeredCustomer= customerService.registerCustomer(customer);
		return new ResponseEntity<>(registeredCustomer,HttpStatus.ACCEPTED);
	}

	/**
	 * any logged-in user can access (ADMIN,USER)
	 * @return welcome message of type String
	 */
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email){
		Customer customer= customerService.getCustomerDetailsByEmail(email);
		return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
		
	}

	/**
	 * only those customer can access that have role of ADMIN
	 * @return response entity of list of customer
	 */
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler(){
		List<Customer> customers= customerService.getAllCustomerDetails();
		return new ResponseEntity<>(customers,HttpStatus.ACCEPTED);
		
	}

	/**
	 * any register customer can access for sign-in
	 * @param auth
	 * @return
	 */
	@GetMapping("/signIn")
	public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){
		System.out.println(auth); // this Authentication object having Principle object details
		 Customer customer= customerService.getCustomerDetailsByEmail(auth.getName());
		 return new ResponseEntity<>(customer.getName()+" logged In Successfully", HttpStatus.ACCEPTED);
	}
}
