package com.vti.frontend;

import com.vti.backend.presentationlayer.StudentController;
import com.vti.entity.Bachelor;
import com.vti.entity.Engineer;
import com.vti.entity.Student;
import com.vti.utils.JDBCUtils;
import com.vti.utils.ScannerUtils;

public class Program {
	private static StudentController studentController = new StudentController();
	public static void main(String[] args) {
		boolean isDone = false;
		while (!isDone) {
			System.out.println("\n---------- Quản lý sinh viên ------------");
			System.out.println("1. Đăng ký Kỹ sư");
			System.out.println("2. Đăng ký Cử nhân");
			System.out.println("3. Đăng nhập");
			System.out.println("Chọn chức năng để tiếp tục, 0 để thoát");
			
			switch (ScannerUtils.inputInt()) {
			case 1:
				registerEngineer();
				break;
			case 2:
				registerBachelor();
				break;
			case 3:
				loginSystem();
				break;
			case 0:
			default:
				isDone = true;
				break;
			} 
		}
		JDBCUtils.disconnect();
		ScannerUtils.closeScanner();
	}
	private static void registerEngineer() {
		System.out.println("Nhập họ và tên:");
		String fullName = ScannerUtils.inputString();
		System.out.println("Nhập số điện thoại:");
		String phone = ScannerUtils.inputString();
		System.out.println("Nhập email:");
		String email = ScannerUtils.inputString();
		System.out.println("Nhập password:");
		String password = ScannerUtils.inputString();
		System.out.println("Nhập số đồ án tốt nghiệp:");
		int numberThesis = ScannerUtils.inputInt();
		int affectedCount = studentController.createEngineer(new Engineer(0, fullName, phone, email, password, numberThesis));
		System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedCount);
		if (affectedCount == 0) {
			System.out.println("Đăng ký thất bại");
		} else {
			System.out.println("Đăng ký thành công");
		}
	}
	private static void registerBachelor() {
		System.out.println("Nhập họ và tên:");
		String fullName = ScannerUtils.inputString();
		System.out.println("Nhập số điện thoại:");
		String phone = ScannerUtils.inputString();
		System.out.println("Nhập email:");
		String email = ScannerUtils.inputString();
		System.out.println("Nhập password:");
		String password = ScannerUtils.inputString();
		System.out.println("Nhập loại khóa luận tốt nghiệp:");
		String typeThesis = ScannerUtils.inputString();
		int affectedCount = studentController.createBachelor(new Bachelor(0, fullName, phone, email, password, typeThesis));
		System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedCount);
		if (affectedCount == 0) {
			System.out.println("Đăng ký thất bại");
		} else {
			System.out.println("Đăng ký thành công");
		}
	}
	private static void loginSystem() {
		System.out.println("Nhập email:");
		String email = ScannerUtils.inputString();
		System.out.println("Nhập password:");
		String password = ScannerUtils.inputString();
		boolean isOk = studentController.login(new Student(0, "", "", email, password));
		System.out.println("Đăng nhập " + (isOk ? "thành công" : "thất bại"));
	}
}
