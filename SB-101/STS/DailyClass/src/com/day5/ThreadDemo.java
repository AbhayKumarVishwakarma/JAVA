package com.day5;


public class ThreadDemo {
     public static void main(String[] args) {
    	 
		Thread mainThread = Thread.currentThread();
		System.out.println("Name of the thread is : " + mainThread.currentThread());
		System.out.println("Priority of the thread is : " + mainThread.getPriority());
		System.out.println("State of the thread is : " + mainThread.getState());
		
        System.out.println();
		
		System.out.println("Making the main thread sleep for 5000MS");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Thread weaked up after 5000MS");
		
		System.out.println();
		
		mainThread.setName("Hello");
		mainThread.setPriority(Thread.NORM_PRIORITY + 3);
		System.out.println("New Name of the thread is : " + mainThread.getName());
		System.out.println("New Priority of the thread is : " + mainThread.getPriority());
	}
}
