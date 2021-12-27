package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private static final String FILE_NOT_FOUND_EXC = "Lỗi không tìm thấy file";
	private static final String IO_EXC = "Lỗi IO";
	private static final String CLASS_NOT_FOUND_EXC = "Lỗi đăng ký driver";
	public static final String SQL_EXC = "Lỗi kết nối SQL";

	public static Connection connection;

	public static void isConnectedForTesting() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/resource/database.properties"));
			String DB_URL = properties.getProperty("url");
			String USER_NAME = properties.getProperty("username");
			String PASSWORD = properties.getProperty("password");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (FileNotFoundException e) {
			System.out.println(FILE_NOT_FOUND_EXC);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(IO_EXC);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(CLASS_NOT_FOUND_EXC);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		}
		System.out.println("Connect success!");
	}

	public static Connection connect() {
		try {
			if (connection == null || connection.isClosed()) {
				isConnectedForTesting();
			}
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		}
		return connection;
	}

	public static void disconnect() {
		try {
			if (connection == null || connection.isClosed()) {
				return;
			} else {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		}
	}
	
	public static Statement createStatement() throws SQLException {
		connect();
		return connection.createStatement();
	}
	
	public static PreparedStatement prepareStatement(String sql) throws SQLException {
		connect();
		return connection.prepareStatement(sql);
	}
}
