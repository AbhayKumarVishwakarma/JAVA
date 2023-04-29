package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.sql.Statement;


public class DbConnectionExample {
	static Connection getConnectionTodatabase() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		
        return DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
	}
	
	static void closeConnection(Connection con) throws SQLException {
		if(con != null)
			con.close();
	}
	
	/**
	 * Used to input student details and add the same to database
	 * @param sc Scanner object that is used to take input
	 * @throws SQLException if anything goes wrong
	 * @throws ClassNotFoundException If driver class is not found
	 */
	
	static void addStudent() throws SQLException, ClassNotFoundException {
        Connection con = getConnectionTodatabase();
		Statement st = con.createStatement();
		
		String rollNo = "R004";
		String name = "Aadi";
		double cgpa = 9.8;
		LocalDate dob = LocalDate.parse("2001-12-11");
		
		String query = "insert into student values('" + rollNo + "', '" + name + "', '" + cgpa + "', '" + dob + "')";
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("Student added successfully");
		}
		else {
			System.out.println("not able to add Student");
		}
		
		closeConnection(con);
	}
	
	static void updateStudent() throws ClassNotFoundException, SQLException {
		Connection con = getConnectionTodatabase();
		Statement st = con.createStatement();
		
		String rollNo = "R001";
		String name = "Suraj";
		double cgpa = 7.9;
		LocalDate dob = LocalDate.parse("2000-03-10");
		
		String query = "update student set name = '" + name + "', cgpa = " + cgpa + ", dob = '" + dob + "' where rollNo = '" + rollNo + "'";
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("Student updateed successfully");
		}
		else {
			System.out.println("not able to update Student");
		}
		
		closeConnection(con);
	}
	
	static void deleteStudent() throws ClassNotFoundException, SQLException {
		Connection con = getConnectionTodatabase();
		Statement st = con.createStatement();
		
		String rollNo = "R004";
		
		String query = "delete from student where rollNO = '" + rollNo + "'";
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("Student deleted successfully");
		}
		else {
			System.out.println("Not able to delete Student");
		}
		
		closeConnection(con);
	}
	
	static void printStudentList() throws ClassNotFoundException, SQLException {
		Connection con = getConnectionTodatabase();
		Statement st = con.createStatement();
		
		String query = "select * from student";
		
		ResultSet rs =  st.executeQuery(query);
		
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			System.out.println("Student not found");
		}
		else {
			while(rs.next()) {
				System.out.println("Roll Number: " + rs.getString(1) + ", Name: " + rs.getString(2) + ", CGPA: " + rs.getDouble(3) + ", Date of birth: " + rs.getDate(4));
			}
		}
		
		closeConnection(con);
	}
	
	static void searchStudentByName() throws ClassNotFoundException, SQLException {
		Connection con = getConnectionTodatabase();
		Statement st = con.createStatement();
		
		String name = "Ankit";
		
		String query = "select * from student where name = '" + name + "'";
		
		ResultSet rs = st.executeQuery(query);
		
		if(!rs.isBeforeFirst() && rs.getRow()==0) {
			System.out.println("Student not found");
		}
		else {
			while(rs.next()) {
				System.out.println("Roll Number: " + rs.getString(1) + ", Name: " + rs.getString(2) + ", CGPA: " + rs.getDouble(3) + ", Date of birth: " + rs.getDate(4));
			}
		}
	}
	
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
//    	 addStudent();
//		 updateStudent();
//    	 deleteStudent();
//    	 printStudentList();
//    	 searchStudentByName();
	}
}
