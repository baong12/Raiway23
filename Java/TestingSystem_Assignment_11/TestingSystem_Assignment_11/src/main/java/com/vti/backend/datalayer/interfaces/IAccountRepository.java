package com.vti.backend.datalayer.interfaces;

import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {
	/**
	 * Get the list of accounts in database.
	 * 
	 * @return list of accounts
	 * @throws Exception
	 */
	public List<Account> getListAccounts() throws Exception;

	/**
	 * Create an account in database.
	 * 
	 * @param account the account to be created
	 * @return affected row count
	 * @throws Exception
	 */
	public int createAccount(Account account) throws Exception;

	/**
	 * Get an account in database by id.
	 * 
	 * @param id the id of account
	 * @return null if account doesn't exist
	 * @throws Exception
	 */
	public Account getAccountById(int id) throws Exception;

	/**
	 * Check if an account exists in database.
	 * 
	 * @param id the id of account
	 * @return true if account exists
	 * @throws Exception
	 */
	public boolean isAccountExists(int id) throws Exception;

	/**
	 * Update an account in database by id.
	 * 
	 * @param id      the id of account
	 * @param account the account to be updated
	 * @return affected row count
	 * @throws Exception
	 */
	public int updateAccountById(int id, Account account) throws Exception;

	/**
	 * Delete an account in database by id.
	 * 
	 * @param id the id of account
	 * @return affected row count
	 * @throws Exception
	 */
	public int deleteAccountById(int id) throws Exception;
}
