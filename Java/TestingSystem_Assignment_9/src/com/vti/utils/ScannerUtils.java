package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner;
	private static final String generalErrorMsg = "Đã có lỗi xảy ra";
	private static final String errorMessage = "Nhập sai kiểu dữ liệu";

	public static void initScanner() {
		scanner = new Scanner(System.in);
	}
	
	public static int inputInt(String errorMsg) {
		int output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Integer.valueOf(input);
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMsg);
			} catch (Exception e) {
				isOk = false;
				System.out.println(generalErrorMsg);
			}
		}
		return output;
	}
	
	public static int inputInt() {
		return inputInt(errorMessage);
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
			} catch (Exception e) {
				isOk = false;
				System.out.println(generalErrorMsg);
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
			} catch (Exception e) {
				isOk = false;
				System.out.println(generalErrorMsg);
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
