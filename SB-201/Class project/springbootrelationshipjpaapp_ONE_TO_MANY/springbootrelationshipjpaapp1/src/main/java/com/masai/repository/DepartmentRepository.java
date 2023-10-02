package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Department;
import com.masai.model.Employee;

public interface DepartmentRepository extends JpaRepository<Department, Integer>, PagingAndSortingRepository<Department, Integer> {

	@Query("select employees from Department where deptId =?1")
	public List<Employee> getAllEmployesByDeptId(Integer deptId);

	@Query("select e.empId,e.ename,e.email,d.dname,d.location from Employee e INNER JOIN Department d ON d.deptId= e.dept.deptId  AND d.deptId=?1")
	public List<String> getEmpCustomDetails(Integer deptId);
	
}
