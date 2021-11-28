package com.vti.backend;

import java.util.Random;
import java.util.Scanner;

public class Exercise1_DatatypeCasting {
	private static Random rand = new Random();

//	Question 1:
//	Khai báo 2 số lương có kiểu dữ liệu là float.
//	Khởi tạo Lương của Account 1 là 5240.5 $
//	Khởi tạo Lương của Account 2 là 10970.055$
//	Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//	Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
	public void question1() {
		System.out.println("\n-- Question 1:");
		float salary1 = 5240.5f;
		float salary2 = 10970.055f;
//		int salaryRounded1 = (int) salary1;
//		int salaryRounded2 = (int) salary2;
		int salaryRounded1 = roundFloat(salary1);
		int salaryRounded2 = roundFloat(salary2);

		System.out.println("Lương của Account 1: " + salaryRounded1);
		System.out.println("Lương của Account 2: " + salaryRounded2);
	}

	private static int roundFloat(float f) {
		int result = 0;
		int raw = (int) f;
		float middle = (float) raw + 0.5f;
		result = f >= middle ? raw + 1 : raw;

		return result;
	}

//	Question 2:
//	Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
//	có số 0 ở đầu cho đủ 5 chữ số)
	public static void question2() {
		System.out.println("\n-- Question 2:");
		long num = rand.nextInt(99999 + 1);
		System.out.printf("Số ngẫu nhiên có 5 chữ số: %05d %n", num);
	}

//	Question 3:
//	Lấy 2 số cuối của số ở Question 2 và in ra.
//	Gợi ý:
//	Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
//	Cách 2: chia lấy dư số đó cho 100
	public static void question3() {
		System.out.println("\n-- Question 3:");
		int num = rand.nextInt(99999 + 1);
		System.out.printf("Số ngẫu nhiên có 5 chữ số: %05d %n", num);
		System.out.println("Lấy ra 2 chữ số cuối.");

		// Cách 1:
		String numString = String.valueOf(num);
		System.out.println("Cách 1: " + numString.substring(3));

		// Cách 2:
		int numLast2 = num % 100;
		System.out.println("Cách 2: " + numLast2);
	}

//	Question 4:
//	Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
	public static void question4() {
		System.out.println("\n-- Question 4:");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập vào số nguyên a: ");
		int a = scanner.nextInt();
		System.out.println("Nhập vào số nguyên b: ");
		int b = scanner.nextInt();

		float result = (float) a / (float) b;
		System.out.println("a / b = " + result);

		scanner.close();
	}

}
