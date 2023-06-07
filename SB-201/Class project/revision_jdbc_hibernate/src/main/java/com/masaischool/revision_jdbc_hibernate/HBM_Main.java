package com.masaischool.revision_jdbc_hibernate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class HBM_Main {
	static EntityManagerFactory emf = null;
	private static List resultList;
	
	static {
		emf = Persistence.createEntityManagerFactory("rjh");
	}
	
	static void insertCustomer(String name, CustomerType type, BigDecimal creditLimit, LocalDate joiningDate) {
		EntityManager em = null;
		EntityTransaction et = null;
		Customer customer = new Customer(name, type, creditLimit, joiningDate);
		//state of the Customer Entity: transient
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(customer);
			//state of the customer Entity: managed 
			et.commit();
		}catch(PersistenceException ex) {
			ex.printStackTrace();
			//System.out.println(ex.getLocalizedMessage());
			et.rollback();
		}finally {
			em.close();
		}
	}
	
	static void showCustomerDetails() {
		try(EntityManager em = emf.createEntityManager();) {
			Query query = em.createQuery("SELECT name, type, joiningDate FROM Customer WHERE creditLimit > :creditLimit ORDER BY type ASC");
			query.setParameter("creditLimit", 4999.00);
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.getResultList();
			query.getSingleResult();
			for(Object[] custData : list) {
				System.out.println("Name: " + custData[0] + " Type: " + custData[1] + " Joining date: " + custData[2]);
			}
		}catch(IllegalArgumentException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		insertCustomer("BCD", CustomerType.COMMERCIAL, new BigDecimal(11399.00), LocalDate.parse("2023-04-04"));
//		insertCustomer("CDE", CustomerType.COMMERCIAL, new BigDecimal(7999.00), LocalDate.parse("2024-01-01"));
//		insertCustomer("DEF", CustomerType.DOMESTIC, new BigDecimal(2999.00), LocalDate.parse("2023-05-31"));
//		insertCustomer("EFG", CustomerType.COMMERCIAL, new BigDecimal(11899.00), LocalDate.parse("2023-06-05"));
		showCustomerDetails();
	}
}
