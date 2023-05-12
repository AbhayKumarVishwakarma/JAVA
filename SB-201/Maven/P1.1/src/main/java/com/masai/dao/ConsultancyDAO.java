package com.masai.dao;

import com.masai.modul.Jobseeker;

public interface ConsultancyDAO {
    Jobseeker findJobseekerById(int id);
    String saveJobseeker(Jobseeker jobseeker);
    String deleteJobseekerById(int id);
    String updateJobseekerExperience(int id, int experience);
}
