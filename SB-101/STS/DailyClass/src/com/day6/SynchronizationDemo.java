package com.day6;


class A{
	public void printMessage(String msg) {
		System.out.print("[");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.print(msg);
		System.out.println("]");
	}
}

class B implements Runnable{
	A a;
	String msg;
	
	B(A a, String msg){
		this.a = a;
		this.msg = msg;
	}

	@Override
	public void run() {
		synchronized (a) {
			a.printMessage(msg);
		}
//		synchronized (A.class) {
//			a.printMessage(msg);
//		}
	}
	
}

public class SynchronizationDemo {
    public static void main(String[] args) {
		A a = new A();
		//A a1 = new A();
		
		B b1 = new B(a, "Hello");
		B b2 = new B(a, "World");
//		B b2 = new B(a1, "World");
		B b3 = new B(a, "Java");
		
		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b2);
		Thread t3 = new Thread(b3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	
		System.out.println("Bye Bye Main");
	}
}

/*
Output
[Welcome]
[Java]
[Hello]
Bye Bye main

Now make following changes in the example

A a1 = new A();
A a2 = new A();
B b1 = new B(a1, "Welcome");
B b2 = new B(a2, "Hello");
B b3 = new B(a1, "Java");

Output
[[HelloWelcome]
]
[Java]
Bye Bye main

Now just make following changes
synchronized (A.class) {
	a.printMessage(msg);			
}

Output
[Welcome]
[Java]
[Hello]
Bye Bye main  
*/