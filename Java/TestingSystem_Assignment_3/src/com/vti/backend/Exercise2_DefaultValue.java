package com.vti.backend;

import java.util.Date;

import com.vti.entity.Account;

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
			accList[i].setEmail("Email " + (i + 1));
			accList[i].setUsername("User name " + (i + 1));
			accList[i].setFullName("Full name " + (i + 1));
			accList[i].setCreateDate(new Date());
		}
		
		for (Account acc : accList) {
			System.out.println(acc.getEmail());
			System.out.println(acc.getUsername());
			System.out.println(acc.getFullName());
			System.out.println(acc.getCreateDate());
		}
	}
}
