package com.vti.entity;

import java.util.Scanner;

public class Department {
	private Scanner scanner;
	
	public byte id;
	public String name;

	public Department() {
		scanner = new Scanner(System.in);
		ScannerUtils scannerUtils = new ScannerUtils(scanner);
		System.out.println("Nhập id:");
		this.id = (byte) scannerUtils.inputInt("Trời ơi nhập lại đi, int mà:");
		System.out.println("Nhập tên phòng ban:");
		this.name = scannerUtils.inputString();
//		scanner.close();
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
