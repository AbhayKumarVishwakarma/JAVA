package com.masai.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtils {
    public static EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("practice_oneE");
    }
    public static EntityManager getEntityConnection(){
        return emf.createEntityManager();
    }
}
