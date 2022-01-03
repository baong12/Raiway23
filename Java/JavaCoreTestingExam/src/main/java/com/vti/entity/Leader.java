package com.vti.entity;

public class Leader extends User {
	private int numberOfProject;

	/**
	 * @param id
	 * @param fullName
	 * @param email
	 * @param password
	 * @param numberOfProject
	 */
	public Leader(int id, String fullName, String email, String password, int numberOfProject) {
		super(id, fullName, email, password);
		this.numberOfProject = numberOfProject;
	}

	public int getNumberOfProject() {
		return numberOfProject;
	}

	public void setNumberOfProject(int numberOfProject) {
		this.numberOfProject = numberOfProject;
	}

	@Override
	public String toString() {
		return "Leader [numberOfProject=" + numberOfProject + ", " + super.toString() + "]";
	}
}
