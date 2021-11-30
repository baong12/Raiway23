package com.vti.entity;

public class Contact {
	private String number;
	private String name;
	
	/**
	 * @param number
	 * @param name
	 */
	public Contact(String number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Contact [number=" + number + ", name=" + name + "]";
	}
}
