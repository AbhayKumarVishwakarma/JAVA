package com.abd.service;

import com.abd.exception.EmployeeException;
import com.abd.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(Employee employee) throws EmployeeException;
    public Employee updateEmployee(Integer id, Employee employee) throws EmployeeException;
    public Employee deleteEmployee(Integer id) throws EmployeeException;
    public Employee viewEmployee(Integer id) throws EmployeeException;
    public Employee viewEmployeeByEmail(String email) throws EmployeeException;
    public List<Employee> viewAllEmployee() throws EmployeeException;
}
