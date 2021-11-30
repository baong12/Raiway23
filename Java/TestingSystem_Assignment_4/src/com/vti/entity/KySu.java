package com.vti.entity;

import com.vti.entity.enums.Gender;

public class KySu extends CanBo {
	private String specialty;

	/**
	 * @param fullName
	 * @param age
	 * @param gender
	 * @param address
	 * @param specialty
	 */
	public KySu(String fullName, Byte age, Gender gender, String address, String specialty) {
		super(fullName, age, gender, address);
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "KySu [specialty=" + specialty + ", " + super.toString() + "]";
	}
}
