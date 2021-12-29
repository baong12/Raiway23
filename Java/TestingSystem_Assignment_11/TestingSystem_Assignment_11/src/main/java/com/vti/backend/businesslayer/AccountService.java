package com.vti.backend.businesslayer;

import java.util.List;

import com.vti.backend.businesslayer.interfaces.IAccountService;
import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.interfaces.IAccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {
	private IAccountRepository accountRepository = new AccountRepository(); 
	
	@Override
	public List<Account> getListAccounts() throws Exception {
		return accountRepository.getListAccounts();
	}

	@Override
	public int createAccount(Account account) throws Exception {
		return accountRepository.createAccount(account);
	}

	@Override
	public Account getAccountById(int id) throws Exception {
		return accountRepository.getAccountById(id);
	}

	@Override
	public boolean isAccountExists(int id) throws Exception {
		return accountRepository.isAccountExists(id);
	}

	@Override
	public int updateAccountById(int id, Account account) throws Exception {
		return accountRepository.updateAccountById(id, account);
	}

	@Override
	public int deleteAccountById(int id) throws Exception {
		return accountRepository.deleteAccountById(id);
	}
}
