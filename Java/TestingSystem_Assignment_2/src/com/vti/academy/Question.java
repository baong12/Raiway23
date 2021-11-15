package com.vti.academy;

import java.util.Date;

public class Question {
	public int id;
	public String content;
	public CategoryQuestion category;
	public TypeQuestion type;
	public Account creator;
	public Date createDate;

	public Question() {
	}
}