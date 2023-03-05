package com.day2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class ComputeIfAbsent_FunctionMethod {

	public static void main(String[] args) {
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "Monday");
		map.put(2, "Tuesday");
		map.put(3, "Wednesday");
		map.put(5, "Friday");
		map.put(6, "Saturday");
		
		System.out.println(map);
		System.out.println();
		
		Function<Integer, String> f1 = dayNum -> {
			String dayName = null;
			switch (dayNum){
			case 1:
				dayName = "Mon";
				break;
			case 2:
				dayName = "Tue";
				break;
			case 3:
				dayName = "Wed";
				break;
			case 4:
				dayName = "Thu";
				break;
			case 5:
				dayName = "Fri";
				break;
			case 6:
				dayName = "Sat";
				break;
			case 7:
				dayName = "Sun";
				break;
			}
			return dayName;
		};
		
		System.out.println(map.computeIfAbsent(4, f1));
		System.out.println(map);
		System.out.println();
		
		System.out.println(map.computeIfAbsent(1, f1));
		System.out.println(map);
		System.out.println();
		
		System.out.println(map.computeIfAbsent(8, f1));
		System.out.println(map);
		System.out.println();
	}
}
