package com.vti.backend.businesslayer.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountService {
	public List<Account> getListAccounts() throws SQLException;

	public int createAccount(Account account) throws Exception;

	public Account getAccountById(int id) throws SQLException;

	public boolean isAccountExists(int id) throws SQLException;

	public int updateAccountById(int id, Account account) throws SQLException;

	public int deleteAccountById(int id) throws SQLException;
}
