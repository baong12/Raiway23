package com.vti.entity;

public class Student {
	private static int id = 0;
	private String name;
	
	public Student(String name) {
		this.name = name;
		id++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @deprecated method đã cũ, sử dụng getMSV() để thay thế
	 */
	public int getId() {
		return id;
	}
	
	public String getMSV() {
		return "MSV: " + id;
	}
}
