package com.day6;

class T1 extends Thread{
	T1(String name){
		super(name);
	}
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i=0; i<10; i++)
			System.out.println("Excuting : " + name);
	}
}

public class YieldDemo {
     public static void main(String[] args) {
		T1 t1 = new T1("First");
		t1.setPriority(5);
		
		T1 t2 = new T1("Second");
		t2.setPriority(10);
		
		t1.start();
		t2.start();
		
		Thread.yield();  //main thread will give chance to Thread "First" and "Second"
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("Bye Bye main");
	}
}
