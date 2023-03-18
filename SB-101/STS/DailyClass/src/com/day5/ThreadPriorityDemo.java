package com.day5;

public class ThreadPriorityDemo extends Thread {
	volatile static boolean runMe = true; 
	int counter = 0;

	public void run(){
		while(runMe)
				counter++;
	}

	public static void main(String args[]){
		ThreadPriorityDemo a1 = new ThreadPriorityDemo();
		ThreadPriorityDemo a2 = new ThreadPriorityDemo();
	   	 
	   	a1.setPriority(NORM_PRIORITY + 4);
	   	a2.setPriority(NORM_PRIORITY - 3);

	   	a1.start();
	   	a2.start();
	   	try{
	   		Thread.sleep(2000);
	   		runMe = false;
	   		a1.join();
	   		a2.join();
	   		System.out.println("a1's counter is : " + a1.counter);
	   		System.out.println("a2's counter is : " + a2.counter);
	   	}catch(InterruptedException ie){
	   		System.out.println(ie);
	   	}
	   	System.out.println("Bye-bye main");

	}
}
