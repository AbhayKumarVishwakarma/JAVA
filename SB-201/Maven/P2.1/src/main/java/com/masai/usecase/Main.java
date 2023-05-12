package com.masai.usecase;

import com.masai.dao.OrderDao;
import com.masai.dao.OrderDaoImpl;
import com.masai.exception.NotFoundException;
import com.masai.modul.Item;
import com.masai.modul.Order;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NotFoundException {
        OrderDao dao = new OrderDaoImpl();

        // create Order
      /*  Order order = new Order();
        order.setDeliveryAddress("Lucknow");
        order.setTotalAmount(4000);

        Item item1 = new Item();
        item1.setName("Cream");
        item1.setEstimatedDeliveryDate(Date.valueOf(LocalDate.parse("2023-04-29")));
        item1.setOrder(order);

        Item item2 = new Item();
        item2.setName("Shirt");
        item2.setEstimatedDeliveryDate(Date.valueOf(LocalDate.parse("2023-04-30")));
        item2.setOrder(order);

        Item item3 = new Item();
        item3.setName("Jeans");
        item3.setEstimatedDeliveryDate(Date.valueOf(LocalDate.parse("2023-04-30")));
        item3.setOrder(order);

        order.getItems().addAll(List.of(item1,item2,item3));

        OrderDao dao = new OrderDaoImpl();
        dao.createOrder(order); */

        // Get item
//        dao.getItem(3);

        // Get Order
//        dao.getOrder(1);

        // Get Items by date
        dao.getItems(Date.valueOf(LocalDate.parse("2023-04-16")));

        System.out.println("done...");
    }
}
