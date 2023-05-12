package com.dao;

import com.modul.Order;

import java.util.List;

public interface OrderDao {
    public String createOrder(Order o);
    public String deleteOrderById(int id);
    public List<Order> getOrderByName(String orderName);
    public List<String> listOfAllUniquePizza();
}
