package com.day5;

public class Demo4 implements Runnable {

	@Override
	public void run() {
		System.out.println("Now the thread is running ...");
	}

	public static void main(String[] args) {
		Runnable r = new Demo4();  // object of class Demo4 which implements Runnable interface
		Thread t = new Thread(r, "My new thread");  // passing runnable obj in Thread class
		t.start();   // stating thread by using start method
		System.out.println(t.getName());
	}
}
