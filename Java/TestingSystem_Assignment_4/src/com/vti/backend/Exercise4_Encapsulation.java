package com.vti.backend;

import com.vti.entity.BankAccount;
import com.vti.entity.Circle;
import com.vti.entity.Date;
import com.vti.entity.Student;

public class Exercise4_Encapsulation {
//	Question 1:
//		Tạo Object Student có các property id, name, hometown, điểm học lực
//		a) Tất cả các property sẽ để là private để các class khác không
//		chỉnh sửa hay nhìn thấy
//		b) Tạo constructor cho phép khi khởi tạo mỗi student thì người
//		dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
//		c) Tạo 1 method cho phép set điểm vào
//		d) Tạo 1 method cho phép cộng thêm điểm
//		e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
//		điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm >
//		4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0
//		thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)
//		Demo các chức năng trên bằng class ở front-end.
	public void question1() {
		System.out.println("\n-- Question 1:");
		Student student = new Student("Nguyễn Văn A", "Hà Nội");
		System.out.println("Tạo sinh viên");
		student.getInfo(true);
		System.out.println("Nhập điểm = 5");
		student.setScore(5);
		student.getInfo(true);
		System.out.println("Cộng điểm = 4.5");
		student.addScore(4.5f);
		student.getInfo(true);
	}

	public void question2() {
		System.out.println("\n-- Question 2:");

		// Circle
		Circle cir1 = new Circle();
		System.out.println("Circle cir1 = new Circle();");
		System.out.println(cir1 + "\n");

		Circle cir2 = new Circle(10);
		System.out.println("Circle cir2 = new Circle(10);");
		System.out.println(cir2 + "\n");

		Circle cir3 = new Circle(15.5, "blue");
		System.out.println("Circle cir3 = new Circle(15.5, \"blue\");");
		System.out.println(cir3);
		cir3.setRadius(11);
		System.out.println("cir3.getRadius() = " + cir3.getRadius());
		cir3.setColor("yellow");
		System.out.println("cir3.getColor() = " + cir3.getColor());
		System.out.println("cir3.getArea() = " + cir3.getArea());
		System.out.println();

		// Account (BankAccount)
		BankAccount acc1 = new BankAccount("01001", "Nguyen Van A", 10000);
		BankAccount acc2 = new BankAccount("02022", "Nguyen Van B", 5000);

		System.out.println("acc1.getId() = " + acc1.getId());
		System.out.println("acc1.getName() = " + acc1.getName());
		System.out.println("acc1.getBalance() = " + acc1.getBalance());
		acc1.credit(10000);
		System.out.println("acc1.getBalance() = " + acc1.getBalance());
		acc1.debit(5000);
		System.out.println("acc1.getBalance() = " + acc1.getBalance());
		acc1.transferTo(acc2, 120000);
		System.out.println("acc1.getBalance() = " + acc1.getBalance());
		acc1.transferTo(acc2, 1200);
		System.out.println("acc1.getBalance() = " + acc1.getBalance());
		System.out.println("acc2.getBalance() = " + acc2.getBalance());
		System.out.println();
		
		// Date
		Date date = new Date(11, 12, 1996);
		System.out.println(date.toString());
		System.out.println(date.getDay());
		System.out.println(date.getMonth());
		System.out.println(date.getYear());
		date.setDay(1);
		date.setMonth(1);
		date.setYear(96);
		System.out.println(date.toString());
		System.out.println(date.isLeapYear());
		
		Date date2 = new Date(1, 1, 2000);
		System.out.println(date2.isLeapYear());
		
		Date date3 = new Date(1, 1, 1900);
		System.out.println(date3.isLeapYear());
	}
}
