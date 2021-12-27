package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.interfaces.IAccountService;
import com.vti.entity.Account;
import com.vti.entity.Group;

public class AccountController {
	private IAccountService accountService = new AccountService();
	
	public List<Account> getListAccounts() throws SQLException, ParseException {
		return accountService.getListAccounts();
	}
	
	public List<Group> getGroupListByAccountId(int id) throws SQLException {
		return accountService.getGroupListByAccountId(id);
	}

	public int createAccount(Account account) throws SQLException {
		return accountService.createAccount(account);
	}

	public Account getAccountById(int id) throws SQLException, ParseException {
		return accountService.getAccountById(id);
	}

	public boolean isAccountExists(int id) throws SQLException {
		return accountService.isAccountExists(id);
	}

	public int updateAccountById(int id, Account account) throws SQLException, Exception {
		return accountService.updateAccountById(id, account);
	}

	public int deleteAccountById(int id) throws SQLException, Exception {
		return accountService.deleteAccountById(id);
	}
}
