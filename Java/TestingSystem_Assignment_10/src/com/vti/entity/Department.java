package com.vti.entity;

public class Department {
	public int id;
	public String name;

	/**
	 * @param id
	 * @param name
	 */
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
