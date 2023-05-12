package com.masai.usecase;

import com.masai.modul.DayScholar;
import com.masai.modul.Hosteller;
import com.masai.utils.EMUtil;

import javax.persistence.EntityManager;
public class Main {
    public static void main(String[] args) {

        DayScholar dayScholar = new DayScholar();
        dayScholar.setName("Ram");
        dayScholar.setAddress("Lucknow");
        dayScholar.setTransportFee(200);

        DayScholar dayScholar1 = new DayScholar();
        dayScholar1.setName("Vinay");
        dayScholar1.setAddress("Kanpur");
        dayScholar1.setTransportFee(250);

        Hosteller hosteller = new Hosteller();
        hosteller.setName("Amit");
        hosteller.setAddress("Prayagraj");
        hosteller.setHostelFee(4000);

        Hosteller hosteller1 = new Hosteller();
        hosteller1.setName("Suresh");
        hosteller1.setAddress("Varanasi");
        hosteller1.setHostelFee(3500);

        EntityManager em = EMUtil.getConnection();
        em.getTransaction().begin();
        em.persist(dayScholar);
        em.persist(dayScholar1);
        em.persist(hosteller);
        em.persist(hosteller1);
        em.getTransaction().commit();
        em.close();
        System.out.println("done...");
    }
}