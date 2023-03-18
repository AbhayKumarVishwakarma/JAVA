package com.day5;

public class Demo5 extends Thread {
     @Override
     public void run() {
    	 int i=0;
    	 while(i<30) {
    		 System.out.println("Inside run method : " + i++);
    	 }
    	 System.out.println("End of run method ");
     }
     public static void main(String[] args) {
		Demo5 d = new Demo5();  // it initially using runnable interface so we not need to create runnable object
		d.start();
		int i=31;
   	    while(i<60) {
   		    System.out.println("Inside main method : " + i++);
   	    }
   	    System.out.println("End of main method ");
	}
}
