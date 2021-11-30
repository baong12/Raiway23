package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Contact;
import com.vti.entity.VietnamesePhone;

public class Exercise6_Abstraction {
	private VietnamesePhone bphone = new VietnamesePhone();
//	Question 1: abstract class & abstract method
//		Tạo 1 class Phone để lưu thông tin liên lạc, trong Phone có chứa 1
//		property có kiểu dữ liệu là Array contacts, trong từng contact có lưu
//		thông tin number, name
//		a) Tạo các abstract method
//		a. void insertContact(String name, String phone)
//		b. void removeContact(String name)
//		c. void updateContact(String name, String newPhone)
//		d. void searchContact(String name)
//		b) Tạo class VietnamesePhone kế thừa Phone và triển khai các
//		method abstract
//		Viết chương trình demo
	public void question1() {
		System.out.println("\n-- Question 1:");
		Scanner scanner = new Scanner(System.in);
		boolean isContinued = true;

		while (isContinued) {
			System.out.println("Chọn chức năng");
			System.out.println("1. Insert contact");
			System.out.println("2. Remove contact");
			System.out.println("3. Update contact");
			System.out.println("4. Search contact");
			System.out.println("5. Get all contacts");
			int select = scanner.nextInt();
			scanner.nextLine();
			switch (select) {
			case 1:
				insertContactUI(scanner);
				break;
			case 2:
				removeContactUI(scanner);
				break;
			case 3:
				updateContactUI(scanner);
				break;
			case 4:
				searchContactUI(scanner);
				break;
			case 5:
				getAllContacts();
				break;
			default:
				System.out.println("Chỉ được nhập số tương ứng với chức năng");
				break;
			}
			
			System.out.println("Tiếp tục? 1. Có, 2. Không");
			select = scanner.nextInt();
			scanner.nextLine();
			isContinued = select == 1; 
		}
	}

	private void getAllContacts() {
		System.out.println(bphone.getAllContacts());
	}

	private void insertContactUI(Scanner scanner) {
		System.out.println("Nhập tên:");
		String name = scanner.nextLine();
		System.out.println("Nhập số điện thoại:");
		String number = scanner.nextLine();
		bphone.insertContact(name, number);
		
		System.out.println("Thêm thành công!");
		System.out.println(bphone.getLastInsertContact());
	}
	
	private void removeContactUI(Scanner scanner) {
		System.out.println("Nhập tên:");
		String name = scanner.nextLine();
		boolean result = bphone.removeContact(name);
		System.out.println(result ? "Xóa thành công!" : "Xóa thất bại");
	}

	private void updateContactUI(Scanner scanner) {
		System.out.println("Nhập tên:");
		String name = scanner.nextLine();
		System.out.println("Nhập số điện thoại:");
		String number = scanner.nextLine();
		boolean result = bphone.updateContact(name, number);
		System.out.println(result ? "Sửa thành công!" : "Sửa thất bại");
	}

	private void searchContactUI(Scanner scanner) {
		String result = null;
		System.out.println("Nhập tên:");
		String name = scanner.nextLine();
		result = bphone.searchContact(name);
		System.out.println(result);
	}
}
