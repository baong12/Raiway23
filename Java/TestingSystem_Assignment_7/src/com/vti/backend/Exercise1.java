package com.vti.backend;

import com.vti.entity.Configs;
import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhHoc;
import com.vti.entity.HinhTron;
import com.vti.entity.MyMath;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;
import com.vti.utils.ScannerUtils;

public class Exercise1 {
//	Question 1: static variable
//		Khai báo 1 class student có các thuộc tính id, name, college
//		Với college là static variable.
//		Hãy khởi tạo các student sau:
//		Student có id = 1, name ="Nguyễn Văn A"
//		Student có id = 2, name = " Nguyễn Văn B "
//		Student có id = 3, name = " Nguyễn Văn C "
//		Và tất cả các student này đều học ở "Đại học bách khoa".
//		Dùng vòng for để in ra thông tin các student
//		Sau đó hãy chuyển các student này sang "Đại học công nghệ"
//		Dùng vòng for để in ra thông tin các student
	public void question1() {
		System.out.println("\n--- Question 1 ---");
		Student.college = "Đại học bách khoa";
		Student[] students = new Student[3];
		students[0] = new Student(1, "Nguyễn Văn A");
		students[1] = new Student(2, "Nguyễn Văn B");
		students[2] = new Student(3, "Nguyễn Văn C");
		for (Student student : students) {
			System.out.println(student.toString());
		}

		Student.college = "Đại học công nghệ";
		for (Student student : students) {
			System.out.println(student.toString());
		}
		
	}
	
//	Question 2: tiếp tục question 1
//		Bổ sung thuộc tính moneyGroup cho Student (moneyGroup là tiền quỹ
//		lớp - dùng chung cho tất cả các student).
//		Hãy viết chương trình main() để mô tả các bước sau:
//		B1: Các Student sẽ nộp quỹ, mỗi Student 100k
//		B2: Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan
//		B3: Student thứ 2 lấy 20k đi mua bánh mì
//		B4: Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm
//		B5: cả nhóm mỗi người lại đóng quỹ mỗi người 50k
//		In ra số tiền còn của nhóm tại mỗi bước
	public void question2() {
		System.out.println("\n--- Question 2 ---");

		Student[] students = new Student[3];
		students[0] = new Student(1, "Nguyễn Văn A");
		students[1] = new Student(2, "Nguyễn Văn B");
		students[2] = new Student(3, "Nguyễn Văn C");
		
		System.out.println("Cả nhóm nộp quỹ");
		for (int i = 0; i < students.length; i++) {
			students[i].nopQuy(100000);
		}
		
		System.out.println(students[0].getName() + " đi mua bim bim, kẹo về liên hoan");
		students[0].xuatQuy(50000);
		System.out.println(students[1].getName() + " đi mua bánh mì");
		students[1].xuatQuy(20000);
		System.out.println(students[2].getName() + " đi mua đồ dùng học tập");
		students[2].xuatQuy(150000);
		System.out.println("Cả nhóm nộp quỹ");
		for (int i = 0; i < students.length; i++) {
			students[i].nopQuy(50000);
		}
	}
	
//	Question 3: static method
//		a) Viết class MyMath để thay thế cho class Math của java.
//		b) Viết thêm method min(), sum vào class MyMath
	public void question3() {
		System.out.println("\n--- Question 3 ---");
		System.out.println("Test method MyMath.max");
		int max = MyMath.max(3, 5);
		System.out.println(max);
		
		System.out.println("Test method MyMath.min");
		int min = MyMath.min(44, 23);
		System.out.println(min);
		
		System.out.println("Test method MyMath.sum");
		int sum = MyMath.sum(max, min);
		System.out.println(sum);
		
		int[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("Test method array");
		System.out.println(MyMath.max(intArray));
		System.out.println(MyMath.min(intArray));
		System.out.println(MyMath.sum(intArray));
	}
	
//	Question 4: tiếp tục Question 1
//		Trong class Student
//		a) Viết method cho phép thay đổi college
//		b) Viết method cho phép lấy giá trị của college
	public void question4() {
		System.out.println("\n--- Question 4 ---");
		Student.setCollege("Đại học Quốc gia Hà Nội");
		System.out.println(Student.getCollege());
	}
	
//	Question 5:
//		Hãy viết chương trình đếm số Student được sinh ra (tham khảo code
//		trên google)
	public void question5() {
		System.out.println("\n--- Question 5 ---");
		Student[] students = new Student[5];
		students[0] = new Student(1, "Nguyễn Văn A");
		students[1] = new Student(2, "Nguyễn Văn B");
		students[2] = new Student(3, "Nguyễn Văn C");
		students[3] = new Student(3, "Nguyễn Văn D");
		students[4] = new Student(3, "Nguyễn Văn E");
		System.out.println("Số lượng Student đã sinh ra: " + Student.getNumberOfCreated());
	}

//	Question 6: tiếp tục Question 5
//		Tạo class PrimaryStudent, SecondaryStudent, hãy viết chương trình
//		đếm số lượng PrimaryStudent được sinh ra, SecondaryStudent được
//		sinh ra.
//		Viết chương trình demo.
//		Khởi tạo 6 Student, trong đó có 2 PrimaryStudent và 4
//		SecondaryStudent, sau đó in ra số lượng Student,
//		PrimaryStudent, SecondaryStudent được sinh ra.
	public void question6() {
		System.out.println("\n--- Question 6 ---");
		Student student1 = new PrimaryStudent(1, "Nguyen Van A");
		Student student2 = new PrimaryStudent(2, "Nguyen Van B");
		Student student3 = new SecondaryStudent(3, "Nguyen Van C");
		Student student4 = new SecondaryStudent(4, "Nguyen Van D");
		Student student5 = new SecondaryStudent(5, "Nguyen Van E");
		Student student6 = new SecondaryStudent(6, "Nguyen Van F");
		System.out.println("Số lượng Student: " + Student.getNumberOfCreated());
		System.out.println("Số lượng PrimaryStudent: " + PrimaryStudent.getNumberOfCreated());
		System.out.println("Số lượng SecondaryStudent: " + SecondaryStudent.getNumberOfCreated());
	}

//	Question 7: tiếp tục Question 6
//		Chỉ cho phép user tạo được tối đa 7 học sinh
	public void question7() {
		question6();
		System.out.println("\n--- Question 7 ---");
		Student student7 = new PrimaryStudent(7, "Nguyen Van G");
		Student student8 = new PrimaryStudent(8, "Nguyen Van H");
		System.out.println("Số lượng Student: " + Student.getNumberOfCreated());
	}

//	Question 8:
//		Tạo class Configs có các static property
//		SO_LUONG_HINH_TOI_DA = 5;
//		Tạo class HinhHoc, và class HinhTron, HinhChuNhat sẽ kế thừa từ
//		class HinhHoc, implement method tính chu vi, diện tính
//		Viết chương trình chỉ cho phép khởi tạo được tối đa 5 hình, nếu người
//		dùng khởi tạo tới hình thứ 6 thì sẽ throw ra 1 custom Exception có tên
//		là HinhHocException có message là: "Số lượng hình tối đa là: " +
//		Configs. SO_LUONG_HINH_TOI_DA
	public void question8() throws Exception {
		System.out.println("\n--- Question 8 ---");
		HinhHoc[] hinhHocArr = new HinhHoc[10];
		hinhHocArr[0] = new HinhTron(5);
		hinhHocArr[1] = new HinhTron(10);
		hinhHocArr[2] = new HinhTron(15);
		hinhHocArr[3] = new HinhChuNhat(5, 10);
		hinhHocArr[4] = new HinhChuNhat(6, 11);
		hinhHocArr[5] = new HinhChuNhat(7, 12);
		if (HinhHoc.getSoLuongHinh() > Configs.SO_LUONG_HINH_TOI_DA) {
			throw new Exception("Số lượng hình tối đa là: " + Configs.SO_LUONG_HINH_TOI_DA);
		}
	}

//	Question 9:
//		Thay đổi các method ở class ScannerUtils ở Assignment 6 thành static
//		để tiện dùng hơn
	public void question9() {
		System.out.println("\n--- Question 9 ---");
		ScannerUtils.initScanner();
		System.out.println("Nhập int:");
		int numInt = ScannerUtils.inputInt("Dữ liệu không chính xác, mời nhập lại:");
		System.out.println("Số vừa nhập: " + numInt);
		ScannerUtils.closeScanner();
	}
}
