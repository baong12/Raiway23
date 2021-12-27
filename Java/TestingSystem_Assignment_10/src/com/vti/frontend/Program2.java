package com.vti.frontend;

import java.sql.SQLException;

import com.vti.backend.DepartmentDao;
import com.vti.backend.Exercise2_Crud;
import com.vti.utils.ScannerUtils;

public class Program2 {
	public static void main(String[] args) {
		DepartmentDao.connectDb();
		boolean isDone = false;
		while (!isDone) {
			System.out.println("\n---------------------------------" + "\nChọn question, 0 để thoát:");
			int select = ScannerUtils.inputInt();
			try {
				switch (select) {
				case 0:
					isDone = true;
					break;
				case 1:
					Exercise2_Crud.question1();
					break;
				case 2:
					Exercise2_Crud.question2();
					break;
				case 3:
					Exercise2_Crud.question3();
					break;
				case 4:
					Exercise2_Crud.question4();
					break;
				case 5:
					Exercise2_Crud.question5();
					break;
				case 6:
					Exercise2_Crud.question6();
					break;
				case 7:
					Exercise2_Crud.question7();
					break;
				default:
					break;
				}
			} catch (SQLException e) {
				System.out.println("Lỗi kết nối SQL");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Đã xảy ra lỗi");
				e.printStackTrace();
			}
		}
		DepartmentDao.closeConnection();
		ScannerUtils.closeScanner();
	}
}
