package com.masaischool.filedemo;

import java.io.Serializable;

public class Animal implements Serializable{
	private String dwelling;
	private float weight;
	
	public Animal(String dwelling, float weight) {
		super();
		this.dwelling = dwelling;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "dwelling=" + dwelling + ", weight=" + weight;
	}
}

class Lion extends Animal{
	private float height;

	public Lion(String dwelling, float weight, float height) {
		super(dwelling, weight);
		this.height = height;
	}

	@Override
	public String toString() {
		return "Lion [" + super.toString() + ", height=" + height + "]";
	}
}

class Monkey extends Animal{
	private float leapDistance;

	public Monkey(String dwelling, float weight, float leapDistance) {
		super(dwelling, weight);
		this.leapDistance = leapDistance;
	}
	
	@Override
	public String toString() {
		return "Monkey [" + super.toString() + ", leapDistance=" + leapDistance + "]";
	}
}