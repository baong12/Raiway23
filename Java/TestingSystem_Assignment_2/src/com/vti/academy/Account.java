package com.vti.academy;

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
}