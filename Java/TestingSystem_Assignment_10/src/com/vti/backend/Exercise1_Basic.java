package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.vti.utils.ScannerUtils;

public class Exercise1_Basic {
	private static final String IO_EXC = "Lỗi IO";
	private static final String FILE_NOT_FOUND_EXC = "Lỗi không tìm thấy file";
	private static final String SQL_EXC = "Lỗi kết nối SQL";
	private static final String CLASS_NOT_FOUND_EXC = "Lỗi đăng ký driver";
	private static Connection connection;

//	Question 1: (Sử dụng Database Testing System đã xây dựng ở SQL)
//		Tạo connection tới database Testing System
//		In ra "Connect success!" khi kết nối thành công.
	public static void question1() {
		try {
			System.out.println("\n--- Question 1:");
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/resource/database.properties"));
			
			String DB_URL = properties.getProperty("url");
			String USER_NAME = properties.getProperty("username");
			String PASSWORD = properties.getProperty("password");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Connect success!");
		} catch (ClassNotFoundException e) {
			System.out.println(CLASS_NOT_FOUND_EXC);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println(FILE_NOT_FOUND_EXC);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(IO_EXC);
			e.printStackTrace();
		}
	}
	
//	Question 2:
//		Tạo method để in ra các thông tin của position gồm có id, name
	public static void question2() {
		System.out.println("\n--- Question 2:");
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT position_id, position_name FROM `position`";
			ResultSet resultSet = statement.executeQuery(query);
			
			System.out.printf("+------------+----------------------+%n");
			System.out.printf("| %-10s | %-20s |%n", "id", "name");
			System.out.printf("+------------+----------------------+%n");
			while (resultSet.next()) {
				int id = resultSet.getInt("position_id");
				String name = resultSet.getString("position_name");
				System.out.printf("| %-10s | %-20s |%n", id, name);
			}
			System.out.printf("+------------+----------------------+%n");
			
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		}
	}
	
//	Question 3:
//		Tạo method để tạo position, user sẽ nhập vào name.
	public static void question3() {
		System.out.println("\n--- Question 3:");
		try {
			String query = "INSERT INTO `position`(position_name) VALUES (?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			System.out.println("Nhập tên position muốn tạo:"
					+ "\n(chỉ được nhập 'Dev', 'Test', 'Scrum Master', 'PM')");
			String name = ScannerUtils.inputString();
			
			preparedStatement.setString(1, name);
			
			int affectedRecordCount = preparedStatement.executeUpdate();
			System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedRecordCount);
			
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		}
	}
	
//	Question 4:
//		Tạo method để update tên của position gồm có id = 5 thành "Dev".
	public static void question4() {
		System.out.println("\n--- Question 4:");
		try {
			String query = "UPDATE `position` SET position_name = ? WHERE position_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			String name = "Dev";
			int id = 5;
			
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			
			int affectedRecordCount = preparedStatement.executeUpdate();
			System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedRecordCount);
			
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		}
	}
	
//	Question 5:
//		Tạo method để delete của position theo id và user sẽ nhập vào id
	public static void question5() {
		System.out.println("\n--- Question 5:");
		
		try {
			String query = "DELETE FROM `position` WHERE position_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			System.out.println("Nhập vào id của position muốn xóa:");
			int id = ScannerUtils.inputInt();
			
			preparedStatement.setInt(1, id);
			
			int affectedRecordCount = preparedStatement.executeUpdate();
			System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedRecordCount);
			
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		}
	}
	
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		}
	}
}
