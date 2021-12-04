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

	public float inputFloat(String errorMessage) {
		float output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Float.valueOf(input);
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}

	public double inputDouble(String errorMessage) {
		double output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Double.valueOf(input);
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}
	
	public String inputString() {
		return scanner.nextLine();
	}
}
