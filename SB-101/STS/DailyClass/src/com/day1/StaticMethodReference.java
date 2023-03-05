package com.day1;

public class StaticMethodReference {

	public static void say(String name) {
		System.out.println("Welcome " + name + " from static method reference");
	}
	
	public static int adding(int a, int b) {
		return a+b;
	}
	
	public static int convertToNumber(String number) {
		return Integer.parseInt(number);
	}
	
	public static void main(String[] args) {
		
		// ClassName::methodName     --> Static method reference
		
		Intr1 i1 = StaticMethodReference::say;
		i1.sayHello("AB");
		
		Intr5 i2 = StaticMethodReference::adding;
		int x = i2.add(10, 10);
		System.out.println(x);
		
		//-------------------
		Intr6 i3 = StaticMethodReference::convertToNumber;
		int y = i3.convertToNumber("200");
		System.out.println(y);
		
		Intr6 i4 = Integer::parseInt;
		int z = i4.convertToNumber("1000");
		System.out.println(z);
		
		Intr6 i5 = s -> Integer.parseInt(s);
		int q = i5.convertToNumber("100");
		System.out.println(q+1);
	}
}
