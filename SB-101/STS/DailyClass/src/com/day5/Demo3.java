package com.day5;

public class Demo3 {
    public static void main(String[] args) {
		
    	// creating an object of the Thread class using the constructor Thread(String name)   
    	Thread t = new Thread("My thread");  
    	  
    	// the start() method moves the thread to the active state  
    	t.start();  
    	// getting the thread name by invoking the getName() method  
    	System.out.println(t.getName());
	}
}
