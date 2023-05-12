package com.demo.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtils {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("practice_oneE");
    }

    public static EntityManager getConnection() {
        return emf.createEntityManager();
    }
}
