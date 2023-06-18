package com.masai.repository;

import com.masai.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	public Optional<Customer> findByEmail(String email);
}