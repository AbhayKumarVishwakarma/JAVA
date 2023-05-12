package com.masai.dao;

import com.masai.modul.Jobseeker;
import com.masai.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultancyDAOJdbcImpl implements  ConsultancyDAO{
    @Override
    public Jobseeker findJobseekerById(int id) {
        Connection con;
        try { // Jobseeker(int id, String email, String address, String mobNo, String category, int experience)
            con = DBUtils.getConnectionToDB();
            PreparedStatement ps = con.prepareStatement("select * from jobseeker where id = ?");
            ps.setInt(1, id);
            boolean flag = false;
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                flag = true;
                return new Jobseeker(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
            }
            if(flag == false) throw new RuntimeException("Jobseeker doesn't exist!");
        }catch (Exception e){
            throw new RuntimeException("Something went wrong!");
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
