package com.vti.entity;

import java.util.List;

public class Project {
	private int projectId;
	private int size;
	private int leaderId;
	private List<User> employees;

	/**
	 * @param projectId
	 * @param size
	 * @param leaderId
	 * @param employees
	 */
	public Project(int projectId, int size, int leaderId, List<User> employees) {
		super();
		this.projectId = projectId;
		this.size = size;
		this.leaderId = leaderId;
		this.employees = employees;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public List<User> getEmployees() {
		return employees;
	}

	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", size=" + size + ", leaderId=" + leaderId + ",\n   employees="
				+ employees + "]";
	}
}
