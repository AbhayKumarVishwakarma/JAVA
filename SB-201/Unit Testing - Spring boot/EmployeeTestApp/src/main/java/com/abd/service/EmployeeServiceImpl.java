package com.abd.service;

import com.abd.exception.EmployeeException;
import com.abd.model.Employee;
import com.abd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    /**
     * @param employee
     * @return
     */
    @Override
    public Employee registerEmployee(Employee employee) {
        return repository.save(employee);
    }

    /**
     * @param employeeId
     * @param address
     * @return
     * @throws EmployeeException
     */
    @Override
    public Employee updateAddress(Integer employeeId, String address) throws EmployeeException {

        Employee employee = repository.findById(employeeId).orElseThrow(() -> new EmployeeException("Not find employee with id: " + employeeId));
        if(address == null) throw new EmployeeException("Something went wrong! please provide valid address!");

        employee.setAddress(address);
        return repository.save(employee);
    }

    /**
     * @param employeeId
     * @return
     * @throws EmployeeException
     */
    @Override
    public Employee viewEmployee(Integer employeeId) throws EmployeeException {
        Employee employee = repository.findById(employeeId).orElseThrow(() -> new EmployeeException("Not find employee with id: " + employeeId));
        return employee;
    }

    /**
     * @return
     * @throws EmployeeException
     */
    @Override
    public List<Employee> viewAllEmployee() throws EmployeeException {
        List<Employee> list = repository.findAll();
        if(list.isEmpty()) throw new EmployeeException("Not found any employee!");
        return list;
    }

    /**
     * @param employeeId
     * @return
     * @throws EmployeeException
     */
    @Override
    public Employee deleteEmployee(Integer employeeId) throws EmployeeException {
        Employee employee = repository.findById(employeeId).orElseThrow(() -> new EmployeeException("Not find employee with id: " + employeeId));
        repository.delete(employee);
        return employee;
    }
}
