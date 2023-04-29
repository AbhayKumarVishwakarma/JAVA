package com.one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.one.dto.DepartmentDTO;
import com.one.dto.DepartmentDTOimp;
import com.one.exception.NoRecordFoundException;
import com.one.exception.SomethingWentWrongException;

public class DepartmentDAOimp implements DepartmentDAO {

	@Override
	public void addNewDepartment(DepartmentDTO depObj) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "insert into department (did, dname, location) values (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, depObj.getDid());
			ps.setString(2, depObj.getDname());
			ps.setString(3, depObj.getLocation());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to add department");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<DepartmentDTO> showAllDepatment() throws SomethingWentWrongException, NoRecordFoundException {
		Connection con = null;
		List<DepartmentDTO> list = new ArrayList<>();
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "select * from department";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new DepartmentDTOimp(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to show department");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void updateDepLocation(int did, String location) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "update department set location = ? where did = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, location);
			ps.setInt(2, did);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to update department location");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteDepByID(int did) throws SomethingWentWrongException, NoRecordFoundException {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query1 = "update employee set deptId = null where deptId = ?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setInt(1, did);
			ps1.executeUpdate();
			
			String query2 = "delete from department where did = ?";
			PreparedStatement ps2 = con.prepareStatement(query2);
			ps2.setInt(1, did);
			ps2.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to delete department location");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
