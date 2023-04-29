package com.dto;

public class RoomDtoImp implements RoomDto {
	private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private int maximumPerson;
    private boolean isRoomEmpty;
	public RoomDtoImp(int roomNumber, String roomType, double pricePerNight, int maximumPerson, boolean isRoomEmpty) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.pricePerNight = pricePerNight;
		this.maximumPerson = maximumPerson;
		this.isRoomEmpty = isRoomEmpty;
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
	public String getRoomType() {
		return roomType;
	}
	@Override
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	@Override
	public double getPricePerNight() {
		return pricePerNight;
	}
	@Override
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	@Override
	public int getMaximumPerson() {
		return maximumPerson;
	}
	@Override
	public void setMaximumPerson(int maximumPerson) {
		this.maximumPerson = maximumPerson;
	}
	@Override
	public boolean isRoomEmpty() {
		return isRoomEmpty;
	}
	@Override
	public void setRoomEmpty(boolean isRoomEmpty) {
		this.isRoomEmpty = isRoomEmpty;
	}
	@Override
	public String toString() {
		return "RoomDtoImp [roomNumber=" + roomNumber + ", roomType=" + roomType + ", pricePerNight=" + pricePerNight
				+ ", maximumPerson=" + maximumPerson + ", isRoomEmpty=" + isRoomEmpty + "]";
	}
}
