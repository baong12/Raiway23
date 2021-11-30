package com.vti.entity;

import com.vti.entity.enums.Gender;

public class CongNhan extends CanBo {
	private Integer level = 1;
	
	/**
	 * @param fullName
	 * @param age
	 * @param gender
	 * @param address
	 * @param level
	 */
	public CongNhan(String fullName, Byte age, Gender gender, String address, Integer level) {
		super(fullName, age, gender, address);
		this.level = level >= 1 && level <= 10 ? level : 1;
	}

	@Override
	public String toString() {
		return "CongNhan [level=" + level + ", " + super.toString() + "]";
	}
}
