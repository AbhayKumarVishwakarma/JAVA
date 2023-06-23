package com.masaiOrder.service;

import com.masaiOrder.exception.CustomerException;
import com.masaiOrder.model.Customer;

import java.util.List;

public interface CustomerService {
	public Customer registerCustomer(Customer customer);
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
}
