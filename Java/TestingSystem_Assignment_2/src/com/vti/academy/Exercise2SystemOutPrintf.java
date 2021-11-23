package com.vti.academy;

import java.util.Date;
import java.util.Locale;

public class Exercise2SystemOutPrintf {
	public static void main(String[] args) {
		ExerciseCommon com = new ExerciseCommon();
		
//		System.out.println("\n-- Question 1:");
//		question1();
//		
//		System.out.println("\n-- Question 2:");
//		question2();
//		
//		System.out.println("\n-- Question 3:");
//		question3();
//		
//		System.out.println("\n-- Question 4:");
//		question4();
//		
//		System.out.println("\n-- Question 5:");
		question5();
//		
//		System.out.println("\n-- Question 6:");
		
		Account[] accounts = { com.acc1, com.acc2, com.acc3, com.acc4, com.acc5 };
		question6(accounts);
	}
	
//	Question 1:
//	Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
//	nguyên đó
	public static void question1() {
		int num = 5;
		System.out.printf("%d %n", num);
	}
	
//	Question 2:
//	Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
//	ra số nguyên đó thành định dạng như sau: 100,000,000
	public static void question2() {
		int num = 100000000;
		System.out.printf(Locale.US, "%,d %n", num);
	}
	
//	Question 3:
//	Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
//	thực đó chỉ bao gồm 4 số đằng sau
	public static void question3() {
		float fl = 5.567098f;
		System.out.printf("%.4f %n", fl);
	}
	
//	Question 4:
//	Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
//	dạng như sau:
//	Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//		Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
	public static void question4() {
		String name = "Nguyễn Văn A";
		System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân. %n", name);
	}
	
//	Question 5:
//	Lấy thời gian bây giờ và in ra theo định dạng sau:
//	24/04/2020 11h:16p:20s
	public static void question5() {
		Date now = new Date();
		System.out.printf("%td/%tm/%tY", now, now, now);
		System.out.printf(" %tHh:%tMm:%tSs %n", now, now, now);
	}
	
//	Question 6:
//	In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
//	table (giống trong Database)	
	
	public static void question6(Account[] accArray) {
		System.out.printf("+--------------------------------+----------------------+----------------------+%n");
		System.out.printf("| %-30s | %-20s | %-20s |%n", "Email", "FullName", "Department");
		System.out.printf("+--------------------------------+----------------------+----------------------+%n");
		for (Account acc : accArray) {
			System.out.printf("| %-30s | %-20s | %-20s |%n", acc.email, acc.fullName, acc.department.name);
		}
		System.out.printf("+--------------------------------+----------------------+----------------------+%n");
	}
}
