package com.masai.dao;

import com.masai.exception.NotFoundException;
import com.masai.modul.Item;
import com.masai.modul.Order;
import com.masai.utils.EMUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class OrderDaoImpl implements OrderDao{
    @Override
    public void createOrder(Order order) {
        EntityManager em = EMUtil.getConnection();
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.close();
        System.out.println("\nOrder created...");
    }

    @Override
    public void createItem(Item item, int orderId) throws NotFoundException {
        EntityManager em = EMUtil.getConnection();
        Order order = em.find(Order.class, orderId);
        if(order == null) throw new NotFoundException("\nOrder doesn't exist!");
        item.setOrder(order);
        order.getItems().add(item);
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
        em.close();
        System.out.println("\nItem created...");
    }

    @Override
    public void createItems(List<Item> items, int orderId) throws NotFoundException {
        EntityManager em = EMUtil.getConnection();
        Order order = em.find(Order.class, orderId);
        if(order == null) throw new NotFoundException("\nOrder doesn't exist!");
        items.forEach(item -> item.setOrder(order));
        order.getItems().addAll(items);
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
        em.close();
        System.out.println("\nItems created...");
    }

    @Override
    public void getItem(int itemId) throws NotFoundException {
        EntityManager em = EMUtil.getConnection();
        Item item = em.find(Item.class, itemId);
        if(item == null) throw new NotFoundException("\nItem doesn't exist!");
        System.out.println("\nItem details : ");
        System.out.println("Item id - " + item.getItemId());
        System.out.println("Item name - " + item.getName());
        System.out.println("Created time - " + item.getCreatedAt());
        System.out.println("Delivery date - " + item.getEstimatedDeliveryDate());
        System.out.println("Order - " + item.getOrder());
    }

    @Override
    public void getOrder(int orderId) throws NotFoundException {
        EntityManager em = EMUtil.getConnection();
        Order order = em.find(Order.class, orderId);
        if(order == null) throw new NotFoundException("\nOrder doesn't exist!");
        System.out.println("\nOrder details : ");
        System.out.println("Order id - " + order.getOrderId());
        System.out.println("Delivery Address - " + order.getDeliveryAddress());
        System.out.println("Created time - " + order.getCreatedAt());
        System.out.println("Total amount - " + order.getTotalAmount());
        System.out.println("Item list - " + order.getItems());
    }

    @Override
    public void getItems(Date inputDate) throws NotFoundException {
        EntityManager em = EMUtil.getConnection();
        Query query = em.createQuery("select i from Item i where createdAt = :date");
        query.setParameter("date", inputDate);
        List<Item> list = query.getResultList();
        list.forEach(item -> System.out.println(item));
    }
}
