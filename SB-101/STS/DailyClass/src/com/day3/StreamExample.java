package com.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.day2.Student;

public class StreamExample {
	
	public static boolean check(int i) {
		return i%2==0;
	}

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(21);
		arr.add(33);
		arr.add(44);
		arr.add(55);
		System.out.println(arr);
		
		// Using Predicate --> allMatch,anyMatch,noneMatch
		Predicate<Integer> isEven = i -> i%2==0;
		Predicate<Integer> isZero = i -> i<0;
		System.out.println("All elements of stream are even (Predicate) - " + arr.stream().allMatch(isEven));
		System.out.println("Any elements of stream are even (Predicate) - " + arr.stream().anyMatch(isEven));
		System.out.println("No negative element (Predicate) - " + arr.stream().noneMatch(isZero));
		System.out.println();
		
		// Using Method reference
		System.out.println("All elements of stream are even (Method reference) - " + arr.stream().allMatch(StreamExample::check));
		System.out.println("Any elements of stream are even (Method reference) - " + arr.stream().anyMatch(StreamExample::check));
		System.out.println("No negative element (Method reference) - " + arr.stream().noneMatch(StreamExample::check));
		System.out.println();
		// Using Lambda Expression
		System.out.println("All elements of stream are even (Lambda expression) - " + arr.stream().allMatch(i-> i%2==0));
		System.out.println("Any elements of stream are even (Lambda expression) - " + arr.stream().anyMatch(i-> i%2==0));
		System.out.println("No negative element (Lambda expression) - " + arr.stream().noneMatch(i -> i<0));
		System.out.println();
		
		// filter,sorted,map,collect(Collectors.toSet,toList,summarizingDouble,summingDouble),min,max,get
		List<Student> arr1 = new ArrayList<>();
		arr1.add(new Student("Yosh", 1, 300));
		arr1.add(new Student("Ram", 2, 800));
		arr1.add(new Student("Shyam", 3, 350));
		arr1.add(new Student("Raj", 4, 550));
		arr1.add(new Student("Raju", 5, 200)); 
		arr1.add(new Student("Ansu", 6, 150));
		List<String> arr2 = arr1.stream().filter(s -> s.getMarks()<500).sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).map(s -> s.getName()).collect(Collectors.toList());
		System.out.println(arr2);
		Stream<Student> arr3 = arr1.stream().filter(s -> s.getMarks()<500).sorted((o1, o2) -> o2.getName().compareTo(o1.getName())>0 ? 1 : -1);
		System.out.println(arr3.collect(Collectors.toSet()));
		System.out.println("Summary in double of student marks - " + arr1.stream().collect(Collectors.summarizingDouble(value -> value.getMarks())));
		System.out.println("Total marks of student in double - " + arr1.stream().collect(Collectors.summingDouble(value -> value.getMarks())));
		System.out.println("Min mark student - " + arr1.stream().min((o1, o2) -> o1.getMarks()>o2.getMarks()?1:-1).get());
		System.out.println("Max mark student - " + arr1.stream().max((o1, o2) -> o1.getMarks()>o2.getMarks()?1:-1).get());
		System.out.println();
		
		// count,collect(Collectors.toSet,averagingDouble),reduce,distinct,forEach
		List<Integer> list = Arrays.asList(1,1,4,8,2,5,7,3,6);
		list.forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println("Total elements in the stream are - " + list.stream().count());
		System.out.println("Element of stream in set, set contains - " + list.stream().collect(Collectors.toSet()));
		System.out.println("Average of all elements is - " + list.stream().collect(Collectors.averagingDouble(value -> value)));
		System.out.println("Sum of all elements is - " + list.stream().reduce(0, (i,j)->i+j));
		System.out.println("Multiplication of all elements is - " + list.stream().reduce(1, (i,j)->i*j));
		System.out.println("The total distinct element in the list is - "+ list.stream().distinct().count());
		System.out.print("The distinct element of the list are - ");
		list.stream().distinct().forEach(i->System.out.print(i + " "));
		System.out.println();
		
		// map(Integer -> Double),skip
		List<Double> listDouble = list.stream().map(t -> Double.valueOf(t)).toList();
		System.out.println("List of Double type element - " + listDouble);
        listDouble = listDouble.stream().distinct().toList();
		System.out.println("List of Double type distinct element - " + listDouble);
		listDouble = listDouble.stream().sorted().toList();
		System.out.println("List of Double type sorted element - " + listDouble);
		listDouble = listDouble.stream().skip(2).toList();
		System.out.println("Skip two element from list - " + listDouble);
		System.out.println("Min element in ListDouble - " + listDouble.stream().min((o1, o2) -> o1.compareTo(o2)).get());
		System.out.println("Max element in ListDouble - " + listDouble.stream().max((o1, o2) -> o1.compareTo(o2)).get());
	}
}
