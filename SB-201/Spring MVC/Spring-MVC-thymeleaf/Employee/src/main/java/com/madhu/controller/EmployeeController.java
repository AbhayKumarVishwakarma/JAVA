package com.madhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.madhu.entituy.Employee;
import com.madhu.service.EmployeeService;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService es;
	
	
	@GetMapping("/employees/new")
	public String create(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		return "create_Employee";
		
	}
	
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee")Employee emp) {
		
		es.save(emp);
		
		return "redirect:/employees";
		
	}
	
	@GetMapping("/employees/edit/{id}")
	public String getEmployee(@PathVariable Long id, Model model) {
		model.addAttribute("employee",es.getEmployeebyId(id));
		
		return "edit_Employee";
	}
	
	@PostMapping("/employees/{id}")
	public String updateEMployee(@PathVariable Long id, @ModelAttribute("employee") Employee emp, Model model) {
		
		Employee emp1 = es.getEmployeebyId(id);
		
		emp1.setFirstname(emp.getFirstname());
		emp1.setEmail(emp.getEmail());
		emp1.setLastname(emp.getLastname());
		
		es.save(emp1);
		
		return "redirect:/employees";
		
	}
	
	@GetMapping("/employees")
	public String getall(Model model) {
		model.addAttribute("employees",es.getAll());
		return "Employee";
	}
	
	
}
