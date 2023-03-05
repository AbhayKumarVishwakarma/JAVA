package com.day4;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
     public static void main(String[] args) {
    	List<Product> oldList = new ArrayList<>();
    	oldList.add(new Product(1, "Shirt", 10, 700));
    	oldList.add(new Product(2, "Pant", 10, 1200));
    	oldList.add(new Product(3, "T-Shirt", 30, 400));
    	oldList.add(new Product(4, "Shoes", 20, 2000));
    	oldList.add(new Product(5, "Jacket", 25, 1500));
    	
    	System.out.println("This is from oldList :");
    	oldList.forEach(t -> System.out.println(t));
    	System.out.println();
 		
    	List<Product> newList = oldList.stream().filter(t -> t.getQuantity()>10).sorted((o1, o2) -> o1.getPrice()>o2.getPrice() ? 1 : -1).toList();
    	
    	System.out.println("This is from newList :");
    	newList.forEach(t -> System.out.println(t));
	}
}
