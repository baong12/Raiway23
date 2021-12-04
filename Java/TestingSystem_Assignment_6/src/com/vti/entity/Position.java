package com.vti.entity;

import java.util.Scanner;

import com.vti.entity.enums.PositionName;

public class Position {
	private Scanner scanner;
	
	public byte id;
	public PositionName name;

	public Position() {
		scanner = new Scanner(System.in);
		ScannerUtils scannerUtils = new ScannerUtils(scanner);
		System.out.println("Nhập id:");
		this.id = (byte) scannerUtils.inputInt("Có phải int đâu mà. Nhập lại đi bạn:");
		System.out.println("Nhập tên chức vụ, nhập số từ 1 đến 4:");
		System.out.println(" 1. Dev (mặc định)" + "\n 2. Test" + "\n 3. Scrum Master" + "\n 4. PM");
		int index = scannerUtils.inputInt("Có phải int đâu mà. Nhập lại đi bạn:");
		this.name = index >= 1 && index <= 4 ? PositionName.values()[index - 1] : PositionName.DEV;
		
//		scanner.close();
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name.getPositionName() + "]";
	}
}