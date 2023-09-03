package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Product;
import com.exception.ProductException;

public class ProductDAOimp implements ProductDAO {

	@Override
	public String addProduct(Product product) throws ProductException {
        String msg = "Something went wrong";
        Connection con = null;
        try {
			con = DBUtils.getConnectionToDatabases();
			String query = "insert into product values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			if(ps.executeUpdate() > 0) msg = "Product added successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new ProductException("Unable to add product"); 
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
	public List<Product> getAllProducts() throws ProductException {
		List<Product> list = new ArrayList<>();
		Connection con = null;
        try {
			con = DBUtils.getConnectionToDatabases();
			String query = "select * from product";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new ProductException("Unable to show product"); 
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
	public List<Product> getAllProductQuantityLessThan(int quantity) throws ProductException {
		List<Product> list = new ArrayList<>();
		Connection con = null;
        try {
			con = DBUtils.getConnectionToDatabases();
			String query = "select * from product where quantity < ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, quantity);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new ProductException("Unable to show product"); 
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
	public String addProductQuantity(int productId, int Quantity) throws ProductException {
		String msg = "Something went wrong";
        Connection con = null;
        try {
			con = DBUtils.getConnectionToDatabases();
			String query = "update product set quantity = ? where productId = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, Quantity);
			ps.setInt(1, productId);
			
			if(ps.executeUpdate()>0) msg = "Product quantity updated successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new ProductException("Unable to add product quantity"); 
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
	public String deleteProductByProductName(String pname) throws ProductException {
		String msg = "Something went wrong";
        Connection con = null;
        try {
			con = DBUtils.getConnectionToDatabases();
			String query = "delete from product where productName = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pname);
			
			if(ps.executeUpdate() > 0) msg = "Product deleted successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new ProductException("Unable to delete product"); 
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
	public Product getProductByProductName(String pname) throws ProductException {
		Product pro = null;
		Connection con = null;
        try {
			con = DBUtils.getConnectionToDatabases();
			String query = "select * from product where productName = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pname);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pro = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new ProductException("Unable to show product"); 
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pro;
	}

	@Override
	public void deleteProductWhoseNameStart(String name) throws ProductException {
        Connection con = null;
        try {
			con = DBUtils.getConnectionToDatabases();
			String query = "delete from product where productName = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new ProductException("Unable to delete product"); 
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
