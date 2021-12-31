package com.vti.entity;

public class Engineer extends Student {
	private int numberOfGraduationProject;

	/**
	 * @param id
	 * @param fullName
	 * @param phone
	 * @param email
	 * @param password
	 * @param numberOfGraduationProject
	 */
	public Engineer(int id, String fullName, String phone, String email, String password,
			int numberOfGraduationProject) {
		super(id, fullName, phone, email, password);
		this.numberOfGraduationProject = numberOfGraduationProject;
	}

	public int getNumberOfGraduationProject() {
		return numberOfGraduationProject;
	}

	public void setNumberOfGraduationProject(int numberOfGraduationProject) {
		this.numberOfGraduationProject = numberOfGraduationProject;
	}

	@Override
	public String toString() {
		return "Engineer [numberOfGraduationProject=" + numberOfGraduationProject + ", " + super.toString()
				+ "]";
	}
}
