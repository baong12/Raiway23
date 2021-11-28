package com.vti.entity;

import java.util.Date;

public class Question {
	private int id;
	private String content;
	private CategoryQuestion category;
	private TypeQuestion type;
	private Account creator;
	private Date createDate;

	public Question() {
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the category
	 */
	public CategoryQuestion getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryQuestion category) {
		this.category = category;
	}

	/**
	 * @return the type
	 */
	public TypeQuestion getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeQuestion type) {
		this.type = type;
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
}