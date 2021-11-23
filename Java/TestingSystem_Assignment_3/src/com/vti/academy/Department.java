package com.vti.academy;

public class Department {
	public byte id;
	public String name;

	public Department() {
	}

	@Override
	public String toString() {
		return "id=" + String.valueOf(id) + ", name=" + name;
	}

	public int getAddress() {
		return this.id;
	}

	public boolean isNameEqualTo(String target) {
		return name.equals(target);
	}

	@Override
	public boolean equals(Object obj) {
		String objName = ((Department) obj).name; 
		return name.equals(objName);
	}
	
	public int compareToIgnoreCase(Department target) {
		return name.compareToIgnoreCase(target.name);
	}
	
	public int compareLastWordToIgnoreCase(Department target) {
		String[] targetWords = target.name.split(" ");
		String[] thisWords = name.split(" ");
		String targetLastWord = targetWords[targetWords.length - 1];
		String thisLastWord = thisWords[thisWords.length - 1];
		
		return thisLastWord.compareToIgnoreCase(targetLastWord);
	}
}
