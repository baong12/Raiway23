package com.vti.entity;

public class Member extends User {
	public int projectId;
	public String skill;
	
	/**
	 * @param id
	 * @param fullName
	 * @param email
	 * @param password
	 * @param projectId
	 * @param skill
	 */
	public Member(int id, String fullName, String email, String password, int projectId, String skill) {
		super(id, fullName, email, password);
		this.projectId = projectId;
		this.skill = skill;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Member [projectId=" + projectId + ", skill=" + skill + ", " + super.toString() + "]";
	}
}
