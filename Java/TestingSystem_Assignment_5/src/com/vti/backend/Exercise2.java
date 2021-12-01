package com.vti.backend;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhChuNhatDacBiet;
import com.vti.entity.HinhVuong;
import com.vti.entity.Student;

public class Exercise2 {
	private Student[] studentList;

	public void question1() {
		createStudentList();
		caLopDiemDanh();
		diHocBai(1);
		diDonVeSinh(2);
	}

	private void createStudentList() {
		System.out.println("\n--- Question 1:");
		studentList = new Student[10];
		studentList[0] = new Student(1, "Nguyen Van A1", 1);
		studentList[1] = new Student(2, "Nguyen Van A2", 1);
		studentList[2] = new Student(3, "Nguyen Van A3", 1);
		studentList[3] = new Student(4, "Nguyen Van A4", 1);
		studentList[4] = new Student(5, "Nguyen Van A5", 1);
		studentList[5] = new Student(6, "Nguyen Van B1", 2);
		studentList[6] = new Student(7, "Nguyen Van B2", 2);
		studentList[7] = new Student(8, "Nguyen Van B3", 2);
		studentList[8] = new Student(9, "Nguyen Van B4", 2);
		studentList[9] = new Student(10, "Nguyen Van B5", 2);
	}

	private void caLopDiemDanh() {
		for (Student student : studentList) {
			student.diemDanh();
		}
	}

	private void diHocBai(int groupId) {
		for (Student student : studentList) {
			if (student.getGroup() == groupId) {
				student.hocBai();
			}
		}
	}

	private void diDonVeSinh(int groupId) {
		for (Student student : studentList) {
			if (student.getGroup() == groupId) {
				student.diDonVeSinh();
			}
		}
	}

	public void question3() {
		System.out.println("\n--- Question 3:");
		HinhChuNhat hcn = new HinhChuNhat(10.5f, 15f);
		System.out.println(hcn);
		hcn.tinhChuVi();
		hcn.tinhDienTich();
		System.out.println();

		HinhChuNhatDacBiet hcndb = new HinhChuNhatDacBiet(10f, 20f);
		System.out.println(hcndb);
		hcndb.tinhChuVi();
		hcndb.tinhDienTich();
		System.out.println();
		
		HinhVuong hv = new HinhVuong(20f);
		System.out.println(hv);
		hv.tinhChuVi();
		hv.tinhDienTich();
	}
}
