package com.vti.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.ExerciseCommon;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.enums.PositionName;

public class Exercise1_Constructor {
	private ExerciseCommon com = new ExerciseCommon();
	
//	Question 1:
//		Tạo constructor cho department:
//		a) không có parameters
//		b) Có 1 parameter là nameDepartment và default id của
//		Department = 0
//		Khởi tạo 1 Object với mỗi constructor ở trên
	public void question1() {
		System.out.println("\n-- Question 1:");
		System.out.println("a) Hàm khởi tạo không tham số");
		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Sales";
		System.out.println(dep1);

		System.out.println("b) Hàm khởi tạo có tham số");
		Department dep2 = new Department("Kinh doanh");
		System.out.println(dep2);
	}

//	Question 2:
//		Tạo constructor cho Account:
//		a) Không có parameters
//		b) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName)
//		c) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName) và
//		Position của User, default createDate = now
//		d) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName) và
//		Position của User, createDate
//		Khởi tạo 1 Object với mỗi constructor ở trên
	public void question2() {
		System.out.println("\n-- Question 2:");
		System.out.println("a) Hàm khởi tạo không tham số");
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "an.nguyen@gmail.com";
		acc1.username = "an.nguyen";
		acc1.fullName = "Nguyễn Văn An";
		Department dp1 = new Department("Sale");
		acc1.department = dp1;
		Position pos1 = new Position();
		pos1.name = PositionName.PM;
		acc1.position = pos1;
		acc1.createDate = new Date();
		System.out.println(acc1);

		System.out.println("b) Hàm khởi tạo có tham số id, Email, Username, FirstName, LastName");
		Account acc2 = new Account(2, "binh.nguyen@gmail", "binh.nguyen", "Bình", "Nguyễn");
		System.out.println(acc2);

		System.out.println("c) Hàm khởi tạo có tham số id, Email, Username, FirstName, LastName, Position");
		Position pos3 = new Position();
		pos1.name = PositionName.DEV;
		Account acc3 = new Account(3, "cuong.do@gmail.com", "cuong.do", "Cường", "Dollard", pos3);
		System.out.println(acc3);

		System.out.println("d) Hàm khởi tạo có tham số id, Email, Username, FirstName, LastName, Position, CreateDate");
		Position pos4 = new Position();
		pos4.name = PositionName.SCRUM_MASTER;
		Account acc4 = new Account(4, "duong.cao@gmail.com", "duong.cao", "Dương", "Cao", pos4,
				getDatefromString("2021-10-21"));
		System.out.println(acc4);
	}

	private Date getDatefromString(String dateString) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

//	Question 3:
//		Tạo constructor cho Group:
//		a) không có parameters
//		b) Có các parameter là GroupName, Creator, array Account[]
//		accounts, CreateDate
//		c) Có các parameter là GroupName, Creator, array String[]
//		usernames , CreateDate
//		Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
//		username, các thông tin còn lại = null).
//		Khởi tạo 1 Object với mỗi constructor ở trên
	public void question3() {
		System.out.println("\n-- Question 3:");
		System.out.println("a) Hàm khởi tạo không tham số");
		Group gr1 = new Group();
		gr1.id = 1;
		gr1.name = "Group Ichi";
		Account acc1 = new Account();
		acc1.username = "an.nguyen";
		gr1.creator = acc1;
		gr1.createDate = new Date();
		System.out.println(gr1);
		
		System.out.println("b) Hàm khởi tạo có tham số GroupName, Creator, array Account[] accounts, CreateDate");
		Account[] accounts = new Account[] { com.acc1, com.acc2, com.acc3, com.acc4, com.acc5 };
		Group gr2 = new Group("Group High", acc1, accounts, new Date());
		System.out.println(gr2);
		
		System.out.println("c) Hàm khởi tạo có tham số GroupName, Creator, array String[] usernames, CreateDate");
		String[] usernames = { "an.nguyen", "binh.trinh", "chinh.pham", "huy.nguyen", "duy.ngo" };
		Group gr3 = new Group("Group Bar", acc1, usernames, getDatefromString("2021-9-11"));
		System.out.println(gr3);
	}

}
