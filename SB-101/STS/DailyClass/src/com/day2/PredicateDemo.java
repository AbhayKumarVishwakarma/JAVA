
package com.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		// public boolean test(T t);
		Predicate<Integer> p = num -> num%2==0;
		System.out.println(p.test(10));
		System.out.println(p.test(11));
		
		// public boolean removeIf(Predicate filter);
		List<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		arr.add(50);
		System.out.println(arr);
		arr.removeIf(num -> num<25);
		System.out.println(arr);
		
		Predicate<List<Integer>> x = a -> a.add(66);
		System.out.println(x.test(arr));
		System.out.println(arr);
	}
}
