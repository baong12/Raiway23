package com.vti.academy;

public class Exercise6Method {
	private static ExerciseCommon com = new ExerciseCommon();
	private static Account[] accList = { com.acc1, com.acc2, com.acc3, com.acc4, com.acc5 };

	public static void main(String[] args) {
		System.out.println("\n-- Question 1:");
		Question1();

		System.out.println("\n-- Question 1:");
		Question2();

		System.out.println("\n-- Question 1:");
		Question3();
	}

//	Question 1:
//	Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
	public static void Question1() {
		System.out.println("In ra các số chẵn nguyên dương nhỏ hơn 10");
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

//	Question 2:
//	Tạo method để in thông tin các account
	public static void Question2() {
		for (Account acc : accList) {
			System.out.println("Thông tin account " + acc);
			System.out.println("id: " + acc.id);
			System.out.println("email: " + acc.email);
			System.out.println("username: " + acc.username);
			System.out.println("fullName: " + acc.fullName);
			System.out.println("department: " + acc.department.name);
			System.out.println("position: " + acc.position.name.getPositionName());
			System.out.println("createDate: " + acc.createDate);
			System.out.println();
		}
	}

//	Question 3:
//	Tạo method để in ra các số nguyên dương nhỏ hơn 10
	public static void Question3() {
		System.out.println("In ra các số nguyên dương nhỏ hơn 10");
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}
