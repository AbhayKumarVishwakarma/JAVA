package com.day4;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
	public static void main(String[] args) {
		List<Student> arr = new ArrayList<>();
		arr.add(new Student("Mukesh", 1, 300));
		arr.add(new Student("Ram", 2, 800));
		arr.add(new Student("Shyam", 3, 350));
		arr.add(new Student("Raj", 4, 550));
		arr.add(new Student("Raju", 5, 200));
		
		Student s = arr.stream().max((o1, o2) -> o1.getMarks()>o2.getMarks()?1:-1).get();
		System.out.println("Student who's got maximum mark : " + s);
	}
}
