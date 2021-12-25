package com.vti.frontend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vti.backend.DepartmentDao;
import com.vti.entity.Department;
import com.vti.utils.ScannerUtils;

public class Program2 {
	public static void main(String[] args) {
		DepartmentDao.connectDb();
		boolean isDone = false;
		while (!isDone) {
			System.out.println("\n---------------------------------"
					+ "\nChọn question, 0 để thoát:");
			int select = ScannerUtils.inputInt();
			switch (select) {
			case 0:
				isDone = true;
				break;
			case 1:
				question1();
				break;
			case 2:
				question2();
				break;
			case 3:
				question3();
				break;
			case 4:
				question4();
				break;
			case 5:
				question5();
				break;
			case 6:
				question6();
				break;
			case 7:
				question7();
				break;
			default:
				break;
			}
		}
		DepartmentDao.closeConnection();
		ScannerUtils.closeScanner();
	}
	
	// Question 1:
	public static void question1() {
		List<Department> depList = new ArrayList<Department>();
		try {
			depList = DepartmentDao.getDepartments();
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối SQL");
			e.printStackTrace();
		}
		for (Iterator<Department> iterator = depList.iterator(); iterator.hasNext();) {
			Department department = iterator.next();
			System.out.println(department);
		}
	}
	
	// Question 2:
	public static void question2() {
		try {
			Department department = DepartmentDao.getDepartmentDemo();
			System.out.println(department);
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối SQL");
			e.printStackTrace();
		}
	}
	
	// Question 3:
	public static void question3() {
		System.out.println("Nhập id của department muốn tìm:");
		int id = ScannerUtils.inputInt();
		try {
		 	Department department = DepartmentDao.getDepartmentById(id);
		 	System.out.println(department);
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối SQL");
			e.printStackTrace();
		}
	}
	
	// Question 4:
	public static void question4() {
		System.out.println("Nhập name của department muốn tìm:");
		String name = ScannerUtils.inputString();
		try {
			boolean isExists = DepartmentDao.isDepartmentNameExists(name);
			System.out.println(isExists ? "Department tồn tại" : "Department không tồn tại");
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối SQL");
			e.printStackTrace();
		}
	}
	
	// Question 5:
	public static void question5() {
		System.out.println("Nhập name của department muốn tạo:");
		String name = ScannerUtils.inputString();
		try {
			DepartmentDao.createDepartment(name);
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối SQL");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Question 6:
	public static void question6() {
		System.out.println("Nhập id của department muốn sửa:");
		int id = ScannerUtils.inputInt();
		System.out.println("Nhập name mới của department:");
		String name = ScannerUtils.inputString();
		try {
			DepartmentDao.updateDepartmentName(id, name);
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối SQL");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Question 7:
	public static void question7() {
		System.out.println("Nhập id của department muốn xóa:");
		int id = ScannerUtils.inputInt();
		try {
			DepartmentDao.deleteDepartment(id);
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối SQL");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
