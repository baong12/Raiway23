package com.vti.entity;

public abstract class Phone {
	protected Contact[] contacts;
	
	/**
	 * @param contacts
	 */
	public Phone() {
		super();
		this.contacts = new Contact[] {};
	}

	public abstract void insertContact(String name, String phone);
	
	public abstract boolean removeContact(String name);
	
	public abstract boolean updateContact(String name, String newPhone);
	
	public abstract String searchContact(String name);
}
