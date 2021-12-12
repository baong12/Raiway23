package com.vti.entity;

public class SecondaryStudent extends Student {
	private static int numberOfCreated;
	
	public SecondaryStudent(int id, String name) {
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
