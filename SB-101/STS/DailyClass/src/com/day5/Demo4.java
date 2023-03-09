package com.day5;

public class Demo4 implements Runnable {

	@Override
	public void run() {
		System.out.println("Now the thread is running ...");
	}

	public static void main(String[] args) {
		Runnable r = new Demo4();
		Thread t = new Thread(r, "My new thread");
		t.start();
		System.out.println(t.getName());
	}
}
