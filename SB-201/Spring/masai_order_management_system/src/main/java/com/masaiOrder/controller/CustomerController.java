package com.masaiOrder.controller;

import com.masaiOrder.model.Customer;
import com.masaiOrder.model.Gender;
import com.masaiOrder.repository.CustomerRepository;
import com.masaiOrder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/masaiOrder")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    public void initCustomer(){
        List<Customer> list = Stream.of(
                new Customer("Ankit", "9999999999","Lucknow", Gender.MALE,"ankit@gmail.com","ankit@123","ROLE_ADMIN"),
                new Customer("Suraj", "8889999999","Kanpur",Gender.MALE,"suraj@gmail.com","suraj@123","ROLE_USER"),
                new Customer("Raj", "6666666666","Prayagraj",Gender.MALE,"raj@gmail.com","raj@123","ROLE_USER")
        ).collect(Collectors.toList());
//        customerRepository.saveAll(list);
        list.forEach(customer -> {
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customerService.registerCustomer(customer);
        });
    }

    @GetMapping("/welcome")
    public String testHandler() {
        initCustomer();
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
