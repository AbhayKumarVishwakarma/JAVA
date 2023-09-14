package com.masaischool.revision_jdbc_hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		// code to make connection
		String URL = "jdbc:mysql://localhost:3306/revision_jdbc_hibernate";
		String USERNAME = "root";
		String PASSWORD = "root";

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter title ");
		String title = sc.nextLine();

		System.out.print("Enter publisher ");
		String publisher = sc.nextLine();

		System.out.print("Enter price ");
		double price = sc.nextDouble();
		sc.nextLine();

		System.out.print("Enter author name ");
		String author = sc.nextLine();

		System.out.print("Enter number of copies ");
		int noOfCopies = sc.nextInt();

		Connection connection = null;
		Savepoint savePoint = null;

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			connection.setAutoCommit(false);

			// Execute the query to insert the value
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO book " + "(title, publisher, price, author) VALUES (?, ?, ?, ?)");
			prepareStatement.setString(1, title);
			prepareStatement.setString(2, publisher);
			prepareStatement.setDouble(3, price);
			prepareStatement.setString(4, author);

			prepareStatement.executeUpdate();
			System.out.println("Book added to database");
			savePoint = connection.setSavepoint("After book Added");

			// code to get the book_id of the latest inserted book
			prepareStatement = connection.prepareStatement("SELECT booK_id FROM book WHERE title = ?");
			prepareStatement.setString(1, title);
			ResultSet resultSet = prepareStatement.executeQuery();
			resultSet.next();
			int book_id = resultSet.getInt(1);

			for (int i = 1; i <= noOfCopies; i++) {
				String copy_book_id = i + "_" + book_id;
				prepareStatement = connection.prepareStatement("INSERT INTO book_copy (copy_book_id) VALUES (?)");
				prepareStatement.setString(1, copy_book_id);
				prepareStatement.executeUpdate();
			}

			connection.commit();
			System.out.println("All copies of that book added to the database");

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			try {
				connection.rollback(savePoint);
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} finally {

			try {
				connection.close();  // closing the connection
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		sc.close();
	}
}
