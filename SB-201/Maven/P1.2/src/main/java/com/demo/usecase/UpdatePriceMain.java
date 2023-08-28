package com.demo.usecase;

import com.demo.dao.DNA_WifiDAO;
import com.demo.dao.DNA_WifiDAOImpl;

import java.util.Scanner;

public class UpdatePriceMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer id ");
        int id = sc.nextInt();
        System.out.print("Enter price ");
        int price = sc.nextInt();

        DNA_WifiDAO dao = new DNA_WifiDAOImpl();
        String msg = dao.updatePrice(price, id);
        System.out.println(msg);

        sc.close();
    }
}
