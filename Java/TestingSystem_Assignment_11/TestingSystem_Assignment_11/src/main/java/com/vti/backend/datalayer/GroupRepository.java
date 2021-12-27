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
import com.vti.backend.datalayer.interfaces.IGroupRepository;
import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.utils.DateUtils;
import com.vti.utils.JdbcUtils;

public class GroupRepository implements IGroupRepository {
	private IAccountRepository accountRepository = new AccountRepository();

	@Override
	public List<Group> getListGroups() throws SQLException, ParseException {
		List<Group> resultList = new ArrayList<Group>();
		Statement statement = JdbcUtils.createStatement();
		String sql = "SELECT * FROM `group`;";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			int id = resultSet.getInt("group_id");
			String name = resultSet.getString("group_name");
			Account creator = accountRepository.getAccountById(resultSet.getInt("creator_id"));
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), DateUtils.mysqlDatePattern);
			List<Account> members = getListAccountsByGroupId(id);
			resultList.add(new Group(id, name, creator, createDate, members));
		}
		return resultList;
	}

	@Override
	public List<Account> getListAccountsByGroupId(int id) throws SQLException {
		List<Account> result = new ArrayList<Account>();
		String sql = "SELECT a.* FROM group_account ga " + "LEFT JOIN `account` a ON ga.account_id = a.account_id "
				+ "WHERE ga.group_id = ?;";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
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
	public int createGroup(Group group) throws SQLException {
		String sql = "INSERT INTO `group`(group_name, creator_id, create_date) " + "VALUES (?, ?, ?);";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setString(1, group.getName());
		preparedStatement.setInt(2, group.getCreator().getId());
		preparedStatement.setString(3, DateUtils.formatDate(new Date(), DateUtils.mysqlDatePattern));
		int affectedCount = preparedStatement.executeUpdate();
		return affectedCount;
	}

	@Override
	public Group getGroupById(int id) throws SQLException, ParseException {
		String sql = "SELECT * FROM `group` WHERE group_id = ?;";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String name = resultSet.getString("group_name");
			Account creator = accountRepository.getAccountById(resultSet.getInt("creator_id"));
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), DateUtils.mysqlDatePattern);
			List<Account> members = getListAccountsByGroupId(id);
			return new Group(id, name, creator, createDate, members);
		}
		return null;
	}

	@Override
	public boolean isGroupExists(int id) throws SQLException {
		String sql = "SELECT * FROM `group` WHERE group_id = ?;";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	@Override
	public int updateGroupById(int id, Group group) throws SQLException, Exception {
		if (isGroupExists(id) == false) {
			throw new Exception("Cannot find group with ID = " + id);
		}
		String sql = "UPDATE `group` SET group_name = ?, creator_id = ?, create_date = ? WHERE group_id = ?";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setString(1, group.getName());
		preparedStatement.setInt(2, group.getCreator().getId());
		preparedStatement.setString(3, DateUtils.formatDate(new Date(), DateUtils.mysqlDatePattern));
		preparedStatement.setInt(4, id);
		int affectedCount = preparedStatement.executeUpdate();
		return affectedCount;
	}

	@Override
	public int deleteGroupById(int id) throws SQLException, Exception {
		String sql = "DELETE FROM `group` WHERE group_id = ?;";
		PreparedStatement preparedStatement = JdbcUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int affectedCount = preparedStatement.executeUpdate();
		return affectedCount;
	}

}
