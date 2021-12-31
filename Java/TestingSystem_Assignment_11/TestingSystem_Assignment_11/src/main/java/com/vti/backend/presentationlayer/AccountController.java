package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.interfaces.IAccountService;
import com.vti.entity.Account;

public class AccountController {
	private IAccountService accountService = new AccountService();
	
	public List<Account> getListAccounts() {
		try {
			return accountService.getListAccounts();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int createAccount(Account account) {
		try {
			return accountService.createAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Account getAccountById(int id) {
		try {
			return accountService.getAccountById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean isAccountExists(int id) {
		try {
			return accountService.isAccountExists(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int updateAccountById(int id, Account account) {
		try {
			return accountService.updateAccountById(id, account);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteAccountById(int id) {
		try {
			return accountService.deleteAccountById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
