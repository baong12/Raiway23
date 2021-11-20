package com.vti.academy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Exercise5InputFormConsole {
	private static ExerciseCommon com = new ExerciseCommon();
	private static Department[] depList = { com.dp1, com.dp2, com.dp3, com.dp4, com.dp5 };
	private static Position[] posList = { com.pos1, com.pos2, com.pos3, com.pos4 };
	private static Account[] accList = { com.acc1, com.acc2, com.acc3, com.acc4, com.acc5 };
	private static Group[] grList = { com.gr1, com.gr2, com.gr3, com.gr4 };
	private static Scanner scn;

	public static void main(String[] args) throws ParseException {
		scn = new Scanner(System.in);

		System.out.println("\n-- Question 1:");
//		Question1();

		System.out.println("\n-- Question 2:");
//		Question2();

		System.out.println("\n-- Question 3:");
//		Question3();

		System.out.println("\n-- Question 4:");
//		Question4();

		System.out.println("\n-- Question 5:");
//		Question5();

		System.out.println("\n-- Question 6:");
//		Question6();

		System.out.println("\n-- Question 7:");
//		Question7();
//		Question7Cach2();

		System.out.println("\n-- Question 8:");
//		Question8();

		System.out.println("\n-- Question 9:");
//		Question9();

		System.out.println("\n-- Question 10:");
//		Question10();

		System.out.println("\n-- Question 11:");
		Question11();

		scn.close();
	}

//	Question 1:
//	Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
	public static void Question1() {
		System.out.println("Nhập 1 số nguyên: ");
		int num1 = scn.nextInt();
		System.out.println("Nhập 1 số nguyên: ");
		int num2 = scn.nextInt();
		System.out.println("Nhập 1 số nguyên: ");
		int num3 = scn.nextInt();

		System.out.println("3 số nguyên bạn vừa nhập:");
		System.out.printf("%d, %d, %d %n", num1, num2, num3);
	}

//	Question 2:
//	Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
	public static void Question2() {
		System.out.println("Nhập 1 số thực: ");
		float num1 = scn.nextFloat();
		System.out.println("Nhập 1 số thực: ");
		float num2 = scn.nextFloat();

		System.out.println("3 số nguyên bạn vừa nhập:");
		System.out.printf("%f, %f %n", num1, num2);
	}

//	Question 3:
//	Viết lệnh cho phép người dùng nhập họ và tên
	public static void Question3() {
		System.out.println("Nhập họ và tên: ");
		String fullName = scn.nextLine();
		System.out.println("Họ và tên: " + fullName);
	}

//	Question 4:
//	Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
	public static void Question4() throws ParseException {
		System.out.println("Nhập ngày sinh nhật: ");
		String dateInput = scn.next();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = dateFormat.parse(dateInput);

		System.out.println("Input: " + date);
	}

//	Question 5:
//	Viết lệnh cho phép người dùng tạo account (viết thành method)
//	Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
//	chương trình sẽ chuyển thành Position.Dev, Position.Test,
//	Position.ScrumMaster, Position.PM
	public static void Question5() {
		System.out.println("Nhập thông tin account mới.");
		System.out.print("Email: ");
		String email = scn.nextLine();
		System.out.print("Username: ");
		String username = scn.nextLine();
		System.out.print("Họ và tên: ");
		String fullName = scn.nextLine();
		System.out.print("ID phòng ban: ");
		int depId = scn.nextInt();
		System.out.print("ID vị trí: ");
		int posId = scn.nextInt();

		Account acc = new Account();
		acc.email = email;
		acc.username = username;
		acc.fullName = fullName;

		acc.department = com.dp1;
		for (Department dep : depList) {
			if (dep.id == depId) {
				acc.department = dep;
				break;
			}
		}

		acc.position = com.pos1;
		for (Position pos : posList) {
			if (pos.id == posId) {
				acc.position = pos;
				break;
			}
		}

		acc.createDate = new Date();

		System.out.println("Thông tin accout vừa tạo: " + acc);
		System.out.println("email: " + acc.email);
		System.out.println("username: " + acc.username);
		System.out.println("fullName: " + acc.fullName);
		System.out.println("department: " + acc.department.name);
		System.out.println("position: " + acc.position.name.getPositionName());
		System.out.println("createDate: " + acc.createDate);
	}

//	Question 6:
//	Viết lệnh cho phép người dùng tạo department (viết thành method)
	public static void Question6() {
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
	public static void Question7() {
		int num = -1;
		boolean isEvenNumber = false;
		while (isEvenNumber == false) {
			System.out.print("Nhập một sỗ chẵn: ");
			num = scn.nextInt();
			isEvenNumber = num % 2 == 0;
			if (isEvenNumber == false) {
				System.out.println("Có chắc số vừa rồi là chẵn không vậy? :/");
			}
		}

		System.out.println("Sô chẵn vừa nhập là: " + num);
	}

	public static void Question7Cach2() {
		System.out.print("Nhập một sỗ chẵn: ");
		int num = scn.nextInt();

		if (num % 2 != 0) {
			System.out.println("Có chắc số vừa rồi là chẵn không vậy? :/");
			Question7Cach2();
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
	public static void Question8() {
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
		System.out.println("1. Tạo account");
		System.out.println("2. Tạo department");
		int choice = scn.nextInt();

		switch (choice) {
		case 1:
			Question5();
			break;
		case 2:
			Question6();
			break;
		default:
			System.out.println("Mời bạn nhập lại.");
			Question8();
			break;
		}
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
	public static void Question9() {
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

		for (Account acc : accList) {
			if (acc.username.equals(username)) {
				isUserFound = true;
				for (Group gr : grList) {
					if (gr.name.equals(grName)) {
						isGroupFound = true;
						acc.groups = new Group[] { gr };
						System.out.printf("Thêm thành công '%s' vào nhóm '%s' %n", acc.username, gr.name);
						break;
					}
				}
			}
		}
		if (!isUserFound) {
			System.out.println("User không tồn tại");
		} else {
			if (!isGroupFound) {
				System.out.println("Group không tồn tại");
			}
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
	public static void Question10() {
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
			Question5();
			break;
		case 2:
			Question6();
			break;
		case 3:
			Question9();
			break;
		default:
			System.out.println("Mời bạn nhập lại.");
			Question10();
			break;
		}

		System.out.println("Bạn có muốn thực hiện chức năng khác không?");
		System.out.println("1. Có; 2. Không");
		int nextChoice = scn.nextInt();
		if (nextChoice == 1) {
			Question10();
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
	public static void Question11() {
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
			Question5();
			break;
		case 2:
			Question6();
			break;
		case 3:
			Question9();
			break;
		case 4:
			Question9_rand();
			break;
		default:
			System.out.println("Mời bạn nhập lại.");
			Question11();
			break;
		}

		System.out.println("Bạn có muốn thực hiện chức năng khác không?");
		System.out.println("1. Có; 2. Không");
		int nextChoice = scn.nextInt();
		if (nextChoice == 1) {
			Question11();
		}
	}

	public static void Question9_rand() {
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
				acc.groups = new Group[] { gr };
				System.out.printf("Thêm thành công '%s' vào nhóm '%s' %n", acc.username, gr.name);
				break;
			}
		}

		if (!isUserFound) {
			System.out.println("User không tồn tại.");
		}
	}
}
