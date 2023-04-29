package com.dao;

import java.util.List;

import com.dto.CustomerDto;
import com.dto.RoomDto;
import com.exception.RoomException;

public interface RoomDao {
	public String addRoom(RoomDto room) throws RoomException;
	public RoomDto getRoomByRoomType(String name) throws RoomException;
	public List<RoomDto> getEmptyRoom() throws RoomException;
	public String addCustomerToRoom(CustomerDto customer, int roomNumber) throws RoomException;
	public String removeCustomerFromRoom(int customerId, int roomNumber) throws RoomException;
	public List<CustomerDto> getCustomerFromParticularRoom(int roomNumber) throws RoomException;
	public List<RoomDto> getAllRoomDetails();
}
