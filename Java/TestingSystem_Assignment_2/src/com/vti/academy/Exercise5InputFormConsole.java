package com.vti.academy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.vti.academy.enums.PositionName;

public class Exercise5InputFormConsole {
	private static ExerciseCommon com = new ExerciseCommon();
	private static Account[] accList = { com.acc1, com.acc2, com.acc3, com.acc4, com.acc5 };
	private static Group[] grList = { com.gr1, com.gr2, com.gr3, com.gr4 };
	private static Scanner scn;

	public static void main(String[] args) throws ParseException {
		scn = new Scanner(System.in);

		System.out.println("\n-- Question 1:");
//		question1();

		System.out.println("\n-- Question 2:");
//		question2();

		System.out.println("\n-- Question 3:");
//		question3();

		System.out.println("\n-- Question 4:");
//		question4();

		System.out.println("\n-- Question 5:");
//		question5();

		System.out.println("\n-- Question 6:");
//		question6();

		System.out.println("\n-- Question 7:");
//		question7();
//		question7Cach2();

		System.out.println("\n-- Question 8:");
//		question8();

		System.out.println("\n-- Question 9:");
		question9();

		System.out.println("\n-- Question 10:");
//		question10();

		System.out.println("\n-- Question 11:");
//		question11();

		scn.close();
	}

//	Question 1:
//	Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
	public static void question1() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập 1 số nguyên: ");
		int num1 = scn.nextInt();
		System.out.println("Nhập 1 số nguyên: ");
		int num2 = scn.nextInt();
		System.out.println("Nhập 1 số nguyên: ");
		int num3 = scn.nextInt();

		System.out.println("3 số nguyên bạn vừa nhập:");
		System.out.printf("%d, %d, %d %n", num1, num2, num3);
		scn.close();
	}

//	Question 2:
//	Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
	public static void question2() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập 1 số thực: ");
		float num1 = scn.nextFloat();
		System.out.println("Nhập 1 số thực: ");
		float num2 = scn.nextFloat();

		System.out.println("2 số thực bạn vừa nhập:");
		System.out.printf("%f, %f %n", num1, num2);
		scn.close();
	}

//	Question 3:
//	Viết lệnh cho phép người dùng nhập họ và tên
	public static void question3() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập họ và tên: ");
		String fullName = scn.nextLine();
		System.out.println("Họ và tên: " + fullName);
		scn.close();
	}

//	Question 4:
//	Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
	public static void question4() throws ParseException {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập ngày sinh nhật: (yyyy-MM-dd)");
		String dateInput = scn.next();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = dateFormat.parse(dateInput);

		System.out.println("Input: " + date);
		scn.close();
	}

//	Question 5:
//	Viết lệnh cho phép người dùng tạo account (viết thành method)
//	Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
//	chương trình sẽ chuyển thành Position.Dev, Position.Test,
//	Position.ScrumMaster, Position.PM
	public static void question5() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập thông tin account mới.");
		System.out.print("Email: ");
		String email = scn.nextLine();
		System.out.print("Username: ");
		String username = scn.nextLine();
		System.out.print("Họ và tên: ");
		String fullName = scn.nextLine();
		System.out.print("ID phòng ban: ");
		String depName = scn.nextLine();
		System.out.print("ID vị trí: ");
		int posId = scn.nextInt();

		Account acc = new Account();
		acc.email = email;
		acc.username = username;
		acc.fullName = fullName;

		Department dep = new Department();
		dep.id = 0;
		dep.name = depName;
		acc.department = dep;

		posId = posId >= 1 && posId <= 4 ? posId : 1;
		Position pos = new Position();
		pos.id = 0;
		pos.name = PositionName.values()[posId - 1];
		acc.position = pos;

		acc.createDate = new Date();

		System.out.println("Thông tin accout vừa tạo: " + acc);
		System.out.println("email: " + acc.email);
		System.out.println("username: " + acc.username);
		System.out.println("fullName: " + acc.fullName);
		System.out.println("department: " + acc.department.name);
		System.out.println("position: " + acc.position.name.getPositionName());
		System.out.println("createDate: " + acc.createDate);

		scn.close();
	}

//	Question 6:
//	Viết lệnh cho phép người dùng tạo department (viết thành method)
	public static void question6() {
		System.out.println("Tạo phòng ban mới.");
		System.out.print("Tên phòng ban: ");
		String name = scn.nextLine();
		Department dep = new Department();
		dep.name = name;

		System.out.println("Thông tin phòng ban vừa tạo: " + dep);
		System.out.println("name: " + dep.name);
	}

//	Question 7:
//	Nhập số chẵn từ console
	public static void question7() {
		System.out.print("Nhập một sỗ chẵn: ");
		int num = scn.nextInt();

		if (num % 2 != 0) {
			System.out.println("Có chắc số vừa rồi là chẵn không vậy? :/");
		} else {
			System.out.println("Sô chẵn vừa nhập là: " + num);
		}
	}

//	Question 8:
//	Viết chương trình thực hiện theo flow sau:
//	Bước 1:
//	Chương trình in ra text "mời bạn nhập vào chức năng muốn sử
//	dụng"
//	Bước 2:
//	Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
//	Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo
//	department
//	Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập
//	lại" và quay trở lại bước 1
	public static void question8() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
		System.out.println("1. Tạo account");
		System.out.println("2. Tạo department");
		int choice = scn.nextInt();

		switch (choice) {
		case 1:
			question5();
			break;
		case 2:
			question6();
			break;
		default:
			System.out.println("Mời bạn nhập lại.");
			question8();
			break;
		}
		scn.close();
	}

//	Question 9:
//	Viết method cho phép người dùng thêm group vào account theo flow sau:
//	Bước 1:
//	In ra tên các usernames của user cho người dùng xem
//	Bước 2:
//	Yêu cầu người dùng nhập vào username của account
//	Bước 3:
//	In ra tên các group cho người dùng xem
//	Bước 4:
//	Yêu cầu người dùng nhập vào tên của group
//	Bước 5:
//	Dựa vào username và tên của group người dùng vừa chọn, hãy
//	thêm account vào group đó .
	public static void question9() {
		boolean isUserFound = false;
		boolean isGroupFound = false;

		System.out.println("Thêm group vào account.");
		System.out.println("Danh sách các user:");
		for (Account acc : accList) {
			System.out.println(acc.username);
		}
		System.out.print("Nhập tên user: ");
		String username = scn.nextLine();

		System.out.println("Danh sách các group:");
		for (Group gr : grList) {
			System.out.println(gr.name);
		}
		System.out.println("Nhập tên group: ");
		String grName = scn.nextLine();

		Group grAdd = null;
		for (Group gr : grList) {
			if (gr.name.equals(grName)) {
				isUserFound = true;
				grAdd = gr;
				break;
			}
		}

		for (Account acc : accList) {
			if (acc.username.equals(username)) {
				isUserFound = true;
				if (acc.groups != null) {
					acc.groups = Arrays.copyOf(acc.groups, acc.groups.length + 1);
					acc.groups[acc.groups.length - 1] = grAdd;
				} else {
					acc.groups = new Group[] { grAdd };
				}
				System.out.printf("Thêm thành công '%s' vào nhóm '%s' %n", acc.username, grAdd.name);
				break;
			}
		}
		if (!isUserFound) {
			System.out.println("User không tồn tại");
		}
		if (!isGroupFound) {
			System.out.println("Group không tồn tại");
		}
	}

//	Question 10: Tiếp tục Question 8 và Question 9
//	Bổ sung thêm vào bước 2 của Question 8 như sau:
//	Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào
//	account
//	Bổ sung thêm Bước 3 của Question 8 như sau:
//	Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng
//	text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác
//	không?". Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người
//	dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để
//	kết thúc chương trình)
	public static void question10() {
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
		System.out.println("1. Tạo account");
		System.out.println("2. Tạo department");
		System.out.println("3. Thêm account vào group");
		int choice = 0;
		if (scn.hasNextInt()) {
			choice = scn.nextInt();
		}
		scn.nextLine();

		switch (choice) {
		case 1:
			question5();
			break;
		case 2:
			question6();
			break;
		case 3:
			question9();
			break;
		default:
			System.out.println("Mời bạn nhập lại.");
			question10();
			break;
		}

		System.out.println("Bạn có muốn thực hiện chức năng khác không?");
		System.out.println("1. Có; 2. Không");
		int nextChoice = scn.nextInt();
		if (nextChoice == 1) {
			question10();
		}
	}

//	Question 11: Tiếp tục Question 10
//	Bổ sung thêm vào bước 2 của Question 8 như sau:
//	Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account
//	vào 1 nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
//	Bước 1:
//	In ra tên các usernames của user cho người dùng xem
//	Bước 2:
//	Yêu cầu người dùng nhập vào username của account
//	Bước 3:
//	Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
//	Bước 4:
//	Thêm account vào group chương trình vừa chọn ngẫu
//	nhiên
	public static void question11() {
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
		System.out.println("1. Tạo account");
		System.out.println("2. Tạo department");
		System.out.println("3. Thêm account vào group");
		System.out.println("4. Thêm account vào group random");
		int choice = 0;
		if (scn.hasNextInt()) {
			choice = scn.nextInt();
		}
		scn.nextLine();

		switch (choice) {
		case 1:
			question5();
			break;
		case 2:
			question6();
			break;
		case 3:
			question9();
			break;
		case 4:
			question9_rand();
			break;
		default:
			System.out.println("Mời bạn nhập lại.");
			question11();
			break;
		}

		System.out.println("Bạn có muốn thực hiện chức năng khác không?");
		System.out.println("1. Có; 2. Không");
		int nextChoice = scn.nextInt();
		if (nextChoice == 1) {
			question11();
		}
	}

	public static void question9_rand() {
		boolean isUserFound = false;

		System.out.println("Thêm group vào account.");
		System.out.println("Danh sách các user:");
		for (Account acc : accList) {
			System.out.println(acc.username);
		}
		System.out.print("Nhập tên user: ");
		String username = scn.nextLine();

		for (Account acc : accList) {
			if (acc.username.equals(username)) {
				isUserFound = true;

				Random rand = new Random();
				int randInt = rand.nextInt(grList.length);
				Group gr = grList[randInt];
				if (acc.groups != null) {
					acc.groups = Arrays.copyOf(acc.groups, acc.groups.length + 1);
					acc.groups[acc.groups.length - 1] = gr;
				} else {
					acc.groups = new Group[] { gr };
				}
				System.out.printf("Thêm thành công '%s' vào nhóm '%s' %n", acc.username, gr.name);
				break;
			}
		}

		if (!isUserFound) {
			System.out.println("User không tồn tại.");
		}
	}
}
