package com.demo.usecase;

import com.demo.dao.DNA_WifiDAO;
import com.demo.dao.DNA_WifiDAOImpl;
import com.demo.modul.Customer;

import java.sql.Date;
import java.util.Scanner;
/*
customer{
	id: int Primary key [Auto Generated]
	name: varchar
	email: varchar
	address: varchar
	data_Gb: int
	price: int
	recharge_date: yyyy-mm-dd
} */
public class SaveCustomerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name ");
        String name = sc.next();
        System.out.print("Enter address ");
        String address = sc.next();
        System.out.print("Enter email ");
        String email = sc.next();
        System.out.print("Enter data GB ");
        int gb = sc.nextInt();
        System.out.print("Enter price ");
        int price = sc.nextInt();
        System.out.print("Enter recharge date ");
        Date date = Date.valueOf(sc.next());

        Customer c = new Customer();
        c.setName(name);
        c.setAddress(address);
        c.setEmail(email);
        c.setDate_Gb(gb);
        c.setPrice(price);
        c.setRecharge_date(date);

        DNA_WifiDAO dao = new DNA_WifiDAOImpl();
        String msg = dao.saveCustomer(c);
        System.out.println(c);
    }
}
