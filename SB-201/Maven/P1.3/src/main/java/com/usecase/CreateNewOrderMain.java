package com.usecase;

import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import com.modul.Order;


import java.sql.Date;
import java.time.LocalDate;

import java.util.Scanner;

/*
		bookingId: 101,
		orderNumber: "Zo5678768",
    pizza: "Veg_Cheeze_Pizza",
    prize: 500,  [In Rs]
    deliveryAddress: "Ranjana Palace 1st Block, Andheri, Mumbai",
    created_timestamp : 2019-12-11 10:58:37. [use current time stamp]
 */
public class CreateNewOrderMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order number ");
        String oNumber = sc.next();
        System.out.print("Enter pizza ");
        String pizza = sc.next();
        System.out.print("Enter price ");
        int price = sc.nextInt();
        System.out.print("Enter address ");
        String address = sc.next();
        Date time = Date.valueOf(LocalDate.now());

        Order o = new Order();
        o.setAddress(address);
        o.setOrderNumber(oNumber);
        o.setPizza(pizza);
        o.setPrice(price);
        o.setTime(time);

        OrderDao dao = new OrderDaoImpl();
        String msg = dao.createOrder(o);
        System.out.println(msg);

        sc.close();
    }
}
