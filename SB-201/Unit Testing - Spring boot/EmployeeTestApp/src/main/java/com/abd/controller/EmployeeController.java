package com.abd.controller;

import com.abd.model.Employee;
import com.abd.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployeeHandler(@Valid @RequestBody Employee employee){
        Employee registeredEmployee = service.registerEmployee(employee);
        return new ResponseEntity<>(registeredEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployeeHandler(@Valid @PathVariable Integer employeeId, @RequestParam String address){
        Employee updatedEmployee = service.updateAddress(employeeId, address);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<Employee> viewEmployeeHandler(@Valid @PathVariable Integer employeeId){
        Employee employee = service.viewEmployee(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Employee>> viewAllEmployeeHandler(){
        List<Employee> list = service.viewAllEmployee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Employee> deleteEmployeeHandler(@Valid @PathVariable Integer employeeId){
        Employee employee = service.deleteEmployee(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
