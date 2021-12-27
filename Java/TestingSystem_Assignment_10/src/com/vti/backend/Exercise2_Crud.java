package com.vti.backend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vti.entity.Department;
import com.vti.utils.ScannerUtils;

public class Exercise2_Crud {
	// Question 1:
	public static void question1() throws SQLException {
		List<Department> depList = new ArrayList<Department>();
		depList = DepartmentDao.getDepartments();
		for (Iterator<Department> iterator = depList.iterator(); iterator.hasNext();) {
			Department department = iterator.next();
			System.out.println(department);
		}
	}

	// Question 2:
	public static void question2() throws SQLException {
		Department department = DepartmentDao.getDepartmentDemo();
		System.out.println(department);
	}

	// Question 3:
	public static void question3() throws SQLException {
		System.out.println("Nhập id của department muốn tìm:");
		int id = ScannerUtils.inputInt();
		Department department = DepartmentDao.getDepartmentById(id);
		System.out.println(department);
	}

	// Question 4:
	public static void question4() throws SQLException {
		System.out.println("Nhập name của department muốn tìm:");
		String name = ScannerUtils.inputString();
		boolean isExists = DepartmentDao.isDepartmentNameExists(name);
		System.out.println(isExists ? "Department tồn tại" : "Department không tồn tại");
	}

	// Question 5:
	public static void question5() throws SQLException, Exception {
		System.out.println("Nhập name của department muốn tạo:");
		String name = ScannerUtils.inputString();
		DepartmentDao.createDepartment(name);
	}

	// Question 6:
	public static void question6() throws SQLException, Exception {
		System.out.println("Nhập id của department muốn sửa:");
		int id = ScannerUtils.inputInt();
		System.out.println("Nhập name mới của department:");
		String name = ScannerUtils.inputString();
		DepartmentDao.updateDepartmentName(id, name);
	}

	// Question 7:
	public static void question7() throws SQLException, Exception {
		System.out.println("Nhập id của department muốn xóa:");
		int id = ScannerUtils.inputInt();
		DepartmentDao.deleteDepartment(id);
	}
}
