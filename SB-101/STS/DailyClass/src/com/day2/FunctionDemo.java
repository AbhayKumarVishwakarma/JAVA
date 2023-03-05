package com.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {
	
	public static int sum(List<Integer> list) {
		int sum = 0;
		for(int i=0; i<list.size(); i++) sum += list.get(i);
		return sum;
	}

	public static void main(String[] args) {
		
		// Lambda expression
		Function<String, Integer> f1 = s -> Integer.parseInt(s);
		System.out.println(f1.apply("100")+1);
		
		// Method reference
		Function<String, Integer> f2 = Integer::parseInt;
		System.out.println(f2.apply("100")+2);
		
		List<Integer> arr1 = new ArrayList<>();
		arr1.add(10);
		arr1.add(20);
		arr1.add(30);
		arr1.add(40);
		arr1.add(50);
		Function<List<Integer>, Integer> arr = FunctionDemo::sum;
		System.out.println("Total sum is " + arr.apply(arr1));
	}
}
