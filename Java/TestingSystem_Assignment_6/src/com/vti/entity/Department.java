package com.vti.entity;

import java.util.Scanner;

public class Department {
	private Scanner scanner;
	
	public byte id;
	public String name;

	public Department(ScannerUtils scUtils) {
		System.out.println("Nhập id:");
		this.id = (byte) scUtils.inputInt("Trời ơi nhập lại đi, int mà:");
		System.out.println("Nhập tên phòng ban:");
		this.name = scUtils.inputString();
	}
	
	public void closeScanner() {
		scanner.close();
	}
	
	public Department(String name) {
		this.id = 0;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
