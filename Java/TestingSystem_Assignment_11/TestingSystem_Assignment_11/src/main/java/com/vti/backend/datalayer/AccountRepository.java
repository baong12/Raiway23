package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.backend.datalayer.interfaces.IAccountRepository;
import com.vti.backend.datalayer.interfaces.IDepartmentRepository;
import com.vti.backend.datalayer.interfaces.IPositionRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.utils.DateUtils;
import com.vti.utils.JDBCUtils;

public class AccountRepository implements IAccountRepository {
	private IDepartmentRepository departmentRepository = new DepartmentRepository();
	private IPositionRepository positionRepository = new PositionRepository();

	@Override
	public List<Account> getListAccounts() throws Exception {
		List<Account> resultList = new ArrayList<Account>();
		Statement statement = JDBCUtils.createStatement();
		String sql = "SELECT * FROM `account`;";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			int id = resultSet.getInt("account_id");
			String email = resultSet.getString("email");
			String username = resultSet.getString("user_name");
			String fullName = resultSet.getString("full_name");
			Department dep = departmentRepository.getDepartmentById(resultSet.getInt("department_id"));
			Position pos = positionRepository.getPositionById(resultSet.getInt("position_id"));
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), DateUtils.mysqlDatePattern);
			List<Group> groups = GroupRepository.getGroupListByAccountId(id);
			resultList.add(new Account(id, email, username, fullName, dep, pos, createDate, groups));
		}
		return resultList;
	}
	
	public static List<Account> getListAccountsByGroupId(int id) throws Exception {
		List<Account> result = new ArrayList<Account>();
		String sql = "SELECT a.* FROM group_account ga " + "LEFT JOIN `account` a ON ga.account_id = a.account_id "
				+ "WHERE ga.group_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int accountId = resultSet.getInt("account_id");
			String fullName = resultSet.getString("full_name");
			result.add(new Account(accountId, fullName));
		}
		return result;
	}

	@Override
	public int createAccount(Account account) throws Exception {
		String sql = "INSERT INTO `account`(email, user_name, full_name, department_id, position_id, create_date) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
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
	public Account getAccountById(int id) throws Exception {
		String sql = "SELECT * FROM `account` WHERE account_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String email = resultSet.getString("email");
			String username = resultSet.getString("user_name");
			String fullName = resultSet.getString("full_name");
			Department dep = departmentRepository.getDepartmentById(resultSet.getInt("department_id"));
			Position pos = positionRepository.getPositionById(resultSet.getInt("position_id"));
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), DateUtils.mysqlDatePattern);
			List<Group> groups = GroupRepository.getGroupListByAccountId(id);
			return new Account(id, email, username, fullName, dep, pos, createDate, groups);
		}
		return null;
	}

	@Override
	public boolean isAccountExists(int id) throws Exception {
		String sql = "SELECT * FROM `account` WHERE account_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	@Override
	public int updateAccountById(int id, Account account) throws Exception {
		if (isAccountExists(id) == false) {
			throw new Exception("Cannot find account with ID = " + id);
		}
		String sql = "UPDATE `account` SET email = ?, user_name = ?, full_name = ?, department_id = ?, "
				+ "position_id = ?, create_date = ? WHERE account_id = ?";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
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
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int affectedCount = preparedStatement.executeUpdate();
		return affectedCount;
	}
}
