package com.day1;

public class NonStaticMethod {
	
	public int convertToNumber(String number) {
		return Integer.parseInt(number);
	}

	public static void main(String[] args) {
		
		// ObjectName::methodName
		
		Intr6 i1 = new NonStaticMethod()::convertToNumber;
		int x = i1.convertToNumber("300");
		System.out.println(x);
		
		Intr6 i2 = (s) -> Integer.parseInt(s);
		int y = i2.convertToNumber("400");
		System.out.println(y);
	}
}
