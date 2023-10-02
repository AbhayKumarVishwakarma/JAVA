package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Department;
import com.masai.model.Employee;
import com.masai.repository.DepartmentRepository;
import com.masai.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Employee addEmployeeInDepartment(Integer deptId, Employee employee) {
		Optional<Department> opt= deptRepo.findById(deptId);
		if(opt.isPresent()) {
			Department dept= opt.get();
			
			//associating emp with dept
			employee.setDept(dept);
			
			//associating dept with emp
			
			dept.getEmployees().add(employee);
			return empRepo.save(employee);
		}
		else throw new IllegalArgumentException("Invalid Department Details");
		
	}

	@Override
	public List<Employee> getAllEmployeesByDepartmentId(Integer deptId) {
		
//		Optional<Department> opt= deptRepo.findById(deptId);
//		
//		if(opt.isPresent()) {
//			
//			Department dept= opt.get();
//			
//			return dept.getEmployees();
//		}
//		
//		throw new IllegalArgumentException("Invalid Dept Id");
		
		return deptRepo.getAllEmployesByDeptId(deptId);
	}



	@Override
	public List<String> getEmployeeCustomDetails(Integer deptId) {
		return deptRepo.getEmpCustomDetails(deptId);
	}

}
