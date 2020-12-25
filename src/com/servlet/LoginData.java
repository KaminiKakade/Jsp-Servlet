package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginData {
	public static boolean validate(String userName,String password) throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?useSSL=false", "root",
				"root");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from loginBean where userName = ? and password = ? ")) {
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
