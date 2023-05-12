package com.masai.usecase.ORM;

import com.masai.dao.ConsultancyDAO;
import com.masai.dao.ConsultancyDAOJdbcImpl;
import com.masai.dao.ConsultancyDaoOrmImpl;
import com.masai.modul.Jobseeker;

public class FindJobseekerByIdORMMain {
    public static void main(String[] args) {
        ConsultancyDAO dao = new ConsultancyDaoOrmImpl();
        Jobseeker j = dao.findJobseekerById(1);
        System.out.println(j);
    }
}
