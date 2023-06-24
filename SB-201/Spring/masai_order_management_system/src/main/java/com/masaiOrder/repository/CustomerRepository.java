package com.masaiOrder.repository;

import com.masaiOrder.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Optional<Customer> findByEmail(String email);
    public Customer findByName(String name);
}
