package com.jspiders.deletepackagejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleUpdate {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("update ajith.student set sno = 4 where sno = 2");
			System.out.println("executed successfully and updated " + i);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
