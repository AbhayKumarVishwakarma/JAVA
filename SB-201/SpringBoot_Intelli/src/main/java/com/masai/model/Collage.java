package com.masai;
public class Collage {
	private int collageID;
	private String collageName;
	private String location;
	public Collage(int collageID, String collageName, String location) {
		super();
		this.collageID = collageID;
		this.collageName = collageName;
		this.location = location;
	}
	public int getCollageID() {
		return collageID;
	}
	public void setCollageID(int collageID) {
		this.collageID = collageID;
	}
	public String getCollageName() {
		return collageName;
	}
	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
