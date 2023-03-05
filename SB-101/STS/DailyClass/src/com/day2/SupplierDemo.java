package com.day2;

import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		Supplier<String> s1 = () -> "In supplier method using lambda expression";
		System.out.println(s1.get());
		
		Supplier<Student> s2 = () -> new Student("Ankit", 1, 100);
		System.out.println(s2.get());
		
		Supplier<Integer> s3 = () -> 100;
		Integer x = s3.get();
		System.out.println(x);
	}
}
