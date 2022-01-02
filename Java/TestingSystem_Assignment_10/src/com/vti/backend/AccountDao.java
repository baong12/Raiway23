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
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.DateUtils;
import com.vti.utils.JdbcUtils;

public class AccountDao {
	private static final String mysqlDatePattern = "yyyy-MM-dd";
	private static final String IO_EXC = "Lỗi IO";
	private static final String FILE_NOT_FOUND_EXC = "Lỗi không tìm thấy file";
	private static final String SQL_EXC = "Lỗi kết nối SQL";
	private static final String CLASS_NOT_FOUND_EXC = "Lỗi đăng ký driver";
	private static Connection connection;

	public static void connectDb() {
		connection = JdbcUtils.connect();
	}

	public static void closeConnection() {
		JdbcUtils.disconnect();
	}

	public static List<Account> getAccounts() throws SQLException, ParseException {
		List<Account> resultList = new ArrayList<Account>();
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM `account`";
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("account_id");
			String email = resultSet.getString("email");
			String username = resultSet.getString("user_name");
			String fullName = resultSet.getString("full_name");
			Department dep = DepartmentDao.getDepartmentById(resultSet.getInt("department_id"));
			Position pos = PositionDao.getPositionById(resultSet.getInt("position_id"));
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), mysqlDatePattern);
			resultList.add(new Account(id, email, username, fullName, dep, pos, createDate));
		}

		return resultList;
	}

	public static Account getAccountById(int id) throws SQLException, ParseException {
		Account result = null;
		String sql = "SELECT * FROM `account` " + "WHERE account_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			String email = resultSet.getString("email");
			String username = resultSet.getString("user_name");
			String fullName = resultSet.getString("full_name");
			Department dep = DepartmentDao.getDepartmentById(resultSet.getInt("department_id"));
			Position pos = PositionDao.getPositionById(resultSet.getInt("position_id"));
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), mysqlDatePattern);
			result = new Account(id, email, username, fullName, dep, pos, createDate);
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

	public static void createAccount(Account account) throws SQLException, Exception {
		if (isAccountUsernameExists(account.username)) {
			throw new Exception("Account username exists!");
		} else {
			String query = "INSERT INTO `account`(email, user_name, full_name, department_id, position_id, create_date)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, account.email);
			preparedStatement.setString(2, account.username);
			preparedStatement.setString(3, account.fullName);
			preparedStatement.setInt(4, account.department.id);
			preparedStatement.setInt(5, account.position.id);
			String createDateStr = DateUtils.formatDate(account.createDate, mysqlDatePattern);
			preparedStatement.setString(6, createDateStr);
			int affectedRecordCount = preparedStatement.executeUpdate();
			System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedRecordCount);
		}
	}

	public static void updateAccountUsername(int id, Account account) throws SQLException, Exception {
		if (!isAccountIdExists(id)) {
			throw new Exception("Account id not exists!");
		} else {
			String query = "UPDATE `account` SET email = ?, user_name = ?, full_name = ?, department_id = ?, "
					+ "position_id = ?, create_date = ? WHERE account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, account.email);
			preparedStatement.setString(2, account.username);
			preparedStatement.setString(3, account.fullName);
			preparedStatement.setInt(4, account.department.id);
			preparedStatement.setInt(5, account.position.id);
			String createDateStr = DateUtils.formatDate(account.createDate, mysqlDatePattern);
			preparedStatement.setString(6, createDateStr);
			preparedStatement.setInt(7, account.id);
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
