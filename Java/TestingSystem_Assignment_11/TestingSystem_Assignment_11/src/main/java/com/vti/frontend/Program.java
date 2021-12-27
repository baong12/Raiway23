package com.vti.frontend;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

public class Program {
	public static void main(String[] args) {
//		JdbcUtils.connect();
		AccountController accountController = new AccountController();
		boolean isDone = false;
		while (!isDone) {
			System.out.println("\n-------------- Account Controller -------------------" + "\n1. Get list of account"
					+ "\n2. Get account by ID" + "\n3. Check account exist by ID" + "\n4. Create account"
					+ "\n5. Update account by ID" + "\n6. Delete account by ID" + "\nChọn chức năng, 0 để thoát:");
			int select = ScannerUtils.inputInt();
			try {
				switch (select) {
				case 1:
					List<Account> accounts = accountController.getListAccounts();
					for (Iterator<Account> iterator = accounts.iterator(); iterator.hasNext();) {
						Account account = iterator.next();
						System.out.println(account.toString(true));
					}
					break;
				case 2:
					System.out.println("Nhập id cần tìm:");
					Account account2 = accountController.getAccountById(ScannerUtils.inputInt());
					System.out.println(account2 == null ? "Account không tồn tại." : account2.toString(true));
					break;
				case 3:
					System.out.println("Nhập id cần kiểm tra:");
					boolean isExist = accountController.isAccountExists(ScannerUtils.inputInt());
					System.out.println("Account " + (isExist ? "có" : "không") + " tồn tại.");
					break;
				case 4:
					System.out.println("Nhập username:");
					String username4 = ScannerUtils.inputString();
					System.out.println("Nhập id phòng ban:");
					int depId4 = ScannerUtils.inputInt();
					System.out.println("Nhập id chức vụ:");
					int posId4 = ScannerUtils.inputInt();
					Account account4 = new Account(0, username4 + "@gmail.com", username4, username4.replace(".", " "),
							new Department(depId4, null), new Position(posId4, null), new Date(), null);
					int affectedCount4 = accountController.createAccount(account4);
					System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedCount4);
					break;
				case 5:
					System.out.println("Nhập id cần thay đổi:");
					int id5 = ScannerUtils.inputInt();
					System.out.println("Nhập username:");
					String username5 = ScannerUtils.inputString();
					System.out.println("Nhập id phòng ban:");
					int depId5 = ScannerUtils.inputInt();
					System.out.println("Nhập id chức vụ:");
					int posId5 = ScannerUtils.inputInt();
					Account account5 = new Account(0, username5 + "@gmail.com", username5, username5.replace(".", " "),
							new Department(depId5, null), new Position(posId5, null), new Date(), null);
					int affectedCount5 = accountController.updateAccountById(id5, account5);
					System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedCount5);
					break;
				case 6:
					System.out.println("Nhập id cần xóa:");
					int affectedCount6 = accountController.deleteAccountById(ScannerUtils.inputInt());
					System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedCount6);
					break;
				case 0:
				default:
					isDone = true;
					break;
				}
			} catch (SQLException e) {
				System.out.println(JdbcUtils.SQL_EXC);
				e.printStackTrace();
			} catch (ParseException e) {
				System.out.println("Lỗi parse Date");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		JdbcUtils.disconnect();
		ScannerUtils.closeScanner();
	}
}
