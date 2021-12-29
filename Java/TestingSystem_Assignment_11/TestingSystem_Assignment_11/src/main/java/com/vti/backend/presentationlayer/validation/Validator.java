package com.vti.backend.presentationlayer.validation;

public class Validator implements IValidator {

	@Override
	public void validateEmail(String email) throws Exception {
		if (email == null) {
			throw new Exception("Email cannot be null");
		}
		if (email.contains("@") == false) {
			throw new Exception("Email must contain '@' sign");
		}
	}

}
