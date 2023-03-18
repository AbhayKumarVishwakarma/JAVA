package com.day9;

import java.util.ResourceBundle;

public class ResourceBundleDemo {
     public static void main(String[] args) {
    	  //Normal text files should be in the project folder
    	  //but the properties file should be in the src folder.
    	 
    	 ResourceBundle rs = ResourceBundle.getBundle("dbdetails");
    	 System.out.println("Username: " + rs.getString("username"));
    	 System.out.println("ServerName: " + rs.getString("servername"));
    	 System.out.println("Password: " + rs.getString("password"));
	}
}
