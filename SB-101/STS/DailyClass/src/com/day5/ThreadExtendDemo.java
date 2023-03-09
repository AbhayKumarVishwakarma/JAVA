package com.day5;

public class ThreadExtendDemo extends Thread {
	@Override
	public void run() { //step-2
		//whatever you wanted to make the new thread do, write here
		System.out.println("New Thread is having name " + Thread.currentThread().getName());
		for(int i = 0; i < 100; i++) {
			System.out.print("$");
		}
		System.out.println("Bye Bye " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		//Create object of class that implements Runnable interface
		ThreadExtendDemo t1 = new ThreadExtendDemo();	//step-3	New thread is created but it is not in execution so its state is NEW
		//to put the new Thread in the execution, call the start() method using the Thread class
		System.out.println("Current state : " + t1.getState());
		t1.start();	//step-4	New thread is in execution its state is RUNNABLE
		System.out.println("Current state : " + t1.getState());
		//main thread will also continue its execution and the new thread will execute the body of run method
		for(int i = 0; i < 100; i++) {
			System.out.print("%");
		}

		//code to ensure that main thread should finish in last
		try{
			t1.join();	//execution of main thread will be suspended until the Thread-C completes its execution (died)
		}catch(InterruptedException ex) {
			System.out.println();
		}
		System.out.println("Bye Bye main");

	}
}
