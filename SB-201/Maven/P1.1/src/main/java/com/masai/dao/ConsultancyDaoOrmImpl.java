package com.masai.dao;

import com.masai.modul.Jobseeker;
import com.masai.utils.EMUtils;

import javax.persistence.EntityManager;

// Jobseeker(int id, String email, String address, String mobNo, String category, int experience)
public class ConsultancyDaoOrmImpl implements ConsultancyDAO{
    @Override
    public Jobseeker findJobseekerById(int id) {
        EntityManager em = EMUtils.getEntityConnection();
        Jobseeker j = em.find(Jobseeker.class,id);
        if(j != null){
            return j;
        }
        return null;
    }

    @Override
    public String saveJobseeker(Jobseeker jobseeker) {
        return null;
    }

    @Override
    public String deleteJobseekerById(int id) {
        return null;
    }

    @Override
    public String updateJobseekerExperience(int id, int experience) {
        return null;
    }
}
