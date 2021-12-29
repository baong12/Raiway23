package com.vti.backend.presentationlayer;

import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.interfaces.IAccountService;
import com.vti.backend.presentationlayer.validation.IValidator;
import com.vti.backend.presentationlayer.validation.Validator;
import com.vti.entity.Account;

public class AccountController {
	private IAccountService accountService = new AccountService();
	
	public List<Account> getListAccounts() throws Exception {
		return accountService.getListAccounts();
	}

	public int createAccount(Account account) throws Exception {
		IValidator validator = new Validator();
		try {
			validator.validateEmail(account.getEmail());
		} catch (Exception e) {
			throw new Exception("Email is invalid", e);
		}
		return accountService.createAccount(account);
	}

	public Account getAccountById(int id) throws Exception {
		return accountService.getAccountById(id);
	}

	public boolean isAccountExists(int id) throws Exception {
		return accountService.isAccountExists(id);
	}

	public int updateAccountById(int id, Account account) throws Exception {
		return accountService.updateAccountById(id, account);
	}

	public int deleteAccountById(int id) throws Exception {
		return accountService.deleteAccountById(id);
	}
}
