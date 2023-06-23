package com.madhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhu.entituy.Employee;
import com.madhu.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo er;
	
	
	public List<Employee> getAll(){
		
		return er.findAll();
		
	}
	
	
	public Employee save(Employee emp) {
		
		
		return er.save(emp);
	}
	
	public Employee update(Employee emp) {
		
		return er.save(emp);
		
	}
	
	public Employee getEmployeebyId(Long id) {
		return er.findById(id).get();
	}
	
}
