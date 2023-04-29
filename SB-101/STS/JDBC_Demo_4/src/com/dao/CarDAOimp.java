package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.CarDTO;
import com.exception.NoRecordFound;
import com.exception.SomeThingWentWrongException;

public class CarDAOimp implements CarDAO {

	@Override
	public void addCar(CarDTO car) throws SomeThingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "insert into car values(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, car.getcId());
			ps.setString(2, car.getmName());
			ps.setInt(3, car.getPrice());
			ps.setInt(4, car.getSeats());
			ps.setString(5, car.getComId());
			
			if(ps.executeUpdate() > 0) System.out.println("Car added successfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Unable to add car");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void showAllInfromationAboutCar() throws SomeThingWentWrongException, NoRecordFound {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "select car_id, model_name, price, total_seats, com.company_name, com.turnover_in_crores from car c join company com on c.company_id = com.company_id order by car_id;";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Car Id: " + rs.getString(1) + " Model Name: " + rs.getString(2) + " Price: "+ rs.getInt(3) + " Total Seats: " + rs.getInt(4) + " Company Name: " + rs.getString(5) + " Company Turnover: " + rs.getInt(6) + " Crores");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Unable to show car details");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateCar(CarDTO car) throws SomeThingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "update car set model_name = ?, price = ?, total_seats = ?, company_id = ? where car_id = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, car.getmName());
			ps.setInt(2, car.getPrice());
			ps.setInt(3, car.getSeats());
			ps.setString(4, car.getComId());
			ps.setString(5, car.getcId());
			
			if(ps.executeUpdate() > 0) System.out.println("Car updated successfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Unable to update car");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteCar(String carId) throws SomeThingWentWrongException, NoRecordFound {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "delete from car where car_id = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, carId);
			
			if(ps.executeUpdate() > 0) System.out.println("Car updated successfully");
			else throw new NoRecordFound("Not find any car with id");
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Unable to delete car");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void showCompNameModel() throws SomeThingWentWrongException, NoRecordFound {
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			String query = "select company_name, count(model_name) from car c join company com on c.company_id = com.company_id group by company_name";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Company name: " + rs.getString(1) + " Model Name: " + rs.getString(2));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Unable to show car details");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
