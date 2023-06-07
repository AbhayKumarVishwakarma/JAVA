package com.masai.controller;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.service.EmployeeService;
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

    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee e){
        Employee employee = service.addEmployee(e);
        return new ResponseEntity<>(employee , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee e, @PathVariable Integer id) {
        Employee employee = service.updateEmployee(e, id);
        return new ResponseEntity<>(employee , HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Employee> deleteEmployee(@Valid @RequestParam Integer id){
        Employee employee = service.deleteEmployee(id);
        return new ResponseEntity<>(employee , HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employeeList = service.allEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@Valid @PathVariable Integer id){
        Employee employee = service.getEmployeeId(id);
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }
}
