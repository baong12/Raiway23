package com.vti.academy;

import java.util.Date;

public class Exercise2_DefaultValue {
	public static void main(String[] args) {
		question1();
	}
	
//	Question 1:
//	Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
//	tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
//	 Email: "Email 1"
//	 Username: "User name 1"
//	 FullName: "Full name 1"
//	 CreateDate: now
	public static void question1() {
		Account[] accList = new Account[5];
		int length = accList.length;
		for (int i = 0; i < length; i++) {
			accList[i] = new Account();
			accList[i].email = "Email " + (i + 1);
			accList[i].username = "User name " + (i + 1);
			accList[i].fullName = "Full name " + (i + 1);
			accList[i].createDate = new Date();
		}
		
		for (Account acc : accList) {
			System.out.println(acc.email);
			System.out.println(acc.username);
			System.out.println(acc.fullName);
			System.out.println(acc.createDate);
		}
	}
}
