package com.day8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class CustomerSerDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
    	//Create object of Customer class
        Customer customer = new Customer("Jayant", LocalDate.now(), "Haryana", 98653265998L);
        
      //Create object of ObjectOutputStream class
        ObjectOutput oo = new ObjectOutputStream(new FileOutputStream("customer.ser"));
        
      //serialize the customer object
        oo.writeObject(customer);
        
      //close the stream
        oo.close();
       
        System.out.println("Customer serialized");
	}
}
