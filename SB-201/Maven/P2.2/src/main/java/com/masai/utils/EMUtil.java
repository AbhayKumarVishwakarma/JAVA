package com.masai.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
    public static EntityManagerFactory emf;
    static{
        emf = Persistence.createEntityManagerFactory("E2-P");
    }
    public static EntityManager getConnection(){
        return emf.createEntityManager();
    }
}
