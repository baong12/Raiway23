package com.vti.entity;

public class Department {
	public byte id;
	public String name;

	public Department() {
	}
	
	public Department(String nameDepartMent) {
		this.id = 0;
		this.name = nameDepartMent;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
