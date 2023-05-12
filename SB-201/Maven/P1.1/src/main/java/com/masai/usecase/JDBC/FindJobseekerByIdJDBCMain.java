package com.masai.usecase.JDBC;

import com.masai.dao.ConsultancyDAO;
import com.masai.dao.ConsultancyDAOJdbcImpl;
import com.masai.modul.Jobseeker;

public class FindJobseekerByIdJDBCMain {
    public static void main(String[] args) {
        ConsultancyDAO dao = new ConsultancyDAOJdbcImpl();
        Jobseeker jobseeker = dao.findJobseekerById(1);
        System.out.println(jobseeker);
    }
}
