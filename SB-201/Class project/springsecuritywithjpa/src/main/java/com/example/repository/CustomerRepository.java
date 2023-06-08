package com.example.repository;

import java.util.Optional;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Optional<Customer> findByEmail(String email);
}
