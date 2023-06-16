package com.masai.dao;

import com.masai.exception.BikeException;
import com.masai.model.Bike;
import com.masai.utils.EMUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BikeDaoImpl implements BikeDao{
    @Override
    public String crateBike(Bike bike) {
        String msg = "Unable to crate bike!";
        EntityManager em = EMUtils.getEntityManager();
        em.getTransaction().begin();
        em.persist(bike);
        em.getTransaction().commit();
        msg = "Bike created ...";
        em.close();
        return msg;
    }

    @Override
    public String updateBike(String id, Bike bike) throws BikeException {
        String msg = "Unable to update bike!";
        EntityManager em = EMUtils.getEntityManager();
        Bike b = em.find(Bike.class, id);
        if(b != null){
            em.getTransaction().begin();
            b.setBrand(bike.getBrand());
            b.setModel(bike.getModel());
            em.merge(b);
            em.getTransaction().commit();
            msg = "Bike updated ...";
        }else throw new BikeException("Not found any book with id: " + id);
        em.close();
        return msg;
    }

    @Override
    public String deleteBike(String id) throws BikeException {
        String msg = "Unable to update bike!";
        EntityManager em = EMUtils.getEntityManager();
        Bike b = em.find(Bike.class, id);
        if(b != null){
            em.getTransaction().begin();
            em.remove(b);
            em.getTransaction().commit();
            msg = "Bike deleted ...";
        }else throw new BikeException("Not found any book with id: " + id);
        em.close();
        return msg;
    }

    @Override
    public Bike viewBikeById(String id) throws BikeException {
        EntityManager em = EMUtils.getEntityManager();
        Bike b = em.find(Bike.class, id);
        if(b == null) throw new BikeException("Not found any book with id: " + id);
        em.close();
        return b;
    }

    @Override
    public List<Bike> searchByPriceRange(Integer min, Integer max) throws BikeException {
        EntityManager em = EMUtils.getEntityManager();
        Query query = em.createQuery("select b from Bike b");
        List<Bike> list = query.getResultList();
        list = list.stream().filter( bike -> bike.getPrice() >= min && bike.getPrice() <= max).collect(Collectors.toList());
        if(list.isEmpty()) throw new BikeException("Not found any book between " + min + " and " + max + " price range!");
        return list;
    }

    @Override
    public List<Bike> sortByPriceDesc() throws BikeException {
        EntityManager em = EMUtils.getEntityManager();
        Query query = em.createQuery("select b from Bike b");
        List<Bike> list = query.getResultList();
        list = list.stream().sorted((o1, o2) -> {
            if(o2.getPrice() > o1.getPrice()) return o2.getPrice() - o1.getPrice();
            if(o2.getPrice() == o1.getPrice()) return o1.getModel().compareTo(o2.getModel());
            return 0;
        }).collect(Collectors.toList());
        if(list.isEmpty()) throw new BikeException("Not found any book!");
        return list;
    }

    @Override
    public List<Bike> distinctBrands() throws BikeException {
        EntityManager em = EMUtils.getEntityManager();
        Query query = em.createQuery("select b from Bike b");
        List<Bike> bikes = query.getResultList();
        Set<String> distinctBrands = new HashSet<>();
        List<Bike> bikesWithDistinctBrands = new ArrayList<>();

        for (Bike bike : bikes) {
            String brand = bike.getBrand();
            if (!distinctBrands.contains(brand)) {
                distinctBrands.add(brand);
                bikesWithDistinctBrands.add(bike);
            }
        }
        if(bikesWithDistinctBrands.isEmpty()) throw new BikeException("Not found any book!");
        return bikesWithDistinctBrands;
    }
}
