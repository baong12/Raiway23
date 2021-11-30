package com.vti.entity;

import org.apache.commons.lang3.ArrayUtils;

public class VietnamesePhone extends Phone {
	private Contact lastInsertContact;

	/**
	 * @param lastInsertContact
	 */
	public VietnamesePhone() {
		super();
		this.lastInsertContact = null;
	}

	@Override
	public void insertContact(String name, String phone) {
		Contact contact = new Contact(phone, name);
		lastInsertContact = contact;
		contacts = ArrayUtils.add(contacts, contact);
	}

	@Override
	public boolean removeContact(String name) {
		boolean isSuccessful = false;
		int[] indexes = new int[] {};
		for (int i = 0; i < contacts.length; i++) {
			Contact contact = contacts[i];
			if (contact.getName().equals(name)) {
				indexes = ArrayUtils.add(indexes, i);
			}
		}
		
		if (indexes.length > 0) {
			isSuccessful = true;
			contacts = ArrayUtils.removeAll(contacts, indexes);
		}
		
		return isSuccessful;
	}

	@Override
	public boolean updateContact(String name, String newPhone) {
		boolean isSuccessful = false;
		for (int i = 0; i < contacts.length; i++) {
			Contact contact = contacts[i];
			if (contact.getName().equals(name)) {
				isSuccessful = true;
				contacts[i] = new Contact(newPhone, name);
			}
		}
		return isSuccessful;
	}

	@Override
	public String searchContact(String name) {
		String output = "Kết quả tìm kiếm:\n";
		int[] indexes = new int[] {};
		for (int i = 0; i < contacts.length; i++) {
			Contact contact = contacts[i];
			if (contact.getName().equals(name)) {
				indexes = ArrayUtils.add(indexes, i);
			}
		}
		if (indexes.length > 0) { 
			for (int i = 0; i < indexes.length; i++) {
				int index = indexes[i];
				output += contacts[index].toString() + "\n";
			}
		} else {
			output += "Không tìm thấy contact\n";
		}
		
		return output;
	}

	public String getAllContacts() {
		String result = "";
		if (contacts.length > 0) {
			result += "Danh sách contact:\n";
			for (Contact contact : contacts) {
				result += contact.toString() + "\n";
			}
		} else {
			result += "Không có contact\n";
		}
		return result;
	}

	public Contact getLastInsertContact() {
		return lastInsertContact;
	}
}
