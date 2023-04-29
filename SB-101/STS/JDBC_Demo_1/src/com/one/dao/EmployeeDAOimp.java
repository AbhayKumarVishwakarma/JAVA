package com.one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.one.dto.EmployeeDTO;
import com.one.exception.NoRecordFoundException;
import com.one.exception.SomethingWentWrongException;

public class EmployeeDAOimp implements EmployeeDAO {

	@Override
	public void registerEmpWithoutID(EmployeeDTO empObj) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "insert into employee (empId, ename, address, email, password, salary) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, empObj.getEmpId());
			ps.setString(2, empObj.getEname());
			ps.setString(3, empObj.getAddress());
			ps.setString(4, empObj.getEmail());
			ps.setString(5, empObj.getPassword());
			ps.setInt(6, empObj.getSalary());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to register");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void assignDeptId(int empId, int depId) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "update employee set deptId = ? where empId = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, depId);
			ps.setInt(2, empId);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to register");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String loginEmployee(String email, String password)
			throws SomethingWentWrongException, NoRecordFoundException {
		Connection con = null;
		String massage = "Invalid email or password";
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "select ename from employee where email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) 
            	massage = "Welcome " + rs.getString("ename");
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to register");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return massage;
	}

	@Override
	public void updateEmpPassword(int empId, String password) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "update employee set password = ? where empId = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, password);
			ps.setInt(2, empId);
			
            ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to update password");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
