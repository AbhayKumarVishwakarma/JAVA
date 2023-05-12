package com.usecase;

import com.dao.OrderDao;
import com.dao.OrderDaoImpl;

import java.util.Scanner;

public class DeleteOrderByIdMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter order id ");
        int id = sc.nextInt();

        OrderDao dao = new OrderDaoImpl();
        String msg = dao.deleteOrderById(id);
        System.out.println(msg);
    }
}
