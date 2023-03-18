package com.day8;

import java.io.Serializable;

public class Human implements Serializable {
	int age;
	String name;
	char gender;
	
	public Human(int age, String name, char gender) {
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + ", gender=" + gender + "]";
	}    
}
