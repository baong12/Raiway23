package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner;

	public static void initScanner() {
		scanner = new Scanner(System.in);
	}
	
	public static int inputInt(String errorMessage) {
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

	public static float inputFloat(String errorMessage) {
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

	public static double inputDouble(String errorMessage) {
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
	
	public static String inputString() {
		return scanner.nextLine();
	}
	
	public static void closeScanner() {
		scanner.close();
	}
}
