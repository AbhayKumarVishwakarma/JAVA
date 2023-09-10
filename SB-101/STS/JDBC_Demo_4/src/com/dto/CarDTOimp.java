package com.dto;

public class CarDTOimp implements CarDTO {

    private String cId;
    private String mName;
    private int price;
    private int seats;
    private String comId;

	public CarDTOimp(String cId, String mName, int price, int seats, String comId) {
		super();
		this.cId = cId;
		this.mName = mName;
		this.price = price;
		this.seats = seats;
		this.comId = comId;
	}

	public CarDTOimp(String mName, int price, int seats, String comId) {
		super();
		this.mName = mName;
		this.price = price;
		this.seats = seats;
		this.comId = comId;
	}

	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	
	@Override
	public String toString() {
		return "CarDTOimp [cId=" + cId + ", mName=" + mName + ", price=" + price + ", seats=" + seats + ", comId="
				+ comId + "]";
	}
}
