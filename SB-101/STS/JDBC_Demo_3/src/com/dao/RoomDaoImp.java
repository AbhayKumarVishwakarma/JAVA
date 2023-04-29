package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.CustomerDto;
import com.dto.CustomerDtoImp;
import com.dto.RoomDto;
import com.dto.RoomDtoImp;
import com.exception.RoomException;

public class RoomDaoImp implements RoomDao {

	@Override
	public String addRoom(RoomDto room) throws RoomException {
		String msg = "Unable to add room";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "insert into room values (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, room.getRoomNumber());
			ps.setString(2,room.getRoomType());
			ps.setDouble(3, room.getPricePerNight());
			ps.setInt(4, room.getMaximumPerson());
			ps.setBoolean(5, room.isRoomEmpty());
			
			if(ps.executeUpdate()>0) msg = "Room added successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RoomException("Unable to add room, something went wrong");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return msg;
	}

	@Override
	public RoomDto getRoomByRoomType(String name) throws RoomException {
		RoomDto rDTO = null;
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "select * from room where roomType = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				rDTO = new RoomDtoImp(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getBoolean(5));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RoomException("Unable to add room, something went wrong");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rDTO;
	}

	@Override
	public List<RoomDto> getEmptyRoom() throws RoomException {
		List<RoomDto> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "select * from room where isRoomEmpty = true";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new RoomDtoImp(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getBoolean(5)));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RoomException("Unable to add room, something went wrong");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public String addCustomerToRoom(CustomerDto customer, int roomNumber) throws RoomException {
		String msg = "Unable to add Customer to room";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query1 = "insert into customer values (?, ?, ?, ?)";
			PreparedStatement ps1 = con.prepareStatement(query1);
			
			String query2 = "update room set isRoomEmpty = false where roomNumber = ?";
			PreparedStatement ps2 = con.prepareStatement(query2);
			
			ps1.setInt(1, customer.getCustomerId());
			ps1.setString(2, customer.getCustomerName());
			ps1.setString(3, customer.getAddress());
			ps1.setInt(4, customer.getRoomNumber());
			ps2.setInt(1, customer.getRoomNumber());
			
			if(ps1.executeUpdate()>0 && ps2.executeUpdate()>0) msg = "Customer added to room successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RoomException("Unable to add room, something went wrong");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return msg;
	}

	@Override
	public String removeCustomerFromRoom(int customerId, int roomNumber) throws RoomException {
		String msg = "Unable to remove from room";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query1 = "delete from customer where customerId = ?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			
			String query2 = "update room set isRoomEmpty = true where roomNumber = ?";
			PreparedStatement ps2 = con.prepareStatement(query2);
			
			ps1.setInt(1, customerId);
			ps2.setInt(1, roomNumber);
			
			if(ps1.executeUpdate()>0 && ps2.executeUpdate()>0) msg = "Customer removed from room successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RoomException("Unable to add room, something went wrong");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return msg;
	}

	@Override
	public List<CustomerDto> getCustomerFromParticularRoom(int roomNumber) throws RoomException {
		List<CustomerDto> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "select * from customer where roomNumber = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, roomNumber);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new CustomerDtoImp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RoomException("Unable to add room, something went wrong");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<RoomDto> getAllRoomDetails() {
		List<RoomDto> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "select * from room";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new RoomDtoImp(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getBoolean(5)));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
    
}
