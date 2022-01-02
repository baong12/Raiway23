package com.vti.entity;

import java.util.Date;

import com.vti.utils.DateUtils;

public class Account {
	public int id;
	public String email;
	public String username;
	public String fullName;
	public Department department;
	public Position position;
	public Date createDate;

	/**
	 * @param id
	 * @param email
	 * @param username
	 * @param fullName
	 * @param department
	 * @param position
	 * @param createDate
	 */
	public Account(int id, String email, String username, String fullName, Department department, Position position,
			Date createDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullName=" + fullName
				+ ", department=" + department + ", position=" + position + ", createDate="
				+ DateUtils.formatDate(createDate, "yyyy-MM-dd") + "]";
	}
}