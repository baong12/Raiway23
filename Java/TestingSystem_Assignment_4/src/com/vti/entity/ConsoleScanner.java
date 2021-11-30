package com.vti.entity;

import java.util.Scanner;

public class ConsoleScanner {
	private Scanner scanner = null;
	public static ConsoleScanner instance = new ConsoleScanner();
	
	private ConsoleScanner() {
		scanner = new Scanner(System.in);
	}
	
	public void close() {
		scanner.close();
	}
}
