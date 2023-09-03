package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
     static Connection getConnectionToDatabases() throws ClassNotFoundException, SQLException {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
    	 return DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
     }
     
     static void closeConnection(Connection con) throws SQLException {
    	 if(con != null) con.close();
     }
}
