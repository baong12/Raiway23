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

public class JDBCUtils {
	private static final String FILE_NOT_FOUND_EXCEPTION = "Lỗi không tìm thấy file";
	private static final String IO_EXCEPTION = "Lỗi không đọc được file";
	private static final String CLASS_NOT_FOUND_EXCEPTION = "Lỗi đăng ký driver";
	public static final String SQL_EXCEPTION = "Lỗi kết nối SQL";

	public static Connection connection = null;

	public static void isConnectedForTesting() {
		connect();
		System.out.println("Connect success!");
	}

	public static Connection connect() {
		try {
			if (connection == null || connection.isClosed()) {
				Properties properties = new Properties();
				properties.load(new FileInputStream("src/main/resource/database.properties"));
				String DB_URL = properties.getProperty("url");
				String USER_NAME = properties.getProperty("username");
				String PASSWORD = properties.getProperty("password");
				String DRIVER_NAME = properties.getProperty("driverName");
				Class.forName(DRIVER_NAME);
				connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			}
		} catch (FileNotFoundException e) {
			System.out.println(FILE_NOT_FOUND_EXCEPTION);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(IO_EXCEPTION);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(CLASS_NOT_FOUND_EXCEPTION);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(SQL_EXCEPTION);
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
			System.out.println(SQL_EXCEPTION);
			e.printStackTrace();
		}
	}

	public static Statement createStatement() {
		Statement statement = null;
		try {
			connect();
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println(SQL_EXCEPTION);
			e.printStackTrace();
		}
		return statement;
	}

	public static PreparedStatement prepareStatement(String sql) {
		PreparedStatement preparedStatement = null;
		try {
			connect();
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println(SQL_EXCEPTION);
			e.printStackTrace();
		}
		return preparedStatement;
	}
}
