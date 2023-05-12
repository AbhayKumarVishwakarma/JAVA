package com.masai.model;

public class StudentDTO {
	private String name;
	private String address;
	private Integer marks;
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(String name, String address, Integer marks) {
		super();
		this.name = name;
		this.address = address;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "StudentDTO [name=" + name + ", address=" + address + ", marks=" + marks + "]";
	}
}
