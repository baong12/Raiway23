package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner;
	private static final String NUMBER_FORMAT_EXCEPTION = "Nhập sai kiểu dữ liệu";

	public static void initScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
	}
	
	public static int inputInt() {
		initScanner();
		int output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Integer.valueOf(input);
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(NUMBER_FORMAT_EXCEPTION);
			}
		}
		return output;
	}

	public static float inputFloat() {
		initScanner();
		float output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Float.valueOf(input);
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(NUMBER_FORMAT_EXCEPTION);
			}
		}
		return output;
	}

	public static double inputDouble() {
		initScanner();
		double output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Double.valueOf(input);
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(NUMBER_FORMAT_EXCEPTION);
			}
		}
		return output;
	}
	
	public static String inputString() {
		initScanner();
		return scanner.nextLine();
	}
	
	public static void closeScanner() {
		if (scanner != null) {
			scanner.close();
		}
	}
}
