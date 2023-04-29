package com.one.dto;

public class DepartmentDTOimp implements DepartmentDTO {
	private int did;
    private String dname;
    private String location;
	public DepartmentDTOimp(int did, String dname, String location) {
		super();
		this.did = did;
		this.dname = dname;
		this.location = location;
	}
	@Override
	public int getDid() {
		return did;
	}
	@Override
	public void setDid(int did) {
		this.did = did;
	}
	@Override
	public String getDname() {
		return dname;
	}
	@Override
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String getLocation() {
		return location;
	}
	@Override
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "DepartmentDTOimp [did=" + did + ", dname=" + dname + ", location=" + location + "]";
	}
}
