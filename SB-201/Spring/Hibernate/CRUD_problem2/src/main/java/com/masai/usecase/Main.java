package com.masai.usecase;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("book");
        EntityManager em = emf.createEntityManager();
        System.out.println("done...");
        em.close();
    }
}