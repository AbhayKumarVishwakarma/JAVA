package com.masai.usecase;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.sql.Date;

import com.masai.dao.BikeDao;
import com.masai.dao.BikeDaoImpl;
import com.masai.model.Bike;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main { // https://drive.google.com/file/d/1BQXQxsO4ZZZGxSJ7OJWtjo8ceSv7IngE/view

    public static void createBikeHandler(){
        List<Bike> list = Stream.of(new Bike[]{
                new Bike("B001", "Hero", "Splender", 35400, Date.valueOf("2020-05-05")),
                new Bike("B002", "Hero", "Splender 1", 55400, Date.valueOf("2020-09-11")),
                new Bike("B003", "Hero", "Splender 2", 45400, Date.valueOf("2020-02-27")),
                new Bike("B004", "Hero", "Splender 3", 39400, Date.valueOf("2020-08-25")),
                new Bike("B005", "Hero", "Splender 4", 47400, Date.valueOf("2020-03-15")),
                new Bike("B006", "Hero", "Splender 5", 57400, Date.valueOf("2020-01-09"))
        }).collect(Collectors.toList());

        BikeDao dao = new BikeDaoImpl();
        for(Bike b : list){
            System.out.println(dao.crateBike(b));
        }
        System.out.println();
    }

    public static void updateBikeHandler(){
        String id = "B001";
        String band = "TVS";
        String model = "Activa";

        BikeDao dao = new BikeDaoImpl();
        Bike b = new Bike(band,model);
        System.out.println(dao.updateBike(id,b));
        System.out.println();
    }

    public static void deleteBikeHandler(){
        BikeDao dao = new BikeDaoImpl();
        System.out.println(dao.deleteBike("B004"));
        System.out.println();
    }

    public static void searchByIdHandler(){
        BikeDao dao = new BikeDaoImpl();
        System.out.println(dao.viewBikeById("B006"));
        System.out.println();
    }

    public static void priceRange(){
        BikeDao dao = new BikeDaoImpl();
        List<Bike> list = dao.searchByPriceRange(30000, 40000);
        list.forEach(bike -> System.out.println(bike));
        System.out.println();
    }

    public static void sortPrice(){
        BikeDao dao = new BikeDaoImpl();
        List<Bike> list = dao.sortByPriceDesc();
        list.forEach(bike -> System.out.println(bike));
        System.out.println();
    }

    public static void distinctBike(){
        BikeDao dao = new BikeDaoImpl();
        List<Bike> list = dao.distinctBrands();
        list.forEach(bike -> System.out.println(bike));
        System.out.println();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bike");
        EntityManager em = emf.createEntityManager();
        System.out.println("done...\n");
        em.close();

//        createBikeHandler();
//        updateBikeHandler();
//        deleteBikeHandler();
        searchByIdHandler();
        priceRange();
        sortPrice();
        distinctBike();
    }
}