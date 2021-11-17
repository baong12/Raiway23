package com.vti.academy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Exercise3DateFormat {
	public static void main(String[] args) {
		ExerciseCommon com = new ExerciseCommon();
		
		System.out.println("\n-- Question 1:");
		Question1(com.ex1);

		System.out.println("\n-- Question 2:");
		Question2(com.ex1);

		System.out.println("\n-- Question 3:");
		Question3(com.ex1);

		System.out.println("\n-- Question 4:");
		Question4(com.ex1);

		System.out.println("\n-- Question 5:");
		Question5(com.ex1);
	}

//	Question 1:
//	In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
//	dạng vietnamese
	public static void Question1(Exam ex) {
		System.out.println("id: " + ex.id);
		System.out.println("code: " + ex.code);
		System.out.println("title: " + ex.title);
		System.out.println("category: " + ex.category.name);
		System.out.println("duration: " + ex.duration);
		System.out.println("creator: " + ex.creator.fullName);
		
		Locale locale = new Locale("vi", "VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(ex.createDate);
		System.out.println("createDate: " + date);
	}

//	Question 2:
//	In ra thông tin: Exam đã tạo ngày nào theo định dạng
//	Năm – tháng – ngày – giờ – phút – giây	
	public static void Question2(Exam ex) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(ex.createDate);
		System.out.println("createDate: " + date);
	}

//	Question 3:
//	Chỉ in ra năm của create date property trong Question 2
	public static void Question3(Exam ex) {
		String pattern = "yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(ex.createDate);
		System.out.println("createDate: " + date);
	}

//	Question 4:
//	Chỉ in ra tháng và năm của create date property trong Question 2
	public static void Question4(Exam ex) {
		String pattern = "MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(ex.createDate);
		System.out.println("createDate: " + date);
	}

//	Question 5:
//	Chỉ in ra "MM-DD" của create date trong Question 2
	public static void Question5(Exam ex) {
		String pattern = "MM-DD";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(ex.createDate);
		System.out.println("createDate: " + date);
	}
}
