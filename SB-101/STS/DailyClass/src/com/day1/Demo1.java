package com.day1;

public class Demo1 implements Intr1 {

	@Override
	public void sayHello(String name) {
		System.out.println("Welcome " + name);
	}
	
	public static void main(String[] args) {
		Intr1 i1 = new Demo1();
		i1.sayHello("Abhay");
	}

}
