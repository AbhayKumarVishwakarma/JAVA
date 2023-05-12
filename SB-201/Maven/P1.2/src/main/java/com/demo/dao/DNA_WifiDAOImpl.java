package com.demo.dao;

import com.demo.modul.Customer;
import com.demo.utils.EMUtils;

import javax.persistence.EntityManager;

public class DNA_WifiDAOImpl implements DNA_WifiDAO{
    @Override
    public Customer findCustomerById(int id) {
        EntityManager em = EMUtils.getConnection();
        Customer c = em.find(Customer.class, id);
        if(c != null)
            return c;

        return null;
    }

    @Override
    public String saveCustomer(Customer customer) {
        String msg = "Unable to save customer";
        EntityManager em = EMUtils.getConnection();

        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        msg = "Customer saved";
        em.close();

        return msg;
    }

    @Override
    public String deleteCustomerById(int id) {
        String msg = "Unable to delete customer";
        EntityManager em = EMUtils.getConnection();

        Customer c = em.find(Customer.class, id);
        if(c != null){
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            msg = "Customer deleted";
        }
        em.close();

        return msg;
    }

    @Override
    public String updatePrice(int new_price, int id) {
        String msg = "Unable to update customer";
        EntityManager em = EMUtils.getConnection();

        Customer c = em.find(Customer.class, id);
        if(c != null){
            em.getTransaction().begin();
            c.setPrice(new_price);
            em.getTransaction().commit();
            msg = "Customer updated";
        }
        em.close();

        return msg;
    }

    @Override
    public String recharge(int data_Gb, int id) {
        String msg = "Unable to add recharge";
        EntityManager em = EMUtils.getConnection();

        Customer c = em.find(Customer.class, id);
        if(c != null){
            em.getTransaction().begin();
            c.setDate_Gb(c.getDate_Gb() + data_Gb);
            em.getTransaction().commit();
            msg = "Recharge added";
        }
        em.close();

        return msg;
    }
}
