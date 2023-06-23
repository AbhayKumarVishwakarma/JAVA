package com.masaiOrder.service;

import com.masaiOrder.exception.CustomerException;
import com.masaiOrder.model.Customer;
import com.masaiOrder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException {
		return customerRepository.findByEmail(email).orElseThrow(() -> new CustomerException("Customer Not found with Email: " + email));
	}

}
