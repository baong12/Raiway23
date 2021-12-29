package com.vti.entity.enums;

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
	
	public PositionName getKey(String positionName) {
		if (positionName.equals(this.positionName)) {
			return this;
		}
		return null;
	}
}
