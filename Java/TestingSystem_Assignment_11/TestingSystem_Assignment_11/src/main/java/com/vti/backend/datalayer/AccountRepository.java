package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.backend.datalayer.interfaces.IAccountRepository;
import com.vti.backend.datalayer.interfaces.IDepartmentRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.enums.PositionName;
import com.vti.utils.DateUtils;
import com.vti.utils.JdbcUtils;

public class AccountRepository implements IAccountRepository {
	private IDepartmentRepository departmentRepository = new DepartmentRepository();

	public List<Account> getListAccounts() throws SQLException, ParseException {
		List<Account> resultList = new ArrayList<Account>();
		Statement statement = JdbcUtils.createStatement();
		String sql = "SELECT * FROM `account`;";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			int id = resultSet.getInt("account_id");
			String email = resultSet.getString("email");
			String username = resultSet.getString("user_name");
			String fullName = resultSet.getString("full_name");
			int depId = resultSet.getInt("department_id");
			Department dep = departmentRepository.getDepartmentById(depId);
			int posId = resultSet.getInt("position_id");
			Position pos = new Position(posId, PositionName.values()[posId - 1]);
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), DateUtils.mysqlDatePattern);
			List<Group> groups = getGroupListByAccountId(id);
			resultList.add(new Account(id, email, username, fullName, dep, pos, createDate, groups));
		}
		return resultList;
	}

	public List<Group> getGroupListByAccountId(int id) throws SQLException {
		List<Group> result = new ArrayList<Group>();
		String sql = "SELECT g.* FROM group_account ga " + "LEFT JOIN `group` g ON ga.group_id = g.group_id "
				+ "WHERE ga.account_id = ?;";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int groupId = resultSet.getInt("group_id");
			String name = resultSet.getString("group_name");
			result.add(new Group(groupId, name));
		}
		return result;
	}

	@Override
	public int createAccount(Account account) throws SQLException {
		String sql = "INSERT INTO `account`(email, user_name, full_name, department_id, position_id, create_date) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setString(1, account.getEmail());
		preparedStatement.setString(2, account.getUsername());
		preparedStatement.setString(3, account.getFullName());
		preparedStatement.setInt(4, account.getDepartment().getId());
		preparedStatement.setInt(5, account.getPosition().getId());
		preparedStatement.setString(6, DateUtils.formatDate(new Date(), DateUtils.mysqlDatePattern));
		int affectedCount = preparedStatement.executeUpdate();
		return affectedCount;
	}

	@Override
	public Account getAccountById(int id) throws SQLException, ParseException {
		String sql = "SELECT * FROM `account` WHERE account_id = ?;";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String email = resultSet.getString("email");
			String username = resultSet.getString("user_name");
			String fullName = resultSet.getString("full_name");
			int depId = resultSet.getInt("department_id");
			Department dep = departmentRepository.getDepartmentById(depId);
			int posId = resultSet.getInt("position_id");
			Position pos = new Position(posId, PositionName.values()[posId - 1]);
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), DateUtils.mysqlDatePattern);
			List<Group> groups = getGroupListByAccountId(id);
			return new Account(id, email, username, fullName, dep, pos, createDate, groups);
		}
		return null;
	}

	@Override
	public boolean isAccountExists(int id) throws SQLException {
		String sql = "SELECT * FROM `account` WHERE account_id = ?;";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	@Override
	public int updateAccountById(int id, Account account) throws Exception {
		if (isAccountExists(id) == false) {
			throw new Exception("Cannot find account with id = " + id);
		}
		String sql = "UPDATE `account` SET email = ?, user_name = ?, full_name = ?, department_id = ?, "
				+ "position_id = ?, create_date = ? WHERE account_id = ?";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setString(1, account.getEmail());
		preparedStatement.setString(2, account.getUsername());
		preparedStatement.setString(3, account.getFullName());
		preparedStatement.setInt(4, account.getDepartment().getId());
		preparedStatement.setInt(5, account.getPosition().getId());
		preparedStatement.setString(6, DateUtils.formatDate(new Date(), DateUtils.mysqlDatePattern));
		preparedStatement.setInt(7, id);
		int affectedCount = preparedStatement.executeUpdate();
		return affectedCount;
	}

	@Override
	public int deleteAccountById(int id) throws Exception {
		if (isAccountExists(id) == false) {
			throw new Exception("Cannot find account with id = " + id);
		}
		String sql = "DELETE FROM `account` WHERE account_id = ?;";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int affectedCount = preparedStatement.executeUpdate();
		return affectedCount;
	}
}
