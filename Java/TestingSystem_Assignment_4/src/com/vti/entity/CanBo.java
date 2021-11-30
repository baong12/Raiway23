package com.vti.entity;

import com.vti.entity.enums.Gender;

public class CanBo {
	private String fullName;
	private Byte age;
	private Gender gender = Gender.OTHER;
	private String address;

	/**
	 * @param fullName họ tên
	 * @param age tuổi
	 * @param gender giới tính
	 * @param address địa chỉ
	 */
	public CanBo(String fullName, Byte age, Gender gender, String address) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	@Override
	public String toString() {
		return "CanBo [fullName=" + fullName + ", age=" + age + ", gender=" + gender.getName() + ", address=" + address
				+ "]";
	}
	
	public String getFullName() {
		return fullName;
	}
}
