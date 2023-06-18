package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		if(customer == null) throw new CustomerException("Not found any customer!");
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException {
		return customerRepository.findByEmail(email).orElseThrow(() -> new CustomerException("Customer not found with Email: " + email));
	}

}
