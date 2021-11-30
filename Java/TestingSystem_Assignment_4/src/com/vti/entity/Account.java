package com.vti.entity;

import java.util.Arrays;
import java.util.Date;

public class Account {
	public int id;
	public String email;
	public String username;
	public String fullName;
	public Department department;
	public Position position;
	public Date createDate;
	public Group[] groups;

	public Account() {
	}

	public Account(int id, String email, String username, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstName + " " + lastName;
	}

	public Account(int id, String email, String username, String firstName, String lastName, Position position) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = new Date();
	}

	public Account(int id, String email, String username, String firstName, String lastName, Position position,
			Date createDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullName=" + fullName
				+ ", department=" + department + ", position=" + position + ", createDate=" + createDate + ", groups="
				+ Arrays.toString(groups) + "]";
	}
}