package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

public class UserController {
	private IUserService userService = new UserService();
	
	public List<User> getUserListByProjectId(int projectId) {
		try {
			return userService.getUserListByProjectId(projectId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean loginUser(String email, String password) {
		try {
			return userService.isExistUserByEmailPassword(email, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public int createUser(String fullName, String email) {
		try {
			return userService.createUser(new User(0, fullName, email, "12345678"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}
}
