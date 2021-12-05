package com.vti.entity;

public class Admin extends User {
	private String proSkill;

	/**
	 * @param id
	 * @param fullName
	 * @param userName
	 * @param email
	 * @param password
	 * @param proSkill
	 */
	public Admin(int id, String fullName, String userName, String email, String password, String proSkill) {
		super(id, fullName, userName, email, password);
		this.proSkill = proSkill;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
}
