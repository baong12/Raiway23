package com.vti.entity;

public class Department {
	private byte id;
	private String name;

	/**
	 * @return the id
	 */
	public byte getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(byte id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Department() {
	}

	@Override
	public String toString() {
		return "Department [id=" + getId() + ", name=" + getName() + "]";
	}

	public int getAddress() {
		return this.getId();
	}

	public boolean isNameEqualTo(String target) {
		return this.getName().equals(target);
	}

	@Override
	public boolean equals(Object obj) {
		// Department 1 (this) và Department 2 (obj)
		String objName = ((Department) obj).getName();
		return this.getName().equals(objName);
	}
	
	public int compareToIgnoreCase(Department target) {
		return getName().compareToIgnoreCase(target.getName());
	}
	
	public int compareLastWordToIgnoreCase(Department target) {
		String[] targetWords = target.getName().split(" ");
		String[] thisWords = getName().split(" ");
		String targetLastWord = targetWords[targetWords.length - 1];
		String thisLastWord = thisWords[thisWords.length - 1];
		
		return thisLastWord.compareToIgnoreCase(targetLastWord);
	}
}
