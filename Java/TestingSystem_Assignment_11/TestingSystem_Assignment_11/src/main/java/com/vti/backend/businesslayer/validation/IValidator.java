package com.vti.backend.businesslayer.validation;

public interface IValidator {
	public void validateEmail(String email) throws Exception;
	public void validateUsername(String username) throws Exception;
}
