package com.masai.service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee e);
    public Employee updateEmployee(Employee e, Integer id) throws EmployeeException;
    public Employee deleteEmployee(Integer id) throws EmployeeException;
    public List<Employee> allEmployee() throws EmployeeException;
    public Employee getEmployeeId(Integer id) throws EmployeeException;
    public Employee getEmployeeName(String name) throws EmployeeException;
}
