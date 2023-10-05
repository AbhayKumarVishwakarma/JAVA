package com.abd.service;

import com.abd.exception.EmployeeException;
import com.abd.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee registerEmployee(Employee employee);

    public Employee updateAddress(Integer employeeId, String address) throws EmployeeException;

    public Employee viewEmployee(Integer employeeId) throws EmployeeException;

    public List<Employee> viewAllEmployee() throws EmployeeException;

    public Employee deleteEmployee(Integer employeeId) throws EmployeeException;
}
