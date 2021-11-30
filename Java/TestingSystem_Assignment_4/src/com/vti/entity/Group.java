package com.vti.entity;

import java.util.Date;

public class Group {
	public int id;
	public String name;
	public Account creator;
	public Date createDate;
	public Account[] members;

	public Group() {
	}

	public Group(String groupName, Account creator, Account[] accounts, Date createDate) {
		super();
		this.name = groupName;
		this.creator = creator;
		this.createDate = createDate;
		this.members = accounts;
	}

	public Group(String groupName, Account creator, String[] usernames, Date createDate) {
		super();
		this.name = groupName;
		this.creator = creator;
		this.createDate = createDate;
		this.members = new Account[usernames.length];
		for (int i = 0; i < usernames.length; i++) {
			Account acc = new Account();
			acc.username = usernames[i];
			this.members[i] = acc;
		}
	}

	@Override
	public String toString() {
		String output = "";
		output += "Group [id=" + id + ", name=" + name + ", creator=" + creator + ", createDate=" + createDate + ",";
		output += "\nmembers=";
		if (members != null) {
			for (Account account : members) {
				output += "\n  " + account;
			}
		} else {
			output += "null";
		}
		output += "\n]";
		return output;
	}
}