package com.vti.entity;

import java.util.Date;
import java.util.List;

import com.vti.utils.DateUtils;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullName;
	private Department department;
	private Position position;
	private Date createDate;
	private List<Group> groups;

	/**
	 * @param id
	 * @param username
	 */
	public Account(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	/**
	 * @param id
	 * @param email
	 * @param username
	 * @param fullName
	 * @param department
	 * @param position
	 * @param createDate
	 * @param groups
	 */
	public Account(int id, String email, String username, String fullName, Department department, Position position,
			Date createDate, List<Group> groups) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
		this.groups = groups;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return toString(false);
	}

	public String toString(boolean allParameters) {
		if (allParameters) {
			return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullName=" + fullName
					+ ", department=" + department + ", position=" + position.getName().getPositionName()
					+ ", createDate=" + DateUtils.formatDate(createDate, DateUtils.mysqlDatePattern) + ",\n  groups="
					+ groups + "]";
		} else {
			return "Account [id=" + id + ", fullName=" + fullName + "]";
		}
	}
}