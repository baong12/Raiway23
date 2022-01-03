package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Leader;
import com.vti.entity.Member;
import com.vti.entity.User;
import com.vti.utils.JDBCUtils;

public class UserRepository implements IUserRepository {

	@Override
	public List<User> getUserListByProjectId(int projectId) throws SQLException {
		List<User> users = new ArrayList<User>();

		String sql = "SELECT u.* FROM `user` u\r\n" + "LEFT JOIN project p ON p.id = u.project_id\r\n"
				+ "WHERE p.id = ?\r\n" + "UNION\r\n" + "SELECT u.* FROM `user` u\r\n"
				+ "LEFT JOIN project p ON p.leader_id = u.id\r\n" + "WHERE p.id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setInt(1, projectId);
		preparedStatement.setInt(2, projectId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int typeId = resultSet.getInt("type_id");
			User user = null;
			switch (typeId) {
			case 1:
				user = new Leader(resultSet.getInt("id"), resultSet.getString("full_name"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getInt("number_of_project"));
				break;
			case 2:
				user = new Member(resultSet.getInt("id"), resultSet.getString("full_name"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getInt("project_id"), resultSet.getString("skill"));
				break;
			default:
				break;
			}
			users.add(user);
		}

		return users;
	}

	@Override
	public boolean isExistUserByEmailPassword(String email, String password) throws SQLException {
		String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	@Override
	public int createUser(User user) throws SQLException {
		String sql = "INSERT INTO `user` (`full_name`, `email`, `password`) VALUES\r\n"
				+ "(?, ?, ?)";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setString(1, user.getFullName());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getPassword());
		return preparedStatement.executeUpdate();
	}
}
