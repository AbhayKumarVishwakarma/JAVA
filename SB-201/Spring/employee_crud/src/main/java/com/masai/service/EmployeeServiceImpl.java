package com.masai.service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee addEmployee(Employee e) {
        return repository.save(e);
    }

    @Override
    public Employee updateEmployee(Employee e, Integer id) throws EmployeeException {
//        Optional<Employee> optionalEmployee = repository.findById(id);
//        if(optionalEmployee.isPresent()){
//            Employee e1 = optionalEmployee.get();
//        }else
//            throw new EmployeeException("Employee not found with id ");

        Employee e2 = repository.findById(id).orElseThrow(() -> new EmployeeException("Employee not found with id "));
        return repository.save(e);
    }

    @Override
    public Employee deleteEmployee(Integer id) throws EmployeeException {
        Employee e = repository.findById(id).orElseThrow(() -> new EmployeeException("Employee not found with id "));
        repository.delete(e);
        return e;
    }

    @Override
    public List<Employee> allEmployee() {
        List<Employee> employeeList = repository.findAll();
        if(employeeList.isEmpty()) throw new EmployeeException("Not found any employee");
        return employeeList;
    }

    @Override
    public Employee getEmployeeId(Integer id) throws EmployeeException {
        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeException("Employee not found with id " + id));
        return employee;
    }

    @Override
    public Employee getEmployeeName(String name) throws EmployeeException {
        return repository.findByName(name);
    }
}
