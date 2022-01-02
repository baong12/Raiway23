package com.vti.frontend;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.vti.backend.AccountDao;
import com.vti.backend.DepartmentDao;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.DateUtils;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

public class Program2_8 {
	public static void main(String[] args) {
		AccountDao.connectDb();
		DepartmentDao.connectDb();
		boolean isDone = false;
		while (!isDone) {
			System.out.println("\n----------- Account DAO Demo -------------");
			System.out.println("1. Get accounts list");
			System.out.println("2. Get account by ID");
			System.out.println("3. Is account username exist");
			System.out.println("4. Is account ID exist");
			System.out.println("5. Create account");
			System.out.println("6. Update account");
			System.out.println("7. Delete account");
			System.out.println("Nhập số chức năng để tiếp tục, 0 để thoát:");
			int select = ScannerUtils.inputInt();
			try {
				switch (select) {
				case 1:
					List<Account> accounts = AccountDao.getAccounts();
					for (Account account : accounts) {
						System.out.println(account);
					}
					break;
				case 2:
					System.out.println("Nhập id:");
					Account account2 = AccountDao.getAccountById(ScannerUtils.inputInt());
					System.out.println(account2);
					break;
				case 3:
					System.out.println("Nhập username:");
					boolean isExists3 = AccountDao.isAccountUsernameExists(ScannerUtils.inputString());
					System.out.println("Account " + (isExists3 ? "tồn tại" : "không tồn tại"));
					break;
				case 4:
					System.out.println("Nhập id:");
					boolean isExists4 = AccountDao.isAccountIdExists(ScannerUtils.inputInt());
					System.out.println("Account " + (isExists4 ? "tồn tại" : "không tồn tại"));
					break;
				case 5:
					System.out.println("Nhập email:");
					String email = ScannerUtils.inputString();
					System.out.println("Nhập username:");
					String username = ScannerUtils.inputString();
					System.out.println("Nhập full name:");
					String fullName = ScannerUtils.inputString();
					System.out.println("Nhập department ID:");
					Department department = new Department(ScannerUtils.inputInt(), null);
					System.out.println("Nhập position ID:");
					Position position = new Position(ScannerUtils.inputInt(), null);
					AccountDao
							.createAccount(new Account(0, email, username, fullName, department, position, new Date()));
					break;
				case 6:
					System.out.println("Nhập id:");
					int id = ScannerUtils.inputInt();
					System.out.println("Nhập email:");
					String email6 = ScannerUtils.inputString();
					System.out.println("Nhập username:");
					String username6 = ScannerUtils.inputString();
					System.out.println("Nhập full name:");
					String fullName6 = ScannerUtils.inputString();
					System.out.println("Nhập department ID:");
					Department department6 = new Department(ScannerUtils.inputInt(), null);
					System.out.println("Nhập position ID:");
					Position position6 = new Position(ScannerUtils.inputInt(), null);
					System.out.println("Nhập create date (yyyy-MM-dd)");
					Date date6 = DateUtils.getDate(ScannerUtils.inputString(), "yyyy-MM-dd");
					AccountDao.updateAccountUsername(id,
							new Account(id, email6, username6, fullName6, department6, position6, date6));
					break;
				case 7:
					System.out.println("Nhập id:");
					AccountDao.deleteAccount(ScannerUtils.inputInt());
					break;
				case 0:
				default:
					isDone = true;
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		AccountDao.closeConnection();
		JdbcUtils.disconnect();
	}
}
