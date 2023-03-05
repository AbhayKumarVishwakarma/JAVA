package com.day4;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
     public static void main(String[] args) {
    	Set<Student> arr = new HashSet<>();
 		arr.add(new Student("Mukesh", 1, 300));
 		arr.add(new Student("Ram", 2, 800));
 		arr.add(new Student("Shyam", 3, 350));
 		arr.add(new Student("Raj", 4, 550));
 		arr.add(new Student("Raju", 5, 200));
 		arr.add(new Student("Raju", 5, 200));
 		
 		System.out.println("This is old Set :");
 		arr.stream().forEach(t -> System.out.println(t));
 		System.out.println();
 		
 		Set<Student> arr1 = arr.stream().filter(t -> t.getMarks()<500).map(t -> t).collect(Collectors.toSet());
 		System.out.println("This is new set :");
 		arr1.stream().forEach(t -> System.out.println(t));
	}
}
