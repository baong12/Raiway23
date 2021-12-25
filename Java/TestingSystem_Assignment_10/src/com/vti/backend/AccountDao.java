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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.vti.entity.Account;
import com.vti.utils.DateUtils;

public class AccountDao {
	private static final String mysqlDatePattern = "yyyy-MM-dd";
	private static final String IO_EXC = "Lỗi IO";
	private static final String FILE_NOT_FOUND_EXC = "Lỗi không tìm thấy file";
	private static final String SQL_EXC = "Lỗi kết nối SQL";
	private static final String CLASS_NOT_FOUND_EXC = "Lỗi đăng ký driver";
	private static Connection connection;

	public static void connectDb() {
		try {
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

	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		}
	}

	public static List<Account> getDepartments() throws SQLException, ParseException {
		List<Account> resultList = new ArrayList<Account>();
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM `account`";
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("account_id");
			String email = resultSet.getString("email");
			String username = resultSet.getString("user_name");
			String fullName = resultSet.getString("full_name");
			int depId = resultSet.getInt("department_id");
			int posId = resultSet.getInt("position_id");
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), mysqlDatePattern);
			resultList.add(new Account(id, email, username, fullName, depId, posId, createDate));
		}

		return resultList;
	}

	public static Account getAccountById(int id) throws SQLException, ParseException {
		Account result = null;
		String sql = "SELECT * FROM `acount` " + "WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			String email = resultSet.getString("email");
			String username = resultSet.getString("user_name");
			String fullName = resultSet.getString("full_name");
			int depId = resultSet.getInt("department_id");
			int posId = resultSet.getInt("position_id");
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), mysqlDatePattern);
			result = new Account(id, email, username, fullName, depId, posId, createDate);
		} else {
			System.out.println("Cannot find account which has id = " + id);
		}

		return result;
	}

	public static boolean isAccountUsernameExists(String name) throws SQLException {
		String query = "SELECT * FROM account WHERE user_name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	public static boolean isAccountIdExists(int id) throws SQLException {
		String query = "SELECT * FROM account WHERE account_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	public static void createAccount(String email, String username, String fullName, int depId, int posId,
			Date createDate) throws SQLException, Exception {
		if (isAccountUsernameExists(username)) {
			throw new Exception("Account username exists!");
		} else {
			String query = "INSERT INTO `account`(email, user_name, full_name, department_id, position_id, create_date)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			String createDateStr = DateUtils.formatDate(createDate, mysqlDatePattern);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(1, username);
			preparedStatement.setString(1, fullName);
			preparedStatement.setInt(1, depId);
			preparedStatement.setInt(1, posId);
			preparedStatement.setString(1, createDateStr);
			int affectedRecordCount = preparedStatement.executeUpdate();
			System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedRecordCount);
		}
	}
	
	public static void updateAccountUsername(int id, String newName) throws SQLException, Exception {
		if (!isAccountIdExists(id)) {
			throw new Exception("Account id not exists!");
		} else {
			String query = "UPDATE `account` SET user_name = ? WHERE account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, id);
			int affectedRecordCount = preparedStatement.executeUpdate();
			System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedRecordCount);
		}
	}
	
	public static void deleteAccount(int id) throws SQLException, Exception {
		if (!isAccountIdExists(id)) {
			throw new Exception("Account id not exists!");
		} else {
			String query = "DELETE FROM `account` WHERE account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int affectedRecordCount = preparedStatement.executeUpdate();
			System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedRecordCount);
		}
	}
}
