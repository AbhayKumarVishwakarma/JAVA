package com.masai.controller;

import com.masai.model.Employee;
import com.masai.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void initEmployee(){
        List<Employee> list = Stream.of(
                new Employee(1, "Ankit", "Senior Developer", 80000),
                new Employee(2, "Suraj", "Senior Developer", 70000),
                new Employee(3, "Raj", "Senior Developer", 70000),
                new Employee(4, "Surya", "Junior Developer", 70000),
                new Employee(5, "Sumit", "Senior Developer", 70000),
                new Employee(6, "Suresh", "Senior Developer", 70000),
                new Employee(7, "Sujeet", "Senior Developer", 70000),
                new Employee(8, "Sudharm", "Senior Developer", 70000)
        ).collect(Collectors.toList());
        employeeRepository.saveAll(list);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> welcomeHandler(){
        initEmployee();
        return new ResponseEntity<>("Welcome to Spring Boot..", HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> employeeHandler(){
        List<Employee> employee = employeeRepository.findAll();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> employeesHandler(){
        List<Employee> employee = employeeRepository.findAll().stream().limit(5).toList();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
