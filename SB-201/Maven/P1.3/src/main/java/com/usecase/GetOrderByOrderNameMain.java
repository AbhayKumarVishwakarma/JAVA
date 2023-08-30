package com.usecase;

import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import com.modul.Order;

import java.util.List;
import java.util.Scanner;

public class GetOrderByOrderNameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter order number ");
        String oNumber = sc.next();

        OrderDao dao = new OrderDaoImpl();
        List<Order> list = dao.getOrderByName(oNumber);
        list.forEach(order -> System.out.println(order));

        sc.close();
    }
}
