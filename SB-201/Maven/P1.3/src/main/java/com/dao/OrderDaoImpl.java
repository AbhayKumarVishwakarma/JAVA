package com.dao;

import com.modul.Order;
import com.utils.EMUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OrderDaoImpl implements OrderDao{
    @Override
    public String createOrder(Order o) {
        String msg = "Unable to create new order";
        EntityManager em = EMUtils.getConnection();

        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        msg = "Order created";
        em.close();

        return msg;
    }

    @Override
    public String deleteOrderById(int id) {
        String msg = "Unable to delete order";
        EntityManager em = EMUtils.getConnection();

        Order o = em.find(Order.class, id);
        if(o != null){
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
            msg = "Order deleted";
            em.close();
        }
        return msg;
    }

    @Override
    public List<Order> getOrderByName(String orderName) {
        EntityManager em = EMUtils.getConnection();
        Query query = em.createQuery("select o from Order o where orderNumber = :oNumber");
        query.setParameter("oNumber", orderName);
        List<Order> list = query.getResultList();

        return list;
    }

    @Override
    public List<String> listOfAllUniquePizza() {
        EntityManager em = EMUtils.getConnection();
        Query query = em.createQuery("select distinct(pizza) from Order");
        List<String> list = query.getResultList();

        return list;
    }
}
