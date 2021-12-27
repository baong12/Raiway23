package com.vti.entity;

import java.util.Date;
import java.util.List;

import com.vti.utils.DateUtils;

public class Group {
	private int id;
	private String name;
	private Account creator;
	private Date createDate;
	private List<Account> members;

	/**
	 * @param id
	 * @param name
	 */
	public Group(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @param id
	 * @param name
	 * @param creator
	 * @param createDate
	 * @param members
	 */
	public Group(int id, String name, Account creator, Date createDate, List<Account> members) {
		super();
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.createDate = createDate;
		this.members = members;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Account> getMembers() {
		return members;
	}

	public void setMembers(List<Account> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return toString(false);
	}

	public String toString(boolean allParameters) {
		if (allParameters) {
			return "Group [id=" + id + ", name=" + name + ", creator=" + creator + ", createDate="
					+ DateUtils.formatDate(createDate, DateUtils.mysqlDatePattern) + ",\n  members=" + members + "]";
		} else {
			return "Group [id=" + id + ", name=" + name + "]";
		}
	}
}