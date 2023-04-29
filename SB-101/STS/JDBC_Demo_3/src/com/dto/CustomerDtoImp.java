package com.dto;

public class CustomerDtoImp implements CustomerDto {
     private int customerId;
     private String customerName;
     private String address;
     private int roomNumber;
	public CustomerDtoImp(int customerId, String customerName, String address, int roomNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.roomNumber = roomNumber;
	}
	@Override
	public int getCustomerId() {
		return customerId;
	}
	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String getCustomerName() {
		return customerName;
	}
	@Override
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int getRoomNumber() {
		return roomNumber;
	}
	@Override
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	@Override
	public String toString() {
		return "CustomerDtoImp [customerId=" + customerId + ", customerName=" + customerName + ", address=" + address
				+ ", roomNumber=" + roomNumber + "]";
	}
}
