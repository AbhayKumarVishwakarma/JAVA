package com.day5;

public class Demo2 implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread is running...");
	}
	public static void main(String[] args) {
		Demo2 d = new Demo2();
		Thread t2 = new Thread(d);   // Using the constructor Thread(Runnable r) 
		t2.start();
	}
}
