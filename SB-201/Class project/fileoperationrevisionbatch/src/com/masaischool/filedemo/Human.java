package com.masaischool.filedemo;

import java.io.Serializable;

public class Human implements Serializable {
	private String name;
	private int age;
	private double weight;
	
	public Human(String name, int age, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
}
