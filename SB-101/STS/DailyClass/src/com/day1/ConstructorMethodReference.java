package com.day1;

public class ConstructorMethodReference {
	
	ConstructorMethodReference(){
		System.out.println("Method reference using constructor");
	}

	public static void main(String[] args) {
		
		// ClassName::methodName
		
		Intr3 i1 = ConstructorMethodReference::new;
		i1.sayHello();
	}
}
