package com.vti.entity.enums;

public enum Gender {
	MALE("nam"),
	FEMALE("nữ"),
	OTHER("khác");
	
	private String name;

	/**
	 * @param name
	 */
	private Gender(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}
