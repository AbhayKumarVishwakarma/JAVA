package com.one.dto;

public class EmployeeDTOimp implements EmployeeDTO {
      private int empId;
      private String ename;
      private String address;
      private String email;
      private String password;
      private int salary;
      private int deptId;
	public EmployeeDTOimp(int empId, String ename, String address, String email, String password, int salary,
			int deptId) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.address = address;
		this.email = email;
		this.password = password;
		this.salary = salary;
		this.deptId = deptId;
	}
	public EmployeeDTOimp(int empId, String ename, String address, String email, String password, int salary) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.address = address;
		this.email = email;
		this.password = password;
		this.salary = salary;
	}
	@Override
	public int getEmpId() {
		return empId;
	}
	@Override
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Override
	public String getEname() {
		return ename;
	}
	@Override
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int getSalary() {
		return salary;
	}
	@Override
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public int getDeptId() {
		return deptId;
	}
	@Override
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "EmployeeDTOimp [empId=" + empId + ", ename=" + ename + ", address=" + address + ", email=" + email
				+ ", password=" + password + ", salary=" + salary + ", deptId=" + deptId + "]";
	}
}
