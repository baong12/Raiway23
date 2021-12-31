package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.interfaces.IAccountService;
import com.vti.backend.businesslayer.validation.IValidator;
import com.vti.backend.businesslayer.validation.Validator;
import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.interfaces.IAccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {
	private IAccountRepository accountRepository = new AccountRepository();
	private IValidator validator = new Validator();
	
	@Override
	public List<Account> getListAccounts() throws SQLException {
		return accountRepository.getListAccounts();
	}

	@Override
	public int createAccount(Account account) throws Exception {
		validator.validateEmail(account.getEmail());
		validator.validateUsername(account.getUsername());
		if (isEmailExists(account.getEmail())) {
			throw new Exception("Email đã tồn tại");
		}
		if (isUsernameExists(account.getUsername())) {
			throw new Exception("Username đã tồn tại");
		}
		return accountRepository.createAccount(account);
	}

	private boolean isEmailExists(String email) throws SQLException {
		return accountRepository.isEmailExists(email);
	}

	private boolean isUsernameExists(String username) throws SQLException {
		return accountRepository.isUsernameExists(username);
	}

	@Override
	public Account getAccountById(int id) throws SQLException {
		return accountRepository.getAccountById(id);
	}

	@Override
	public boolean isAccountExists(int id) throws SQLException {
		return accountRepository.isAccountExists(id);
	}

	@Override
	public int updateAccountById(int id, Account account) throws SQLException {
		return accountRepository.updateAccountById(id, account);
	}

	@Override
	public int deleteAccountById(int id) throws SQLException {
		return accountRepository.deleteAccountById(id);
	}
}
