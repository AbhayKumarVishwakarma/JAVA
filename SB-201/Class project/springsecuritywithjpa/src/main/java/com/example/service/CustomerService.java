package com.example.service;

import com.example.exception.CustomerException;
import com.example.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer registerCustomer(Customer customer);
    public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
    public List<Customer> getAllCustomerDetails()throws CustomerException;
}
