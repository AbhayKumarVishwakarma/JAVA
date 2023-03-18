package com.day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class CustomerDeSerDemo {
     public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    	//Create object of ObjectInputStream class
    	 ObjectInput oi = new ObjectInputStream(new FileInputStream("customer.ser"));
    	 
    	//deserialize using readObject method
    	 Customer customer = (Customer) oi.readObject();
    	 
    	 Customer.citizenship = "Israel";
    	 System.out.println(customer);
    	 System.out.println(Customer.citizenship);  //Israel
    	   
    	 //close the stream
    	 oi.close();
	}
}
