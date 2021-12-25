package com.vti.entity;

import java.util.Date;

public class Account {
	public int id;
	public String email;
	public String username;
	public String fullName;
	public int departmentId;
	public int positionId;
	public Date createDate;
	
	/**
	 * @param id
	 * @param email
	 * @param username
	 * @param fullName
	 * @param departmentId
	 * @param positionId
	 * @param createDate
	 */
	public Account(int id, String email, String username, String fullName, int departmentId, int positionId,
			Date createDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.departmentId = departmentId;
		this.positionId = positionId;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullName=" + fullName
				+ ", departmentId=" + departmentId + ", positionId=" + positionId + ", createDate=" + createDate + "]";
	}
}