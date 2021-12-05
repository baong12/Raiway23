package com.vti.entity;

import java.util.Scanner;

public class ScannerUtils {
	private Scanner scanner;

	/**
	 * @param scanner
	 */
	public ScannerUtils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}
	
	public int inputInt(String errorMessage) {
		int output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Integer.valueOf(input);
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}
	
	public int inputInt() {
		return inputInt("Chuỗi vừa nhập không phải kiểu số nguyên, mời nhập lại:");
	}
	
	public String inputString() {
		return scanner.nextLine();
	}
}
