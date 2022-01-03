/**
 * 
 */
package com.vti.frontend;

import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.User;
import com.vti.utils.JDBCUtils;
import com.vti.utils.ScannerUtils;

/**
 * @description This class is
 * @author baong
 * @create_date Jan 2, 2022
 * @version 1.0
 * 
 */
public class Program2 {
	public static void main(String[] args) {
		UserController userController = new UserController();
		
		boolean isDone = false;
		while (!isDone) {
			System.out.println("\n---------- Quản lý Member ------------");
			System.out.println("1. Lấy thông tin member theo project");
			System.out.println("2. Đăng nhập");
			System.out.println("Chọn chức năng để tiếp tục, 0 để thoát");
			
			switch (ScannerUtils.inputInt()) {
			case 1:
				System.out.println("Nhập project id");
				int projectId = ScannerUtils.inputInt();
				List<User> users = userController.getUserListByProjectId(projectId);
				System.out.printf(" %-10s %-20s %-20s %-20s %n", "ID", "FullName", "Email", "Password");
				System.out.printf("---------------------------------------------------------------------------%n");
				for (User user : users) {
					System.out.printf(" %-10s %-20s %-20s %-20s %n", user.getId(), user.getFullName(), user.getEmail(), user.getPassword());
				}
				if (users.size() == 0) {
					System.out.println("Không có member");
				}
				break;
			case 2:
				System.out.println("Nhập email:");
				String email = ScannerUtils.inputString();
				System.out.println("Nhập password:");
				String password = ScannerUtils.inputString();
				boolean isValid = userController.loginUser(email, password);
				if (isValid) {
					System.out.println("Đăng nhập thành công");
					System.out.println("Thêm user mới:");
					System.out.println("Nhập họ tên:");
					String newFullName = ScannerUtils.inputString();
					System.out.println("Nhập email:");
					String newEmail = ScannerUtils.inputString();
					int affectedCount = userController.createUser(newFullName, newEmail);
					System.out.println("Số bản ghi đã ảnh hưởng: " + affectedCount);
				} else {
					System.out.println("Đăng nhập thất bại");
				}
				break;
			case 0:
			default:
				isDone = true;
				break;
			} 
		}
		JDBCUtils.disconnect();
		ScannerUtils.closeScanner();
	}
}
