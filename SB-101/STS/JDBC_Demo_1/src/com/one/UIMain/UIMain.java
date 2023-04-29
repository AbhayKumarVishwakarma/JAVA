package com.one.UIMain;

import java.util.List;
import java.util.Scanner;

import com.one.dao.DepartmentDAO;
import com.one.dao.DepartmentDAOimp;
import com.one.dao.EmployeeDAO;
import com.one.dao.EmployeeDAOimp;
import com.one.dto.DepartmentDTO;
import com.one.dto.DepartmentDTOimp;
import com.one.dto.EmployeeDTO;
import com.one.dto.EmployeeDTOimp;
import com.one.exception.NoRecordFoundException;
import com.one.exception.SomethingWentWrongException;

public class UIMain {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			System.out.println("1. Add new department");
			System.out.println("2. Register employee");
			System.out.println("3. Assign department to emp");
			System.out.println("4. Login employee");
			System.out.println("5. Show all department");
			System.out.println("6. Update department location");
			System.out.println("7. Update employee password");
			System.out.println("8. Delete department");
			System.out.println("0. Exit");
			System.out.print("Enter your selection ");
			choice = sc.nextInt();
			
			switch(choice) {
			     case 1:
			    	 addNewDepartmentUI(sc);
			    	 break;
			     case 2:
			    	 registerNewEmpUI(sc);
			    	 break;
			     case 3:
			    	 assignDepTOEmpUI(sc);
			    	 break;
			     case 4:
			    	 loginEmpUI(sc);
			    	 break;
			     case 5:
			    	 showAllDepUI();
			    	 break;
			     case 6:
			    	 updateDepLocationUI(sc);
			    	 break;
			     case 7:
			    	 updateEmpPasswordUI(sc);
			    	 break;
			     case 8:
			    	 deleteDepUI(sc);
			         break;
			     case 0:
			    	 System.out.println("Thanks for using our service");
			    	 break;
			     default:
			         System.out.println("Bye Bye");
			         break;
			}
			
		}while(choice != 0);
		sc.close();
	}

	static void deleteDepUI(Scanner sc) {
		System.out.print("Enter ID ");
		int id = sc.nextInt();
		
		DepartmentDAO depDAO = new DepartmentDAOimp();
		
		try {
			depDAO.deleteDepByID(id);
			System.out.println("Department deleted successfully");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	static void updateEmpPasswordUI(Scanner sc) {
		System.out.print("Enter empId ");
		int empId = sc.nextInt();
		System.out.print("Enter New password ");
		String password = sc.next();
		
        EmployeeDAO empDAO = new EmployeeDAOimp();
		
		try {
			empDAO.updateEmpPassword(empId, password);
			System.out.println("Employee password updated successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void updateDepLocationUI(Scanner sc) {
		System.out.print("Enter empID ");
		int dId = sc.nextInt();
		System.out.print("Enter location ");
		String location = sc.next();
		
        DepartmentDAO depDAO = new DepartmentDAOimp();
		
		try {
			depDAO.updateDepLocation(dId, location);
			System.out.println("Department location updated successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	static void showAllDepUI() {
		DepartmentDAO depDAO = new DepartmentDAOimp();
		try {
			List<DepartmentDTO> list = depDAO.showAllDepatment();
			list.forEach(t -> System.out.println(t));
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	static void loginEmpUI(Scanner sc) {
		System.out.print("Enter email ");
		String email = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		
       EmployeeDAO empDAO = new EmployeeDAOimp();
		
		try {
			String message = empDAO.loginEmployee(email, password);
			System.out.println(message);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	static void assignDepTOEmpUI(Scanner sc) {
		System.out.print("Enter empID ");
		int empId = sc.nextInt();
		System.out.print("Enter depID ");
		int depId = sc.nextInt();
		
		EmployeeDAO empDAO = new EmployeeDAOimp();
		
		try {
			empDAO.assignDeptId(empId, depId);
			System.out.println("Department ID asign successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	static void registerNewEmpUI(Scanner sc) {
		System.out.print("Enter ID ");
		int id = sc.nextInt();
		System.out.print("Enter name ");
		String dname = sc.next();
		System.out.print("Enter address ");
		String address = sc.next();
		System.out.print("Enter email ");
		String email = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter salary ");
		int salary = sc.nextInt();
		
		EmployeeDTO empDTO = new EmployeeDTOimp(id, dname, address, email, password, salary);
		EmployeeDAO empDAO = new EmployeeDAOimp();
		
		try {
			empDAO.registerEmpWithoutID(empDTO);
			System.out.println("Registation successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	static void addNewDepartmentUI(Scanner sc) {
		System.out.print("Enter ID ");
		int id = sc.nextInt();
		System.out.print("Enter name ");
		String dname = sc.next();
		System.out.print("Enter location ");
		String dlocation = sc.next();
		
		DepartmentDTO depDTO = new DepartmentDTOimp(id, dname, dlocation);
		DepartmentDAO depDAO = new DepartmentDAOimp();
		
		try {
			depDAO.addNewDepartment(depDTO);
			System.out.println("Department added successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
}
