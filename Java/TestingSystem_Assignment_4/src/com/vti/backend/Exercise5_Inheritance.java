package com.vti.backend;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;
import com.vti.entity.enums.Gender;

public class Exercise5_Inheritance {
	private CanBo[] canBoList;
	
//	Question 1: inheritance
//		Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên.
//		Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ,
//		khác), địa chỉ.
//		Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
//		Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
//		Các nhân viên có thuộc tính riêng: công việc.
//		Hãy xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp
//		CanBo.
	public void question1() {
		System.out.println("\n-- Question 1:");
//		CanBo canBo = new CanBo("Nguyen Van A", (byte) 25, Gender.MALE, "Ha Noi");
//		System.out.println(canBo);
		CongNhan congNhan = new CongNhan("Nguyen Van B", (byte) 30, Gender.OTHER, "Bac Ninh", 5);
		System.out.println(congNhan);
		KySu kySu = new KySu("Nguyen Thi C", (byte) 26, Gender.FEMALE, "Hai Duong", "Ky Thuat Dien");
		System.out.println(kySu);
		NhanVien nhanVien = new NhanVien("Nguyen Van D", (byte) 40, Gender.MALE, "Phu Tho", "Giam doc");
		System.out.println(nhanVien);
	}

//	Question 2: Tiếp tục Question 1
//		Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực
//		hiện các chức năng sau:
//		a) Thêm mới cán bộ.
//		b) Tìm kiếm theo họ tên.
//		c) Hiện thị thông tin về danh sách các cán bộ.
//		d) Nhập vào tên của cán bộ và delete cán bộ đó
//		e) Thoát khỏi chương trình.
	public void question2() {
		System.out.println("\n-- Question 2:");
		Scanner scanner = new Scanner(System.in);
		canBoList = new CanBo[] {};
		boolean isContinued = true;

		while (isContinued) {
			System.out.println("------ Quan ly can bo -------");
			System.out.println("1. Thêm mới cán bộ.\r\n" 
					+ "2. Tìm kiếm theo họ tên.\r\n"
					+ "3. Hiện thị thông tin về danh sách các cán bộ.\r\n"
					+ "4. Nhập vào tên của cán bộ và delete cán bộ đó\r\n" 
					+ "5. Thoát khỏi chương trình.");
			System.out.println("Nhập số để chọn chức năng:");
			int select = scanner.nextInt();
			scanner.nextLine();

			switch (select) {
			case 1:
				addCanBoUI(scanner);
				break;
			case 2:
				searchCanBoByNameUI(scanner);
				break;
			case 3:
				getCanBoListInfo();
				break;
			case 4:
				deleteCanBoByNameUI(scanner);
				break;
			case 5:
				isContinued = false;
				break;
			default:
				System.out.println("Chỉ được nhập số tương ứng với chức năng");
				break;
			}

			System.out.println("Tiếp tục? 1. Có, 2. Không");
			if (scanner.nextInt() != 1) {
				isContinued = false;
			}
			scanner.nextLine();
		}

		scanner.close();
	}
	
	private void addCanBoUI(Scanner scanner) {
		System.out.println("\n--- Thêm mới cán bộ");
		System.out.println("Loại cán bộ (nhập số):");
		System.out.println("1. Công nhân");
		System.out.println("2. Kỹ sư");
		System.out.println("3. Nhân viên");
		int type = scanner.nextInt();
		scanner.nextLine();
		type = type >= 1 && type <= 3 ? type : 0;
		if (type == 0) {
			addCanBoUI(scanner);
		}
		
		System.out.println("Họ vả tên:");
		String name = scanner.nextLine();
		
		System.out.println("Tuổi:");
		byte age = (byte) scanner.nextInt();
		scanner.nextLine();
		
		Gender gender = getGenderFromConsole(scanner);
		
		System.out.println("Địa chỉ:");
		String address = scanner.nextLine();
		
		CanBo newCanBo = null;
//		newCanBo = new CanBo(name, age, gender, address);
		
		switch (type) {
			case 1:
				System.out.println("Bậc:");
				int level = scanner.nextInt();
				scanner.nextLine();
				newCanBo = new CongNhan(name, age, gender, address, level);
				break;
			case 2:
				System.out.println("Ngành đào tạo:");
				String specialty = scanner.nextLine();
				newCanBo = new KySu(name, age, gender, address, specialty);
				break;
			case 3:
				System.out.println("Công việc:");
				String job = scanner.nextLine();
				newCanBo = new NhanVien(name, age, gender, address, job);
				break;
		}
		
		System.out.println("Nhập thành công!");
		System.out.println(addCanBo(newCanBo));
	}
	
	private Gender getGenderFromConsole(Scanner scanner) {
		Gender result = null;
		boolean isOk = false;
		
		while (isOk == false) {
			System.out.println("Giới tính (nhập số):");
			System.out.println("1. Nam");
			System.out.println("2. Nữ");
			System.out.println("3. Khác");
			int num = scanner.nextInt();
			scanner.nextLine();
			if (num >= 1 && num <= 3) {
				result = Gender.values()[num - 1];
				isOk = true;
			}
		}
		return result;
	}
	
	private int getLevelFromConsole(Scanner scanner) {
		int result = 0;
		while (result == 0) {
			System.out.println("Bậc (1-10):");
			result = scanner.nextInt();
		}
		scanner.nextLine();
		return result;
	}
	
	private void searchCanBoByNameUI(Scanner scanner) {
		System.out.println("Nhập tên cán bộ:");
		String name = scanner.nextLine();
		System.out.println("Kết quả tìm kiếm:");
		CanBo[] results = searchCanBoByName(name);
		if (results.length > 0) {
			for (CanBo result : results) {
				System.out.println(result);				
			}
		} else {
			System.out.println("Không tồn tại");
		}
	}
	
	private void deleteCanBoByNameUI(Scanner scanner) {
		System.out.println("Nhập tên cán bộ cần xóa:");
		String name = scanner.nextLine();
		deleteAllCanBoByName(name);
	}

	private CanBo addCanBo(CanBo newCanBo) {
		canBoList = ArrayUtils.add(canBoList, newCanBo);
		return newCanBo;
	}

	private CanBo[] searchCanBoByName(String name) {
		CanBo[] searchResults = new CanBo[] {};
		for (CanBo canBo : canBoList) {
			if (canBo.getFullName().equals(name)) {
				searchResults = ArrayUtils.add(searchResults, canBo);
			}
		}
		return searchResults;
	}

	private void getCanBoListInfo() {
		if (canBoList.length > 0) {
			System.out.println("Danh sách cán bộ:");
			for (CanBo canBo : canBoList) {
				System.out.println(canBo);
			}
		} else {
			System.out.println("Không có cán bộ");
		}
	}
	
	private void deleteAllCanBoByName(String name) {
		int[] indexes = new int[] {};
		for (int i = 0; i < canBoList.length; i++) {
			CanBo canBo = canBoList[i];
			if (canBo.getFullName().equals(name)) {
				indexes = ArrayUtils.add(indexes, i);
			}
		}
		if (indexes.length > 0) {
			canBoList = ArrayUtils.removeAll(canBoList, indexes);
			System.out.println("Xóa thành công");
		} else {
			System.out.println("Cán bộ không tồn tại");
		}
	}

//	Question 3 (Optional): constructor inheritance
//		Tạo class abstract Person gồm các property name và tạo constructor có
//		1 parameter name
//		Tạo class abstract Student kế thừa Person gồm các property id, name
//		và tạo constructor có 2 parameter id, name
//		Tạo class HighSchoolStudent kế thừa Student bao gồm các property id,
//		name, clazz (Lớp đang học), desiredUniversity (trường đại học mong
//		muốn vào) và tạo constructor có 4 parameter id, name, clazz,
//		desiredUniversity.
//		Hãy khởi tạo Object HighSchoolStudent với các giá trị: id = 1, name =
//		"Nam", clazz = "Chuyên Văn", desiredUniversity = "Đại học công
//		nghệ"
	public void question3() {
		System.out.println("\n-- Question 3:");
	}

//	Question 4 (Optional):
//		Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi
//		tài liệu gồm có các thuộc tính sau: Mã tài liệu(Mã tài liệu là duy nhất),
//		Tên nhà xuất bản, số bản phát hành.
//		Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
//		Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành.
//		Các báo cần quản lý thêm: Ngày phát hành.
//		Xây dựng chương trình để quản lý tài liệu (QLTV) cho thư viện một
//		cách hiệu quả.
//		Xây dựng lớp QuanLySach có các chức năng sau
//		a) Thêm mới tài liêu: Sách, tạp chí, báo.
//		b) Xoá tài liệu theo mã tài liệu.
//		c) Hiện thị thông tin về tài liệu.
//		d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
//		e) Thoát khỏi chương trình.
	public void question4() {
		System.out.println("\n-- Question 4:");
	}
}
