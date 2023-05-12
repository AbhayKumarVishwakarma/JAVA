package com.demo.usecase;

import com.demo.dao.DNA_WifiDAO;
import com.demo.dao.DNA_WifiDAOImpl;
import com.demo.modul.Customer;

import java.util.Date;
import java.util.Scanner;

public class DeleteCustomerByIdMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer id ");
        int id = sc.nextInt();

        DNA_WifiDAO dao = new DNA_WifiDAOImpl();
        String msg = dao.deleteCustomerById(id);
        System.out.println(msg);
    }
}
