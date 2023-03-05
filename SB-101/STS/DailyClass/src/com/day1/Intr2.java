package com.day1;

@FunctionalInterface
public interface Intr2{
	abstract void sayHello(String name);
	
	// Object class
	boolean equals(Object o);
	
	// Default method
	default void fun1() {
		System.out.println("Inside default method");
	}
	
	// static method
	static void fun2() {
		System.out.println("Inside static method");
	}
}
