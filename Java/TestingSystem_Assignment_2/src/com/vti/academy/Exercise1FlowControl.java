package com.vti.academy;

import java.util.Date;

import com.vti.academy.enums.PositionName;
import com.vti.academy.enums.TypeName;

public class Exercise1FlowControl {

	public static void main(String[] args) {
		// Add Department objects
		Department dp1 = new Department();
		dp1.id = 1;
		dp1.name = "Quản trị";

		Department dp2 = new Department();
		dp2.id = 2;
		dp2.name = "Kinh doanh";

		Department dp3 = new Department();
		dp3.id = 3;
		dp3.name = "Kĩ thuật";

		Department dp4 = new Department();
		dp4.id = 4;
		dp4.name = "Sales";

		Department dp5 = new Department();
		dp5.id = 5;
		dp5.name = "Kế toán";

		// Add Position objects
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.DEV;

		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.TEST;

		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.PM;

		Position pos4 = new Position();
		pos4.id = 4;
		pos4.name = PositionName.SCRUM_MASTER;

		// Add Account objects
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "a.nguyen@gmail.com";
		acc1.username = "a.nguyen";
		acc1.fullName = "Nguyễn Văn A";
		acc1.department = dp1;
		acc1.position = pos1;
		acc1.createDate = new Date();

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "b.nguyen@gmail.com";
		acc2.username = "b.nguyen";
		acc2.fullName = "Nguyễn Văn B";
		acc2.department = dp2;
		acc2.position = pos2;
		acc2.createDate = new Date();

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "c.nguyen@gmail.com";
		acc3.username = "c.nguyen";
		acc3.fullName = "Nguyễn Văn C";
		acc3.department = dp3;
		acc3.position = pos4;
		acc3.createDate = new Date();

		Account acc4 = new Account();
		acc4.id = 4;
		acc4.email = "d.nguyen@gmail.com";
		acc4.username = "d.nguyen";
		acc4.fullName = "Nguyễn Văn D";
		acc4.department = dp1;
		acc4.position = pos4;
		acc4.createDate = new Date();

		Account acc5 = new Account();
		acc5.id = 5;
		acc5.email = "e.nguyen@gmail.com";
		acc5.username = "e.nguyen";
		acc5.fullName = "Nguyễn Văn E";
		acc5.department = dp2;
		acc5.position = pos2;
		acc5.createDate = new Date();

		// Group
		Group gr1 = new Group();
		gr1.id = 1;
		gr1.name = "Railway 1";
		gr1.creator = acc1;
		gr1.createDate = new Date();

		Group gr2 = new Group();
		gr2.id = 2;
		gr2.name = "Railway 2";
		gr2.creator = acc5;
		gr2.createDate = new Date();

		Group gr3 = new Group();
		gr3.id = 3;
		gr3.name = "Railway 3";
		gr3.creator = acc1;
		gr3.createDate = new Date();

		Group gr4 = new Group();
		gr4.id = 4;
		gr4.name = "Railway 4";
		gr4.creator = acc2;
		gr4.createDate = new Date();

		// GroupAccount
		GroupAccount ga1 = new GroupAccount();
		ga1.group = gr1;
		ga1.account = acc1;
		ga1.joinDate = new Date();

		GroupAccount ga2 = new GroupAccount();
		ga2.group = gr1;
		ga2.account = acc2;
		ga2.joinDate = new Date();

		GroupAccount ga3 = new GroupAccount();
		ga3.group = gr2;
		ga3.account = acc1;
		ga3.joinDate = new Date();

		GroupAccount ga4 = new GroupAccount();
		ga4.group = gr4;
		ga4.account = acc5;
		ga4.joinDate = new Date();

		GroupAccount ga5 = new GroupAccount();
		ga5.group = gr4;
		ga5.account = acc2;
		ga5.joinDate = new Date();

		// TypeQuestion
		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.name = TypeName.ESSAY;

		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.name = TypeName.MULTIPLE_CHOICE;

		// CategoryQuestion
		CategoryQuestion cate1 = new CategoryQuestion();
		cate1.id = 1;
		cate1.name = "Java";

		CategoryQuestion cate2 = new CategoryQuestion();
		cate2.id = 2;
		cate2.name = ".NET";

		CategoryQuestion cate3 = new CategoryQuestion();
		cate3.id = 3;
		cate3.name = "SQL";

		CategoryQuestion cate4 = new CategoryQuestion();
		cate4.id = 4;
		cate4.name = "Postman";

		CategoryQuestion cate5 = new CategoryQuestion();
		cate5.id = 5;
		cate5.name = "Ruby";

		// Question
		Question que1 = new Question();
		que1.id = 1;
		que1.content = "Java là gì?";
		que1.category = cate1;
		que1.type = type1;
		que1.creator = acc5;
		que1.createDate = new Date();

		Question que2 = new Question();
		que2.id = 2;
		que2.content = ".NET là gì?";
		que2.category = cate2;
		que2.type = type1;
		que2.creator = acc2;
		que2.createDate = new Date();

		Question que3 = new Question();
		que3.id = 3;
		que3.content = "SQL là gì?";
		que3.category = cate3;
		que3.type = type2;
		que3.creator = acc1;
		que3.createDate = new Date();

		Question que4 = new Question();
		que4.id = 4;
		que4.content = "Postman là gì?";
		que4.category = cate4;
		que4.type = type1;
		que4.creator = acc5;
		que4.createDate = new Date();

		Question que5 = new Question();
		que5.id = 5;
		que5.content = "Ruby là gì?";
		que5.category = cate5;
		que5.type = type2;
		que5.creator = acc2;
		que5.createDate = new Date();

		// Answer
		Answer ans1 = new Answer();
		ans1.id = 1;
		ans1.content = "Là ngôn ngữ lập trình.";
		ans1.question = que1;
		ans1.isCorrect = true;

		Answer ans2 = new Answer();
		ans2.id = 2;
		ans2.content = "Là tên một ca sĩ.";
		ans2.question = que1;
		ans2.isCorrect = true;

		Answer ans3 = new Answer();
		ans3.id = 3;
		ans3.content = "Là một loại trái cây.";
		ans3.question = que3;
		ans3.isCorrect = true;

		Answer ans4 = new Answer();
		ans4.id = 4;
		ans4.content = "Là một cầu thủ bóng đá.";
		ans4.question = que4;
		ans4.isCorrect = true;

		Answer ans5 = new Answer();
		ans5.id = 5;
		ans5.content = "Là một từ tiếng Anh.";
		ans5.question = que5;
		ans5.isCorrect = true;

		// Exam
		Exam ex1 = new Exam();
		ex1.id = 1;
		ex1.code = "JAV-001";
		ex1.title = "Kì thi Java số 1";
		ex1.category = cate1;
		ex1.duration = 45;
		ex1.creator = acc1;
		ex1.createDate = new Date();

		Exam ex2 = new Exam();
		ex2.id = 2;
		ex2.code = "JAV-002";
		ex2.title = "Kì thi Java số 2";
		ex2.category = cate3;
		ex2.duration = 60;
		ex2.creator = acc1;
		ex2.createDate = new Date();

		Exam ex3 = new Exam();
		ex3.id = 3;
		ex3.code = "SQL-001";
		ex3.title = "Kì thi SQL số 1";
		ex3.category = cate2;
		ex3.duration = 90;
		ex3.creator = acc5;
		ex3.createDate = new Date();

		// ExamQuestion
		ExamQuestion eq1 = new ExamQuestion();
		eq1.exam = ex1;
		eq1.question = que1;

		ExamQuestion eq2 = new ExamQuestion();
		eq2.exam = ex1;
		eq2.question = que2;

		ExamQuestion eq3 = new ExamQuestion();
		eq3.exam = ex1;
		eq3.question = que3;

		ExamQuestion eq4 = new ExamQuestion();
		eq4.exam = ex1;
		eq4.question = que4;

		ExamQuestion eq5 = new ExamQuestion();
		eq5.exam = ex2;
		eq5.question = que2;

		ExamQuestion eq6 = new ExamQuestion();
		eq6.exam = ex2;
		eq6.question = que3;

		ExamQuestion eq7 = new ExamQuestion();
		eq7.exam = ex3;
		eq7.question = que1;

		ExamQuestion eq8 = new ExamQuestion();
		eq8.exam = ex3;
		eq8.question = que3;

		// Exercise
		System.out.println("-- Question 1:");
		question1(acc2);
		acc2.department = null;
		question1(acc2);
		acc2.department = dp2;

		System.out.println("\n-- Question 2:");
		question2(acc2);
		acc2.groups = new Group[] { gr1 };
		question2(acc2);
		acc2.groups = new Group[] { gr1, gr2 };
		question2(acc2);
		acc2.groups = new Group[] { gr1, gr2, gr3 };
		question2(acc2);
		acc2.groups = new Group[] { gr1, gr2, gr3, gr4 };
		question2(acc2);

		System.out.println("\n-- Question 3:");
		question3(acc1);

		System.out.println("\n-- Question 4:");
		question4(acc1);
		acc1.position = pos2;
		question4(acc1);
		
		System.out.println("\n-- Question 5:");
		question5(gr1);
		gr1.members = new Account[] {};
		question5(gr1);
		gr1.members = new Account[] { acc1 };
		question5(gr1);
		gr1.members = new Account[] { acc1, acc2 };
		question5(gr1);
		gr1.members = new Account[] { acc1, acc2, acc3 };
		question5(gr1);
		gr1.members = new Account[] { acc1, acc2, acc3, acc4 };
		question5(gr1);

		System.out.println("\n-- Question 6:");
		question6(acc2);
		
		System.out.println("\n-- Question 7:");
		question7(acc2);
		
		System.out.println("\n-- Question 8:");
		Account[] accounts = { acc1, acc2, acc3, acc4, acc5 };
		question8(accounts);
		
		System.out.println("\n-- Question 9:");
		Department[] departments = { dp1, dp2, dp3, dp4, dp5 };
		question9(departments);
		
		System.out.println("\n-- Question 10:");
		question10(accounts);
		
		System.out.println("\n-- Question 11:");
		question11(departments);
		
		System.out.println("\n-- Question 12:");
		question12(departments);
		
		System.out.println("\n-- Question 13:");
		question13(accounts);
		
		System.out.println("\n-- Question 14:");
		question14(accounts);
		
		System.out.println("\n- Question 15:");
		question15();

		System.out.println("\n-- Question 16:");
		question16_10(accounts);
		question16_11(departments);
		question16_12(departments);
		question16_13(accounts);
		question16_14(accounts);
		question16_15();
		
		System.out.println("\n-- Question 17:");
		question17_10(accounts);
		question17_11(departments);
		question17_12(departments);
		question17_13(accounts);
		question17_14(accounts);
		question17_15();
	}
//	IF
//	Question 1:
//		Kiểm tra account thứ 2
//		Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
//		"Nhân viên này chưa có phòng ban"
//		Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
	public static void question1(Account acc) {
		if (acc.department == null) {
			System.out.println("Nhân viên không có phòng ban.");
		} else {
			System.out.println("Phòng ban của nhân viên là: " + acc.department.name);
		}
	}

//	Question 2:
//		Kiểm tra account thứ 2
//		Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//		Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
//		này là Java Fresher, C# Fresher"
//		Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
//		quan trọng, tham gia nhiều group"
//		Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
//		người hóng chuyện, tham gia tất cả các group"
	public static void question2(Account acc) {
		int groupCount = acc.groups == null ? 0 : acc.groups.length;
		if (groupCount == 0) {
			System.out.println("Nhân viên này chưa có group");
		} else if (groupCount == 1) {
			System.out.println("Group của nhân viên này là " + acc.groups[0].name);
		} else if (groupCount == 2) {
			System.out.println("Group của nhân viên này là " + acc.groups[0].name + ", " + acc.groups[1].name);
		} else if (groupCount == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
	}

//	Question 3:
//		Sử dụng toán tử ternary để làm Question 1
	public static void question3(Account acc) {
		System.out.println(acc.department == null
				? "Nhân viên không có phòng ban."
				: "Phòng ban của nhân viên là: " + acc.department.name);
	}

//	Question 4:
//	Sử dụng toán tử ternary để làm yêu cầu sau:
//		Kiểm tra Position của account thứ 1
//		Nếu Position = Dev thì in ra text "Đây là Developer"
//		Nếu không phải thì in ra text "Người này không phải là Developer"
	public static void question4(Account acc) {
		System.out.println(acc.position.name == PositionName.DEV
				? "Đây là Developer"
				: "Người này không phải là Developer");
	}
	
//	SWITCH CASE
//	Question 5:
//		Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//		Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//		Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//		Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//		Còn lại in ra "Nhóm có nhiều thành viên"
	public static void question5(Group gr) {
		int memberCount = gr.members == null ? 0 : gr.members.length;
		
		switch (memberCount) {
		case 0:
			System.out.println("Nhóm không có thành viên");
			break;
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}
	}
	
//	Question 6:
//		Sử dụng switch case để làm lại Question 2
	public static void question6(Account acc) {
		int groupCount = acc.groups == null ? 0 : acc.groups.length;
		switch (groupCount) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 1:
			System.out.println("Group của nhân viên này là " + acc.groups[0].name);
			break;
		case 2:
			System.out.println("Group của nhân viên này là " + acc.groups[0].name + ", " + acc.groups[1].name);
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		}
	}
	
//	Question 7:
//		Sử dụng switch case để làm lại Question 4
	public static void question7(Account acc) {
		switch (acc.position.name) {
		case DEV:
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
			break;
		}
	}
	
//	FOREACH
//	Question 8:
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//		họ
	public static void question8(Account[] accArray) {
		for (Account acc : accArray) {
			System.out.println("Email: " + acc.email
					+ ", FullName: " + acc.fullName
					+ ", Department: " + acc.department.name);
		}
	}
	
//	Question 9:
//		In ra thông tin các phòng ban bao gồm: id và name
	public static void question9(Department[] depArray) {
		for (Department dep : depArray) {
			System.out.println("Id: " + dep.id + ", Name: " + dep.name);
		}
	}

//	FOR
//	Question 10:
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//		họ theo định dạng như sau:
//		Thông tin account thứ 1 là:
//		Email: NguyenVanA@gmail.com
//		Full name: Nguyễn Văn A
//		Phòng ban: Sale
//		Thông tin account thứ 2 là:
//		Email: NguyenVanB@gmail.com
//		Full name: Nguyễn Văn B
//		Phòng ban: Marketting
	public static void question10(Account[] accArray) {
		int arrayLength = accArray.length;
		for (int i = 0; i < arrayLength; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Full name: " + accArray[i].fullName);
			System.out.println("Phòng ban: " + accArray[i].department.name);
		}
	}
	
//	Question 11:
//		In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//		Thông tin department thứ 1 là:
//		Id: 1
//		Name: Sale
//		Thông tin department thứ 2 là:
//		Id: 2
//		Name: Marketing
	public static void question11(Department[] depArray) {
		int arrayLength = depArray.length;
		for (int i = 0; i < arrayLength; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray[i].id);
			System.out.println("Name: " + depArray[i].name);
		}
	}
	
//	Question 12:
//		Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
	public static void question12(Department[] depArray) {
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray[i].id);
			System.out.println("Name: " + depArray[i].name);
		}
	}
	
//	Question 13:
//		In ra thông tin tất cả các account ngoại trừ account thứ 2
	public static void question13(Account[] accArray) {

		for (int i = 0; i < accArray.length; i++) {
			if (i == 1)
				continue;
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Full name: " + accArray[i].fullName);
			System.out.println("Phòng ban: " + accArray[i].department.name);
		}
	}
	
//	Question 14:
//		In ra thông tin tất cả các account có id < 4
	public static void question14(Account[] accArray) {
		int arrayLength = accArray.length;
		for (int i = 0; i < arrayLength; i++) {
			if (accArray[i].id >= 4)
				continue;
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Full name: " + accArray[i].fullName);
			System.out.println("Phòng ban: " + accArray[i].department.name);
		}
	}
	
//	Question 15:
//		In ra các số chẵn nhỏ hơn hoặc bằng 20
	public static void question15() {
		System.out.println("Các số chẵn nhỏ hơn hoặc bằng 20:");
		for (int i = 0; i <= 20; i++) {
			if (i % 2 == 0)
				System.out.println(i);
		}
	}
	
//	WHILE
//	Question 16:
//	Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với
//	lệnh break, continue
	public static void question16_10(Account[] accArray) {
		int i = 0;
		int arrayLength = accArray.length;
		while (i < arrayLength) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Full name: " + accArray[i].fullName);
			System.out.println("Phòng ban: " + accArray[i].department.name);
			i++;
		}
	}
	
	public static void question16_11(Department[] depArray) {
		int i = 0;
		int arrayLength = depArray.length;
		while (i < arrayLength) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray[i].id);
			System.out.println("Name: " + depArray[i].name);
			i++;
		}
	}

	public static void question16_12(Department[] depArray) {
		int i = 0;
		int arrayLength = depArray.length;
		while (i < arrayLength) {
			if (i >= 2)
				break;
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray[i].id);
			System.out.println("Name: " + depArray[i].name);
			i++;
		}
	}
	
	public static void question16_13(Account[] accArray) {
		int i = 0;
		int arrayLength = accArray.length;
		while (i < arrayLength) {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Full name: " + accArray[i].fullName);
			System.out.println("Phòng ban: " + accArray[i].department.name);
			i++;
		}
	}
	
	public static void question16_14(Account[] accArray) {
		int i = 0;
		int arrayLength = accArray.length;
		while (i < arrayLength) {
			if (accArray[i].id >= 4) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Full name: " + accArray[i].fullName);
			System.out.println("Phòng ban: " + accArray[i].department.name);
			i++;
		}
	}
	
	public static void question16_15() {
		System.out.println("Các số chẵn nhỏ hơn hoặc bằng 20:");
		int i = 0;
		while (i <= 20) {
			if (i % 2 == 0)
				System.out.println(i);
			i++;
		}
	}
	
//	DO-WHILE
//	Question 17:
//	Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với
//	lệnh break, continue	
	public static void question17_10(Account[] accArray) {
		int i = 0;
		int arrayLength = accArray.length;
		do {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Full name: " + accArray[i].fullName);
			System.out.println("Phòng ban: " + accArray[i].department.name);
			i++;
		} while (i < arrayLength);
	}
	
	public static void question17_11(Department[] depArray) {
		int i = 0;
		int arrayLength = depArray.length;
		do {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray[i].id);
			System.out.println("Name: " + depArray[i].name);
			i++;
		} while (i < arrayLength);
	}
	
	public static void question17_12(Department[] depArray) {
		int i = 0;
		int arrayLength = depArray.length;
		do {
			if (i >= 2)
				break;
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray[i].id);
			System.out.println("Name: " + depArray[i].name);
			i++;
		} while (i < arrayLength);
	}
	
	public static void question17_13(Account[] accArray) {
		int i = 0;
		int arrayLength = accArray.length;
		do {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Full name: " + accArray[i].fullName);
			System.out.println("Phòng ban: " + accArray[i].department.name);
			i++;
		} while (i < arrayLength);
	}
	
	public static void question17_14(Account[] accArray) {
		int i = 0;
		int arrayLength = accArray.length;
		do {
			if (accArray[i].id >= 4) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Full name: " + accArray[i].fullName);
			System.out.println("Phòng ban: " + accArray[i].department.name);
			i++;
		} while (i < arrayLength);
		
		System.out.println("Question 16:\r\n"
				+ "Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với\r\n"
				+ "lệnh break, continue");
	}
	
	public static void question17_15() {
		System.out.println("Các số chẵn nhỏ hơn hoặc bằng 20:");
		int i = 0;
		do {
			if (i % 2 == 0)
				System.out.println(i);
			i++;
		} while (i <= 20);
	}
}
