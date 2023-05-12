package com.masai.usecase;

import com.masai.modul.Student;
import com.masai.utils.EMUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Demo {
    public static void main(String[] args) {
        EntityManager em = EMUtil.getConnection();
        Query query = em.createQuery("select s from Student s where name = :name");
        query.setParameter("name","Ram");
        Student student = (Student) query.getSingleResult();
        System.out.println("\nStudent details : ");
        student.displayDetails();
        System.out.println("\nPay Fee : ");
        student.payFee();
    }
}
