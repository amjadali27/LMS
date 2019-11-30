package com.geeks.lms.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String username = "root";
	private static String password = "asmat";
	private DBConnection(){}
	public static Connection con=null;
	public static Connection getConnection(){
		if(con==null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",username,password);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return con;
	}
}
