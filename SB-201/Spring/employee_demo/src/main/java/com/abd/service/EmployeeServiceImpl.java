package com.abd.service;

import com.abd.exception.EmployeeException;
import com.abd.model.Employee;
import com.abd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) throws EmployeeException {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) throws EmployeeException {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Not found any employee with id: " + id));
        if(employee.getAddress() != null) emp.setAddress(employee.getAddress());
        if(employee.getPassword() != null) emp.setPassword(employee.getPassword());
        return employeeRepository.save(emp);
    }

    @Override
    public Employee deleteEmployee(Integer id) throws EmployeeException {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Not found any employee with id: " + id));
        employeeRepository.delete(emp);
        return emp;
    }

    @Override
    public Employee viewEmployee(Integer id) throws EmployeeException {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Not found any employee with id: " + id));
    }

    @Override
    public Employee viewEmployeeByEmail(String email) throws EmployeeException {
        Optional<Employee> opt = employeeRepository.findByEmail(email);
        if(opt.isPresent()) return opt.get();
        else throw new EmployeeException("Not found any employee with email: " + email);
    }

    @Override
    public List<Employee> viewAllEmployee() throws EmployeeException {
        List<Employee> list = employeeRepository.findAll();
        if(list.isEmpty()) throw new EmployeeException("Not find any employee!");
        return list;
    }
}
