package net.wn.util;

import java.sql.SQLException;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDb {
	private static String driveClassName;
	private static String url;
	private static String user;
	private static String password;
	static {
		try {
			Properties properties = new Properties();
			properties.load(ConnectDb.class.getClassLoader().getResourceAsStream("mysql.properties"));
			driveClassName = (String) properties.get("driverClassName");
			url = (String) properties.get("url");
			user = (String) properties.get("username");
			password = (String) properties.get("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection Connect() {

		Connection conn = null;
		// load driver
		try {
			Class.forName(driveClassName);
		} catch (ClassNotFoundException e) {
			System.out.println("load driver failed!");
			e.printStackTrace();
		}
		// connect db
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("connect failed!");
			e.printStackTrace();
		}

		return conn;
	}
}
