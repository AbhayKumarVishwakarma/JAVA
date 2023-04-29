package com.dto;

public interface RoomDto {
	public int getRoomNumber();
	public void setRoomNumber(int roomNumber);
	public String getRoomType();
	public void setRoomType(String roomType);
	public double getPricePerNight();
	public void setPricePerNight(double pricePerNight);
	public int getMaximumPerson();
	public void setMaximumPerson(int maximumPerson);
	public boolean isRoomEmpty();
	public void setRoomEmpty(boolean isRoomEmpty);
}
