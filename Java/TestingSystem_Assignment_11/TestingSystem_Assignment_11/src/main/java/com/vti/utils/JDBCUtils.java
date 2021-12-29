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
	private static final String FILE_NOT_FOUND_EXC = "Lỗi không tìm thấy file";
	private static final String IO_EXC = "Lỗi không đọc được file";
	private static final String CLASS_NOT_FOUND_EXC = "Lỗi đăng ký driver";
	public static final String SQL_EXC = "Lỗi kết nối SQL";

	public static Connection connection;

	public static void isConnectedForTesting() {
		try {
			connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connect success!");
	}

	public static Connection connect() throws Exception {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/resource/database.properties"));
			String DB_URL = properties.getProperty("url");
			String USER_NAME = properties.getProperty("username");
			String PASSWORD = properties.getProperty("password");
			String DRIVER_NAME = properties.getProperty("driverName");
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (FileNotFoundException e) {
			throw new Exception(FILE_NOT_FOUND_EXC, e);
		} catch (IOException e) {
			throw new IOException(IO_EXC, e);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(CLASS_NOT_FOUND_EXC, e);
		} catch (SQLException e) {
			throw new SQLException(SQL_EXC, e);
		}
		return connection;
	}

	public static void disconnect() throws Exception {
		try {
			if (connection == null || connection.isClosed()) {
				return;
			} else {
				connection.close();
			}
		} catch (SQLException e) {
			throw new SQLException(SQL_EXC, e);
		}
	}
	
	public static Statement createStatement() throws Exception {
		connect();
		return connection.createStatement();
	}
	
	public static PreparedStatement prepareStatement(String sql) throws Exception {
		connect();
		return connection.prepareStatement(sql);
	}
}
