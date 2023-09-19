package com.abd.controller;

import com.abd.model.Employee;
import com.abd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/welcome")
    public String welcomeHandler() {
        return "Welcome to Rest API with JWT Authentication application...";
    }

    @PostMapping("/employee/register")
    public ResponseEntity<Employee> saveEmployeeHandler(@RequestBody Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setRole("ROLE_" + employee.getRole().toUpperCase());
        Employee emp = employeeService.createEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("/employee/signIn")
    public ResponseEntity<String> loggedInEmployeeHandler(Authentication auth){
        System.out.println(auth);
        Employee emp = employeeService.viewEmployeeByEmail(auth.getName());
        return new ResponseEntity<>(emp.getName() + " logged In Successfully!", HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeHandler(@RequestBody Employee employee, @PathVariable Integer id){
        Employee emp = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deleteEmployeeHandler(@PathVariable Integer id){
        Employee emp = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> viewEmployeeHandler(@PathVariable Integer id){
        Employee emp = employeeService.viewEmployee(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> viewAllEmployeeHandler(){
        List<Employee> list = employeeService.viewAllEmployee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
