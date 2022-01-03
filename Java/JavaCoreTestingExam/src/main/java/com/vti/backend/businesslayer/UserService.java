package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

public class UserService implements IUserService {
	private IUserRepository userRepository = new UserRepository();
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private static final String VALID_PASSWORD_REGEX = ".*[A-Z].*";
	private static final Pattern VALID_FULL_NAME_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public List<User> getUserListByProjectId(int projectId) throws SQLException {
		return userRepository.getUserListByProjectId(projectId);
	}

	@Override
	public boolean isExistUserByEmailPassword(String email, String password) throws SQLException {
		if (isEmailValid(email) == false) {
			System.out.println("Email: không đúng định dạng email");
		} else if (password.length() < 6 || password.length() > 10) {
			System.out.println("Password: nhập từ 6 tới 10 ký tự");
		} else if (password.matches(VALID_PASSWORD_REGEX) == false) {
			System.out.println("Password: có ít nhất 1 ký tự viết hoa");
		} else {
			return userRepository.isExistUserByEmailPassword(email, password);
		}
		return false;
	}
	
	private boolean isEmailValid(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		return matcher.find();
	}

	@Override
	public int createUser(User user) throws SQLException {
		if (isEmailValid(user.getEmail()) == false) {
			System.out.println("Email: không đúng định dạng email");
		} else if (isFullNameValid(user.getFullName()) == false) {
			System.out.println("Fullname: chỉ chứa chữ, không chứa bất kỳ kí tự đặc biệt nào");
		} else {
			return userRepository.createUser(user);
		}
		return 0;
	}

	private boolean isFullNameValid(String fullName) {
		return fullName.matches("([\\p{L} ])+");
	}
}
