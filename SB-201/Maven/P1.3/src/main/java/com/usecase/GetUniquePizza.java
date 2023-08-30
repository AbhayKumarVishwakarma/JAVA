package com.usecase;

import com.dao.OrderDao;
import com.dao.OrderDaoImpl;

import java.util.List;

public class GetUniquePizza {
    public static void main(String[] args) {
        OrderDao dao = new OrderDaoImpl();
        List<String> list = dao.listOfAllUniquePizza();
        list.forEach(order -> System.out.println(order));
    }
}
