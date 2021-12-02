package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exercise1;

public class Program1 {
	public static void main(String[] args) {
		Exercise1 ex1 = new Exercise1();
		Scanner scanner = new Scanner(System.in);
		
		ex1.myNews(scanner);
		
		scanner.close();
	}
}
