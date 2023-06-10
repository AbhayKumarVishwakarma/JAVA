package com.masaischool.filedemo;

import java.io.Serializable;

public class Building{
	private float landArea;

	public Building() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Building(float landArea) {
		super();
		this.landArea = landArea;
	}

	@Override
	public String toString() {
		return "landArea=" + landArea;
	}
}

class House extends Building implements Serializable{
	private int noOfFloor;
	private int noOfRooms;
	
	public House(float landArea, int noOfFloor, int noOfRooms) {
		super(landArea);
		this.noOfFloor = noOfFloor;
		this.noOfRooms = noOfRooms;
	}
	
	@Override
	public String toString() {
		return "House [" + super.toString() + ", noOfFloor=" + noOfFloor + ", noOfRooms=" + noOfRooms + "]";
	}
}
