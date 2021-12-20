package com.vti.backend;

import java.util.Date;

import com.vti.entity.Student;

public class Exercise2_Annotation {
//	Question 1: @Deprecated
//		Khai báo 1 instance có datatype Date và có value là ngày 18/05/2020.
//		Bạn sẽ thấy java cảnh báo, hãy tắt cảnh báo này đi
	@SuppressWarnings("deprecation")
	public static void question1() {
		System.out.println("\n--- Question 1:");
		Date today = new Date(2020, 5, 18);
		System.out.println(today);
	}
	
//	Question 2: @Deprecated
//		Tạo 1 class student id, name với id là int và tự động tăng
//		B1: Sau đó tạo getter cho id
//		B2: Tại main() method, ta sẽ tạo instance của student có name
//		= "Nguyễn Văn A" và in ra tên của student.
//		B3: Sau đó hệ thống thay đổi method getter của id, bạn sẽ phải
//		tạo ra getter cho id như sau (viết thêm method sau vào)
//		Method sẽ return ra String là "MSV: " + id (nghĩa là
//		thêm chữ MSV vào trước id
//		B4: bạn sẽ đánh dấu method default getter (ở bước 1) là cũ và
//		tạo comment để những người sau sẽ sử dụng method mới (là
//		method ở bước 3)
//		B5: tại method main() viết thêm demo sử dụng method getter
//		mới này (không xóa code cũ đi)
	@SuppressWarnings("deprecation")
	public static void question2() {
		System.out.println("\n--- Question 2:");
		Student student1 = new Student("Nguyễn Văn A");
		System.out.println("In ra tên của student");
		System.out.println(student1.getName());
		System.out.println("Lấy id theo method cũ");
		System.out.println(student1.getId());
		System.out.println("Lấy id theo method mới");
		System.out.println(student1.getMSV());
	}
}
