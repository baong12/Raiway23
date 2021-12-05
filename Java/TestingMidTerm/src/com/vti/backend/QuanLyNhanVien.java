package com.vti.backend;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.ScannerUtils;
import com.vti.entity.User;

public class QuanLyNhanVien {
	private User[] userList;
	private Scanner scanner;
	private ScannerUtils scUtils;

	public void thread() {
		initializeUserList(); // Khởi tạo danh sách nhân viên
		scanner = new Scanner(System.in);
		scUtils = new ScannerUtils(scanner);

		boolean isFinished = false;
		while (isFinished == false) {
			System.out.println("\n---------- Quan ly nhan vien ------------");
			System.out.println("1. In danh sách user trong hệ thống");
			System.out.println("2. Tìm kiếm user theo id");
			System.out.println("3. Xóa user theo id");
			System.out.println("4. Login");
			System.out.println("Nhập số chức năng để tiếp tục:");
			int select = scUtils.inputInt();

			switch (select) {
			case 1:
				displayAllUser();
				break;
			case 2:
				searchUserUI();
				break;
			case 3:
				deleteUserUI();
				break;
			case 4:
				loginUI();
				break;
			default:
				System.out.println("Chức năng không tồn tại. Mời nhập lại:");
				break;
			}

			System.out.println("Bắt đầu lại? 1-có, 2-không");
			if (scUtils.inputInt() != 1) {
				isFinished = true;
			}
		}
		scanner.close();
	}

	private void displayAllUser() {
		if (userList == null || userList.length == 0) {
			System.out.println("Không có user nào trong hệ thống");
			return;
		}

		System.out.printf(" %-10s %-20s %-20s %-20s %n", "Id", "FullName", "UserName", "Email");
		System.out.println("----------------------------------------------------------------------------");
		for (User user : userList) {
			System.out.printf(" %-10s %-20s %-20s %-20s %n", user.getId(), user.getFullName(), user.getUserName(),
					user.getEmail());
		}
	}

	private void searchUserUI() {
		if (userList == null || userList.length == 0) {
			System.out.println("Không có user nào trong hệ thống");
			return;
		}

		System.out.println("Nhập id của user:");
		int id = scUtils.inputInt();
		int index = searchUser(id);

		if (index >= 0) {
			User user = userList[index];
			System.out.println("Đã tìm thấy user");
			System.out.printf(" %-10s %-20s %-20s %-20s %n", "Id", "FullName", "UserName", "Email");
			System.out.println("----------------------------------------------------------------------------");
			System.out.printf(" %-10s %-20s %-20s %-20s %n", user.getId(), user.getFullName(), user.getUserName(),
					user.getEmail());
		} else {
			System.out.println("Không tìm thấy user phù hợp");
		}
	}

	private int searchUser(int id) {
		int result = -1;
		for (int i = 0; i < userList.length; i++) {
			User user = userList[i];
			if (user.getId() == id) {
				result = i;
				break;
			}
		}
		return result;
	}

	private void deleteUserUI() {
		if (userList == null || userList.length == 0) {
			System.out.println("Không có user nào trong hệ thống");
			return;
		}

		System.out.println("Nhập id của user:");
		int id = scUtils.inputInt();
		int index = searchUser(id);

		if (index >= 0) {
			deleteUser(index);
			System.out.println("Đã xóa user thành công");
		} else {
			System.out.println("Không tìm thấy user phù hợp");
		}
	}

	private void deleteUser(int index) {
		userList = ArrayUtils.remove(userList, index);
	}

	private void loginUI() {
		System.out.println("Nhập userName:");
		String userName = scUtils.inputString();
		System.out.println("Nhập password:");
		String password = scUtils.inputString();

		boolean isUserNameOk = checkUserName(userName);
		boolean isPasswordOk = checkPassword(password);

		if (!isUserNameOk || !isPasswordOk) {
			System.out.println("UserName hoặc Password không thỏa mãn!");
		} else {
			User user = login(userName, password);
			if (user == null) {
				System.out.println("Đăng nhập thất bại! UserName hoặc password không chính xác");
			} else {
				System.out.println(user.getFullName() + " đã đăng nhập thành công");
				displayFunctions(user);
			}
		}
	}

	private void displayFunctions(User user) {
		if (user instanceof Admin) {
			System.out.println("*** Danh sách chức năng trong Hệ thống ***\r\n"
					+ "=== 1. Quản trị Hệ thống ===\r\n"
					+ "=== 2. Quản lý Nhân viên ===\r\n"
					+ "=== 3. Quản lý Dự án ===");
		}
		if (user instanceof Employee) {
			System.out.println("*** Danh sách chức năng trong Hệ thống ***\r\n"
					+ "=== 1. Xem Danh sách Nhân Viên ===\r\n"
					+ "=== 2. Cập nhật Thông tin cá nhân ===");
		}
	}

	private boolean checkUserName(String userName) {
		if (userName.length() < 8) {
			return false;
		}
		
		if (upperCaseCount(userName) > 0) {
			return false;
		}
		
		return true;
	}
	
	private boolean checkPassword(String password) {
		if (password.length() < 6 || password.length() > 12) {
			return false;
		}
		
		if (upperCaseCount(password) < 1) {
			return false;
		}
		
		return true;
	}

	private int upperCaseCount(String input) {
		int upperCaseCount = 0;
		for (int i = 0; i < input.length(); i++) {
			if (Character.isLetter(input.charAt(i))) {
				String curChar = input.substring(i, i + 1);
				if (curChar.toUpperCase().equals(curChar)) {
					upperCaseCount++;
				}
			}
		}
		return upperCaseCount;
	}

	private User login(String userName, String password) {
		User result = null;
		for (User user : userList) {
			if (user.getUserName().equals(userName)) {
				if (user.getPassword().equals(password)) {
					result = user;
				}
			}
		}

		return result;
	}

	private void initializeUserList() {
		userList = new User[5];
		userList[0] = new Admin(1, "Nguyen Van A", "a.nguyen", "a.nguyen@gmail.com", "Anguyen111", "Java");
		userList[1] = new Admin(2, "Nguyen Van B", "b.nguyen", "b.nguyen@gmail.com", "Bnguyen", "SQL");
		userList[2] = new Employee(3, "Nguyen Van C", "c.nguyen", "c.nguyen@gmail.com", "Cnguyen", 2);
		userList[3] = new Employee(4, "Nguyen Van D", "d.nguyen", "d.nguyen@gmail.com", "Dnguyen", 2);
		userList[4] = new Employee(5, "Nguyen Van E", "e.nguyen", "e.nguyen@gmail.com", "Enguyen", 3);
	}

}
