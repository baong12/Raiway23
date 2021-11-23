package com.vti.academy;

public class Exercise5_ObjectsMethod {
	private static ExerciseCommon com = new ExerciseCommon();
	private static Department[] departments = { com.dp1, com.dp2, com.dp3, com.dp4, com.dp5 };

	public static void main(String[] args) {
//		question1();
//		question2();
//		question3();
//		question4();
//		question5();
		question6();
		question7();
	}

//	Exercise 5: Object’s Method
//	Question 1:
//	In ra thông tin của phòng ban thứ 1 (sử dụng toString())
	public static void question1() {
		System.out.println("\n-- Question 1:");
		System.out.println("Thông tin phòng ban thứ 1:");
		System.out.println(com.dp1);
	}

//	Question 2:
//	In ra thông tin của tất cả phòng ban (sử dụng toString())
	public static void question2() {
		System.out.println("\n-- Question 2:");
		System.out.println("Thống tin tất cả phòng ban:");
		for (Department department : departments) {
			System.out.println(department);
		}
	}

//	Question 3:
//	In ra địa chỉ của phòng ban thứ 1
	public static void question3() {
		System.out.println("\n-- Question 3:");
		System.out.println("Địa chỉ phòng ban thứ 1: " + com.dp1.getAddress());
	}

//	Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
	public static void question4() {
		System.out.println("\n-- Question 4:");
		System.out.println("Kiểm tra xem phòng ban thứ 1 có tên là \"Phòng A\" không");
		System.out.println(com.dp1.isNameEqualTo("Phòng A"));
	}

//	Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
//	không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
	public static void question5() {
		System.out.println("\n-- Question 5:");
		System.out.println("So sánh 2 phòng ban thứ 1 và phòng ban thứ 2");
		System.out.println(com.dp1.equals(com.dp2) ? "Bằng nhau" : "Không bằng nhau");

		Department dep = new Department();
		dep.name = "Quản trị";
		System.out.println(com.dp1.equals(dep) ? "Bằng nhau" : "Không bằng nhau");
	}

//	Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
//	sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
//	VD:
//	Accounting
//	Boss of director
//	Marketing
//	Sale
//	Waiting room
	public static void question6() {
		System.out.println("\n-- Question 6:");
		Department[] depList = departments.clone();
		
		for (int i = 0; i < depList.length; i++) {
			for (int j = i + 1; j < depList.length; j++) {
				if (depList[j].compareToIgnoreCase(depList[i]) < 0) {
					Department temp = depList[i];
					depList[i] = depList[j];
					depList[j] = temp;
				}
			}
		}

		System.out.println("Kết quả sắp xếp thứ tự:");
		for (Department department : depList) {
			System.out.println(department);
		}
	}

//	Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh
//	sách phòng ban được sắp xếp theo tên
//	VD:
//	Accounting
//	Boss of director
//	Marketing
//	waiting room
//	Sale
	public static void question7() {
		System.out.println("\n-- Question 7:");
		Department[] depList = departments.clone();
		
		for (int i = 0; i < depList.length; i++) {
			for (int j = i + 1; j < depList.length; j++) {
				if (depList[j].compareLastWordToIgnoreCase(depList[i]) < 0) {
					Department temp = depList[i];
					depList[i] = depList[j];
					depList[j] = temp;
				}
			}
		}

		System.out.println("Kết quả sắp xếp thứ tự:");
		for (Department department : depList) {
			System.out.println(department);
		}
	}
}
