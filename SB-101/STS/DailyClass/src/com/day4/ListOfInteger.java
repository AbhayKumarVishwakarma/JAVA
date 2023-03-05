package com.day4;

import java.util.Arrays;
import java.util.List;

public class ListOfInteger {
     public static void main(String[] args) {
		List<Integer> oldList = Arrays.asList(2,3,5,7,6,9);
		System.out.print("This is oldList : ");
		oldList.stream().forEach(t -> System.out.print(t + " "));
		System.out.println();
		System.out.println();
		
		List<Integer> newList = oldList.stream().map(t -> t*t).toList();
		System.out.print("This is newList : ");
		newList.stream().forEach(t -> System.out.print(t + " "));
	}
}
