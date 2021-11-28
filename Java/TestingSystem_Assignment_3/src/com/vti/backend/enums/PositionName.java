package com.vti.backend.enums;

public enum PositionName {
	DEV("Dev"), 
	TEST("Test"),
	SCRUM_MASTER("Scrum Master"),
	PM("PM");

	private String positionName;

	PositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionName() {
		return positionName;
	}
}
