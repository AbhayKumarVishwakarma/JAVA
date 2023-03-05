package com.day4;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(marks, name, rollNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return marks == other.marks && Objects.equals(name, other.name) && rollNo == other.rollNo;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", marks=" + marks + "]";
	}
}
