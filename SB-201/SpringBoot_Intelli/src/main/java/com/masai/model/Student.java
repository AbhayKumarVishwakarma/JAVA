package com.masai;

public class Student {
	private int roll;
	private String name;
	private Integer marks;
	private Collage collage;
	public Student(int roll, String name, Integer marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}
	public Student(int roll, String name, Integer marks, Collage collage) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		this.collage = collage;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public Collage getCollage() {
		return collage;
	}
	public void setCollage(Collage collage) {
		this.collage = collage;
	}
//	@Override
//	public String toString() {
//		return "Student [roll=" + roll + ", name=" + name + ", marks=" + marks + "]";
//	}
}
