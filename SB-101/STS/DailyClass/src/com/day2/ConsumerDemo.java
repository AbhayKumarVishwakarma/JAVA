package com.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void add(int a) {
		System.out.println(a);
	}
	public static void main(String[] args) {
		
		// accept() method
		Consumer<Integer> c1 = ConsumerDemo::add;
		c1.accept(10);
		
		Consumer<Integer> c11 = System.out::println;
		c11.accept(100);
		 
		Consumer<String> c2 = s -> System.out.println(s);
		c2.accept("Ankit");
		
		
	 	Consumer<Student> stu = s -> {
			System.out.println(s.getName()+" got "+s.getMarks()+" marks.");
		};
		stu.accept(new Student("Ankit", 1, 100));
		System.out.println("-----------------------");
		
		// using forEach default method of consumer interface
		List<Student> arr = new ArrayList<>();
		arr.add(new Student("Mukesh", 1, 300));
		arr.add(new Student("Ram", 2, 800));
		arr.add(new Student("Shyam", 3, 350));
		arr.add(new Student("Raj", 4, 550));
		arr.add(new Student("Raju", 5, 200));
		arr.forEach(s -> System.out.println(s.getName()+" got "+s.getMarks()+" marks."));
		
		List<Integer> arr1 = new ArrayList<>();
		arr1.add(10);
		arr1.add(20);
		arr1.add(30);
		arr1.add(40);
		arr1.add(50);
		arr1.forEach(a -> System.out.println(a));
	}
}
