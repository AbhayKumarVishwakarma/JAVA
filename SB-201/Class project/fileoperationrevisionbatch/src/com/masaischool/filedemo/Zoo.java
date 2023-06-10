package com.masaischool.filedemo;

import java.io.Serializable;

class Dog{
	private float height;
	private float weight;
	
	public Dog(float height, float weight) {
		super();
		this.height = height;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Dog [height=" + height + ", weight=" + weight + "]";
	}
}

class Cat implements Serializable{
	private String sound;
	private String dwelling;
	
	public Cat(String sound, String dwelling) {
		super();
		this.sound = sound;
		this.dwelling = dwelling;
	}

	@Override
	public String toString() {
		return "Cat [sound=" + sound + ", dwelling=" + dwelling + "]";
	}
}

public class Zoo implements Serializable {
	private String name;
	private Cat cat;	//this class must also implement the Serializable interface
	private transient Dog dog;	//this object will not be serialized
	final static double minimumAreaInAcres = 3;	//static variables are never Serialized
	
	public Zoo(String name, Cat cat, Dog dog) {
		super();
		this.name = name;
		this.cat = cat;
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Zoo [name=" + name + ", cat=" + cat + ", dog=" + dog + "]";
	}
}
