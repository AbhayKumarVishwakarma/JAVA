package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;
import com.masai.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	 
	/*
	
	POST: http://localhost:8080/employees/2
	
	{
            "ename": "Mukesh",
            "email": "mukesh@gmail.com",
            "salary": 78000,
            "gender": "MALE",
            "address": {
                "city": "delhi",
                "state": "delhi",
                "pincode": "997878"
            }
 } 
	*/

	@PostMapping("/employees/{deptId}")
	public ResponseEntity<Employee> registerEmployeeInDepartment(@PathVariable Integer deptId, @RequestBody Employee employee){
		Employee savedEmp= empService.addEmployeeInDepartment(deptId, employee);
		return new ResponseEntity<>(savedEmp, HttpStatus.CREATED); 
	}
	 
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmpByDeptIdHandler(@RequestParam("deptId") Integer deptId){
		List<Employee> emps= empService.getAllEmployeesByDepartmentId(deptId);
		return new ResponseEntity<>(emps,HttpStatus.OK);
	}
	
	@GetMapping("/departments/{deptId}/employees")
	public ResponseEntity<List<String>> getCustomEmpHandler(@PathVariable("deptId") Integer deptId){
		List<String> result= empService.getEmployeeCustomDetails(deptId);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
