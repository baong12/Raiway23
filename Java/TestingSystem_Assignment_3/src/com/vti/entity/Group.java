package com.vti.entity;

import java.util.Date;

public class Group {
	private int id;
	private String name;
	private Account creator;
	private Date createDate;
	private Account[] members;
			
	public Group() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the creator
	 */
	public Account getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(Account creator) {
		this.creator = creator;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the members
	 */
	public Account[] getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(Account[] members) {
		this.members = members;
	}

}