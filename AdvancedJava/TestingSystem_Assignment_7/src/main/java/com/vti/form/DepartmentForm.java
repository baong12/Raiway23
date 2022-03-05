package com.vti.form;

import com.vti.entity.Department;

public class DepartmentForm {

	private String name;
	private Short totalMember;

	public DepartmentForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getTotalMember() {
		return totalMember;
	}

	public void setTotalMember(Short totalMember) {
		this.totalMember = totalMember;
	}

	public Department toEntity() {
		return new Department(name, totalMember);
	}
}
