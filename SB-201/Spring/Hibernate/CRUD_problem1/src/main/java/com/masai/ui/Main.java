package com.masai.ui;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.model.Employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1. Register Employee \n2. Show employee by id \n3.  Delete employee by id \n4. Update employee salary");
            System.out.print("Enter your selection ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    saveUI(sc);
                    break;
                case 2:
                    getAddressOfEmployeeUI(sc);
                    break;
                case 3:
                    deleteEmployeeByIdUI(sc);
                    break;
                case 4:
                    giveBonusToEmployeeUI(sc);
                    break;
                default:
                    break;
            }
        }while(choice != 0);
    }

    private static void saveUI(Scanner sc) {
        System.out.print("Enter employee id ");
        int id = sc.nextInt();
        System.out.print("Enter employee name ");
        String name = sc.next();
        System.out.print("Enter employee address ");
        String address = sc.next();
        System.out.print("Enter employee salary ");
        int salary = sc.nextInt();

        Employee emp = new Employee(id, name, address, salary);
        EmployeeDao empDao = new EmployeeDaoImpl();
        empDao.save(emp);
    }

    private static void getAddressOfEmployeeUI(Scanner sc) {
        System.out.print("Enter employee id ");
        int id = sc.nextInt();

        EmployeeDao empDao = new EmployeeDaoImpl();
        String msg = empDao.getAddressOfEmployee(id);
        System.out.println("\n" + msg + "\n");
    }

    private static void deleteEmployeeByIdUI(Scanner sc) {
        System.out.print("Enter employee id ");
        int id = sc.nextInt();

        EmployeeDao empDao = new EmployeeDaoImpl();
        boolean flag = empDao.deleteEmployee(id);
        System.out.println(flag == true ? "\nEmployee deleted\n" : "\nEmployee does not exist!\n");
    }

    private static void giveBonusToEmployeeUI(Scanner sc) {
        System.out.print("Enter employee id ");
        int id = sc.nextInt();
        System.out.print("Enter bonus ");
        int bonus = sc.nextInt();

        EmployeeDao empDao = new EmployeeDaoImpl();

        String msg = empDao.giveBonusToEmployee(id, bonus);
        System.out.println("\n" + msg + "\n");
    }
}