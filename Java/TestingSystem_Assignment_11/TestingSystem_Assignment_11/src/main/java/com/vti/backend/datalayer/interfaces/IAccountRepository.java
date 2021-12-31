package com.vti.backend.datalayer.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {
	public List<Account> getListAccounts() throws SQLException;

	public List<Account> getListAccountsByGroupId(int id) throws SQLException;

	public int createAccount(Account account) throws SQLException;

	public Account getAccountById(int id) throws SQLException;

	public boolean isAccountExists(int id) throws SQLException;

	public int updateAccountById(int id, Account account) throws SQLException;

	public int deleteAccountById(int id) throws SQLException;

	public boolean isEmailExists(String email) throws SQLException;

	public boolean isUsernameExists(String username) throws SQLException;
}
