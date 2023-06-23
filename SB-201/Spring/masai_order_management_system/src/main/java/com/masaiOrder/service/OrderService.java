package com.masaiOrder.service;

import java.time.LocalDate;
import java.util.List;

import com.masaiOrder.exception.CustomerException;
import com.masaiOrder.exception.OrderException;
import com.masaiOrder.model.Item;
import com.masaiOrder.model.Order;

public interface OrderService {
    public Order createOrder(Order order, Integer CusID) throws CustomerException;
    public Order updateOrder(Integer oId, Item item) throws OrderException;
    public Order deleteOrder(Integer oId) throws OrderException;
    public List<Order> allOrder() throws OrderException;
    public Order orderById(Integer oId) throws OrderException;
    public List<Order> allOrderByCustomerName(String customerName) throws OrderException, CustomerException;
    public List<Order> allOrderBetweenDate(LocalDate str, LocalDate end) throws OrderException;
    public Integer totalRevenueOnDate(LocalDate str, LocalDate end) throws OrderException;
}
