package com.vti.academy;

import java.time.LocalDate;
import java.util.Random;

public class Exercise4RandomNumber {
	public static void main(String[] args) {
		Random rand = new Random();
		ExerciseCommon com = new ExerciseCommon();
		String[] nameArr = { com.acc1.fullName, com.acc2.fullName, com.acc3.fullName, com.acc4.fullName,
				com.acc5.fullName };

		System.out.println("\n-- Question 1:");
		question1(rand);

		System.out.println("\n-- Question 2:");
		question2(rand);

		System.out.println("\n-- Question 3:");
		question3(rand, nameArr);

		System.out.println("\n-- Question 4:");
		question4(rand);

		System.out.println("\n-- Question 5:");
		question5(rand);

		System.out.println("\n-- Question 6:");
		question6(rand);

		System.out.println("\n-- Question 7:");
		question7(rand);
	}

//	Question 1:
//	In ngẫu nhiên ra 1 số nguyên
	public static void question1(Random rand) {
		int num = rand.nextInt();
		System.out.println(num);
	}

//	Question 2:
//	In ngẫu nhiên ra 1 số thực
	public static void question2(Random rand) {
		float num = rand.nextFloat();
		System.out.println(num);
	}

//	Question 3:
//	Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên
//	ra tên của 1 bạn
	public static void question3(Random rand, String[] nameArr) {
		int i = rand.nextInt(nameArr.length);
		System.out.println(nameArr[i]);
	}

//	Question 4:
//	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-
//	1995
	public static void question4(Random rand) {
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		int randInt = minDay + rand.nextInt(maxDay - minDay + 1);
		LocalDate randDay = LocalDate.ofEpochDay(randInt);
		System.out.println(randDay);
	}

//	Question 5:
//	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
	public static void question5(Random rand) {
		int minDay = (int) LocalDate.now().toEpochDay() - 365;
		int maxDay = (int) LocalDate.now().toEpochDay();
		int randInt = minDay + rand.nextInt(maxDay - minDay + 1);
		LocalDate randDay = LocalDate.ofEpochDay(randInt);
		System.out.println(randDay);
	}

//	Question 6:
//	Lấy ngẫu nhiên 1 ngày trong quá khứ
	public static void question6(Random rand) {
		int minDay = (int) LocalDate.EPOCH.toEpochDay();
		int maxDay = (int) LocalDate.now().toEpochDay();
		int randInt = minDay + rand.nextInt(maxDay - minDay);
		LocalDate randDay = LocalDate.ofEpochDay(randInt);
		System.out.println(randDay);
	}

//	Question 7:
//	Lấy ngẫu nhiên 1 số có 3 chữ số
	public static void question7(Random rand) {
		int min = 100;
		int max = 999;
		int randInt = min + rand.nextInt(max - min + 1);
		System.out.println("Số ngẫu nhiên có 3 chữ số: " + randInt);
	}
}
