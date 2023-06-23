package com.madhu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.entituy.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
