package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

public interface IUserRepository {
	public List<User> getUserListByProjectId(int projectId) throws SQLException;
	public boolean isExistUserByEmailPassword(String email, String password) throws SQLException;
	public int createUser(User user) throws SQLException;
}
