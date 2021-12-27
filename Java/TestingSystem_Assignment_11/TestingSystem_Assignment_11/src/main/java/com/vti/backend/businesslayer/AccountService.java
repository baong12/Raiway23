package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.backend.businesslayer.interfaces.IAccountService;
import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.interfaces.IAccountRepository;
import com.vti.entity.Account;
import com.vti.entity.Group;

public class AccountService implements IAccountService {
	private IAccountRepository accountRepository = new AccountRepository(); 
	
	@Override
	public List<Account> getListAccounts() throws SQLException, ParseException {
		return accountRepository.getListAccounts();
	}

	@Override
	public List<Group> getGroupListByAccountId(int id) throws SQLException {
		return accountRepository.getGroupListByAccountId(id);
	}

	@Override
	public int createAccount(Account account) throws SQLException {
		return accountRepository.createAccount(account);
	}

	@Override
	public Account getAccountById(int id) throws SQLException, ParseException {
		return accountRepository.getAccountById(id);
	}

	@Override
	public boolean isAccountExists(int id) throws SQLException {
		return accountRepository.isAccountExists(id);
	}

	@Override
	public int updateAccountById(int id, Account account) throws SQLException, Exception {
		return accountRepository.updateAccountById(id, account);
	}

	@Override
	public int deleteAccountById(int id) throws SQLException, Exception {
		return accountRepository.deleteAccountById(id);
	}
}
