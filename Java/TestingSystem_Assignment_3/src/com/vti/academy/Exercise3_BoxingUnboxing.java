package com.vti.academy;

public class Exercise3_BoxingUnboxing {
	public static void main(String[] args) {
		question1();
		question2();
		question3();
	}
	
//	Exercise 3(Optional): Boxing & Unboxing
//	Question 1:
//	Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//	Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
//	float có 2 số sau dấu thập phân)
	public static void question1() {
		System.out.println("-- Question 1:");
		int salary = 5000;
		float salaryFloat = (float) salary;
		System.out.printf("%.2f %n", salaryFloat);
	}
	
//	Question 2:
//	Khai báo 1 String có value = "1234567"
//	Hãy convert String đó ra số int
	public static void question2() {
		System.out.println("-- Question 2:");	
		String str = "1234567";
		int num = Integer.parseInt(str);
		System.out.printf("%d %n", num);
	}
	
//	Question 3:
//	Khởi tạo 1 số Integer có value là chữ "1234567"
//	Sau đó convert số trên thành datatype int
	public static void question3() {
		System.out.println("-- Question 3:");
		Integer integer = Integer.valueOf("1234567");
		int num = integer.intValue();
		System.out.println(integer.getClass());
		System.out.println(num);
	}
}
