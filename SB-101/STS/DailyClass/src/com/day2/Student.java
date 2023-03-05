package com.day2;

public class Student {
	
	private String name;
	private int rollNo;
	private int marks;
	
	public Student(String name, int rollNo, int marks) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", marks=" + marks + "]";
	}
}
