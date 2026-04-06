package com.scm.generic_utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Database_Utility_True {
	Connection conn;

	public void connectToDB(String query) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(null, null, null);
		System.out.println("connected to DB");
	}

	// To get the data from particular row
	public String executeQuery(String query, int columIndex) throws SQLException {
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery(query);
		while (result.next()) {
			return result.getString(columIndex);
		}
		return null;
	}

	public void closeDBConnection() throws SQLException {
		conn.close();
	}

	// to check the expected data is present in DB
	public boolean isDataPresent(String query, int coloumNum, String expectedData) throws SQLException {
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery(query);
		while (result.next()) {
			String data = result.getString(coloumNum);
			if (data != null && data.equalsIgnoreCase(expectedData)) {
				System.out.println(data + " is present");
				result.close();
				state.close();
				return true;
			}
		}
		result.close();
		state.close();
		System.out.println("data is not present");
		return false;
	}
}
