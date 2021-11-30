package com.vti.entity;

import com.vti.entity.enums.Gender;

public class NhanVien extends CanBo {
	private String job;

	/**
	 * @param fullName
	 * @param age
	 * @param gender
	 * @param address
	 * @param job
	 */
	public NhanVien(String fullName, Byte age, Gender gender, String address, String job) {
		super(fullName, age, gender, address);
		this.job = job;
	}

	@Override
	public String toString() {
		return "NhanVien [job=" + job + ", " + super.toString() + "]";
	}
}
