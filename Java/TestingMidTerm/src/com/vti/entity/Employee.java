package com.vti.entity;

public class Employee extends User {
	private int expInYear;

	/**
	 * @param id
	 * @param fullName
	 * @param userName
	 * @param email
	 * @param password
	 * @param expInYear
	 */
	public Employee(int id, String fullName, String userName, String email, String password, int expInYear) {
		super(id, fullName, userName, email, password);
		this.expInYear = expInYear;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}
}
