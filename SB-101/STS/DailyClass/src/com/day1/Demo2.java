package com.day1;

public class Demo2 implements Intr2 {

	@Override
	public void sayHello(String name) {
		System.out.println("Welcome " + name);
	}
	
	public static void main(String[] args) {
		Intr2 i2 = new Demo2();
		i2.sayHello("Abhay");  // abstract method
		System.out.println(i2.equals(i2)); // Object class method
		i2.fun1(); // Default method
		Intr2.fun2();  // Static method
	}

}
