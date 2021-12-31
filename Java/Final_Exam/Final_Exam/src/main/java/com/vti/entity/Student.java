package com.vti.entity;

public class Student {
	private int id;
	private String fullName;
	private String phone;
	private String email;
	private String password;
	
	/**
	 * @param id
	 * @param fullName
	 * @param phone
	 * @param email
	 * @param password
	 */
	public Student(int id, String fullName, String phone, String email, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", phone=" + phone + ", email=" + email + ", password="
				+ password + "]";
	}
}
