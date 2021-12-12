package com.vti.entity;

public class PrimaryStudent extends Student {
	private static int numberOfCreated;
	
	public PrimaryStudent(int id, String name) {
		super(id, name);
		numberOfCreated++;
	}

	/**
	 * @return the numberOfCreated
	 */
	public static int getNumberOfCreated() {
		return numberOfCreated;
	}

}
