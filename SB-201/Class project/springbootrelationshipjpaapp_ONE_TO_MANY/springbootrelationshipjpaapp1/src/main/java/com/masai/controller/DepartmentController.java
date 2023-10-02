package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Department;
import com.masai.model.Employee;
import com.masai.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
/*
	
{
    "dname": "Marketing",
    "location": "kolkata",
    "employees": [

        {
            "ename": "Amit",
            "email": "amit@gmail.com",
            "salary": 80000,
            "gender": "MALE",
            "address": {
                "city": "coimbtor",
                "state": "Tamilnadu",
                "pincode": "234213123"
            }
        },


        {
            "ename": "Ravi",
            "email": "ravi@gmail.com",
            "salary": 82000,
            "gender": "MALE",
            "address": {
                "city": "patna",
                "state": "Bihar",
                "pincode": "897878"
            }
        }


    ]
}
	*/
	 
	@PostMapping("/departments")
	public ResponseEntity<Department> addNewDepartmentHandler(@RequestBody Department department){
		List<Employee> employees= department.getEmployees();
		
		//linking/associating all the employee with their deprtment
		for(Employee emp:employees) emp.setDept(department); 
		Department savedDept= departmentService.addNewDepartment(department); 
		return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
	} 
}
