package com.day5;

public class Demo1 extends Thread {
	public void run() {
		System.out.println("Thread is running...");	
	}

	public static void main(String[] args) {
		Demo1 t1 = new Demo1();
		t1.run();
	}
}
