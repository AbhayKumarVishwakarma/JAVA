package com.day2;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
	public static void add(int a, int b) {
		System.out.println(a+b);
	}
	public static void main(String[] args) {
		BiConsumer<Integer, Integer> b1 = BiConsumerDemo::add;
		b1.accept(10, 5);
	}
}
