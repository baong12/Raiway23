package com.vti.frontend;

import com.vti.backend.Exercise1_Basic;
import com.vti.utils.ScannerUtils;

public class Program1 {
	public static void main(String[] args) {
		Exercise1_Basic.question1(); // Open connection
		boolean isDone = false;
		while (!isDone) {
			System.out.println("\n---------------------------------"
					+ "\nChọn question, 0 để thoát:");
			int select = ScannerUtils.inputInt();
			switch (select) {
			case 0:
				isDone = true;
				break;
			case 1:
				Exercise1_Basic.question1();
				break;
			case 2:
				Exercise1_Basic.question2();
				break;
			case 3:
				Exercise1_Basic.question3();
				break;
			case 4:
				Exercise1_Basic.question4();
				break;
			case 5:
				Exercise1_Basic.question5();
				break;
			default:
				break;
			}
		}
		Exercise1_Basic.closeConnection();
		ScannerUtils.closeScanner();
	}
}
