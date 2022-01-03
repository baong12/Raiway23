package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

public interface IUserService {
	public List<User> getUserListByProjectId(int projectId) throws SQLException;
	public boolean isExistUserByEmailPassword(String email, String password) throws SQLException;
	public int createUser(User user) throws SQLException;
}
