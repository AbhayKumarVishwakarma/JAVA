package com.masai.dao;

import com.masai.model.Employee;
import com.masai.utils.EMUtils;

import javax.persistence.EntityManager;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void save(Employee emp) {
        EntityManager em = EMUtils.getEntityManager();
        Employee employee = new Employee(emp.getEmpId(), emp.getName(), emp.getAddress(), emp.getSalary());

        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        System.out.println("\ndone...\n");
        em.close();
    }

    @Override
    public String getAddressOfEmployee(int empId) {
        String msg = "Unable to find address";
        EntityManager em = EMUtils.getEntityManager();

        Employee emp =  em.find(Employee.class, empId);
        if(emp != null)
            msg = emp.getAddress();

        return msg;
    }

    @Override
    public String giveBonusToEmployee(int empId, int bonus) {
        String msg = "Unable to give bonus";
        EntityManager em = EMUtils.getEntityManager();

        Employee emp =  em.find(Employee.class, empId);
        if(emp != null) {
            em.getTransaction().begin();
            emp.setSalary(emp.getSalary() + bonus);
            em.getTransaction().commit();
            msg = "Bonus added!";
        }
        em.close();

        return msg;
    }

    @Override
    public boolean deleteEmployee(int empId) {
        boolean flag = false;
        EntityManager em = EMUtils.getEntityManager();

        Employee emp =  em.find(Employee.class, empId);
        if(emp != null) {
            em.getTransaction().begin();
            em.remove(emp);
            em.getTransaction().commit();
            flag = true;
        }
        em.close();

        return flag;
    }
}
