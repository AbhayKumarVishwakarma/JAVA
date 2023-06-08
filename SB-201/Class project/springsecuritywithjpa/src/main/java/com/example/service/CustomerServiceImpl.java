package com.example.service;

import com.example.exception.CustomerException;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
        return customerRepository.findByEmail(email).orElseThrow(() -> new CustomerException("Customer not found with email " + email));
    }

    @Override
    public List<Customer> getAllCustomerDetails() throws CustomerException {
        List<Customer> list = customerRepository.findAll();
        if(list.isEmpty()) throw new CustomerException("No Customer find");
        return list;
    }
}
