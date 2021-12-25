package com.vti.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Demo1_GetData {
	public static void main(String[] args) {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/resource/database.properties"));
			
			String DB_URL = properties.getProperty("url");
			String USER_NAME = properties.getProperty("username");
			String PASSWORD = properties.getProperty("password");
			
			// Bước 1: Đăng ký driver Class với DriverManager
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Bước 2: Lấy 1 connection đến db
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Kết nối thành công");
			
			// Bước 3: Tạo một đối tượng Statement
			Statement statement = connection.createStatement();
			
			// Bước 4: Tạo truy vấn
			String query = "SELECT id, username, email FROM user";
			
			// Bước 5: Thực hiện truy vấn
			ResultSet resultSet = statement.executeQuery(query);
			
			// Bước 6: Xử lý Result set
			System.out.printf("+------------+----------------------+----------------------+%n");
			System.out.printf("| %-10s | %-20s | %-20s |%n", "id", "UserName", "Email");
			System.out.printf("+------------+----------------------+----------------------+%n");
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String email = resultSet.getString("email");
				System.out.printf("| %-10s | %-20s | %-20s |%n", id, username, email);
			}
			System.out.printf("+------------+----------------------+----------------------+%n");
			
			// Bước 7: Đóng kết nối
			connection.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi đăng ký driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối SQL");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Lỗi không tìm thấy file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Lỗi IO");
			e.printStackTrace();
		}
	}
}
