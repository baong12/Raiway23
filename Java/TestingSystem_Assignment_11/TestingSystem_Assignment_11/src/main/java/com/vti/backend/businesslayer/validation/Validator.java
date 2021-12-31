package com.vti.backend.businesslayer.validation;

import com.mysql.cj.util.StringUtils;

public class Validator implements IValidator {

	@Override
	public void validateEmail(String email) throws Exception {
		if (StringUtils.isNullOrEmpty(email)) {
			throw new Exception("Email không được để trống");
		}
		if (email.contains("@") == false) {
			throw new Exception("Email phải chứa ký tự @");
		}
	}

	@Override
	public void validateUsername(String username) throws Exception {
		if (StringUtils.isNullOrEmpty(username)) {
			throw new Exception("Username không được để trống");
		}
		if (username.length() < 6) {
			throw new Exception("Username cần tối thiểu 6 ký tự");
		}
	}
}
