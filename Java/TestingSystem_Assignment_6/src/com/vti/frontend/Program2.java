package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exercise2_Exeption;
import com.vti.entity.ScannerUtils;

public class Program2 {
	public static void main(String[] args) {
		Exercise2_Exeption ex2 = new Exercise2_Exeption();
		Scanner scanner = new Scanner(System.in);
		ex2.question1();
		ex2.question2();
		ex2.question3();
		ex2.question4();
		ex2.question5();
		ex2.question6();
		ex2.question7();
		ex2.question8();
		ex2.question9();
		ex2.question10();
		scanner.close();
	}

}
