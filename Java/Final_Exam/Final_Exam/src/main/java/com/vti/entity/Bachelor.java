package com.vti.entity;

public class Bachelor extends Student {
	private String typeOfGraduationThesis;

	/**
	 * @param id
	 * @param fullName
	 * @param phone
	 * @param email
	 * @param password
	 * @param typeOfGraduationThesis
	 */
	public Bachelor(int id, String fullName, String phone, String email, String password,
			String typeOfGraduationThesis) {
		super(id, fullName, phone, email, password);
		this.typeOfGraduationThesis = typeOfGraduationThesis;
	}

	public String getTypeOfGraduationThesis() {
		return typeOfGraduationThesis;
	}

	public void setTypeOfGraduationThesis(String typeOfGraduationThesis) {
		this.typeOfGraduationThesis = typeOfGraduationThesis;
	}

	@Override
	public String toString() {
		return "Bachelor [typeOfGraduationThesis=" + typeOfGraduationThesis + ", " + super.toString() + "]";
	}
}
