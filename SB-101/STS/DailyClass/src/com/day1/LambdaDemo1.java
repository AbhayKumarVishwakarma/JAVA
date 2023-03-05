package com.day1;

public class LambdaDemo1 {
    public static void main(String[] args) {
    	
    	//------------------------------------------------------------------
    	// Without lambda expression / Anonymous inner class method
    	Intr1 i = new Intr1() {
    		@Override
    		public void sayHello(String name) {
    			System.out.println("Welcome int i " + name);
    		}
    	}; 
    	i.sayHello("AB");
    	
    	// With lambda expression
		Intr1 i1 = (String name) -> {
			System.out.println("Welcome in i1 " + name);
		};
		i1.sayHello("AB");
		
		Intr1 i2 = (name) -> System.out.println("Welcome in i2 " + name);
		i2.sayHello("AB");
		
		Intr2 i3 = name -> System.out.println("Welcome in i3 " + name);
		i3.sayHello("AB");
		
		//-------------------------------------------------------------------
		// zero argument
		Intr3 i4 = () -> System.out.println("Hello user");
		i4.sayHello();
		
		// Two argument
		Intr4 i5 = (int a , int b) -> 	System.out.println(a+b);
		i5.add(10, 5);
		
		// return 
		Intr5 i6 = (int a, int b) -> {
			return a+b;
		};
		Intr5 i7 = (a, b) -> a+b;
		System.out.println(i6.add(20, 20));
		System.out.println(i7.add(20, 20));
	}
}
