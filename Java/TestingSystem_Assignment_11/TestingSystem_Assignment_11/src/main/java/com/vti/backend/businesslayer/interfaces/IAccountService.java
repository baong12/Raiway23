package com.vti.backend.businesslayer.interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountService {
	/**
	 * Get the list of accounts in database.
	 * 
	 * @return list of accounts
	 * @throws SQLException
	 * @throws ParseException
	 */
	public List<Account> getListAccounts() throws Exception;

	/**
	 * Create an account in database.
	 * 
	 * @param account the account to be created
	 * @return affected row count
	 * @throws SQLException
	 */
	public int createAccount(Account account) throws Exception;

	/**
	 * Get an account in database by id.
	 * 
	 * @param id the id of account
	 * @return null if account doesn't exist
	 * @throws SQLException
	 * @throws ParseException
	 */
	public Account getAccountById(int id) throws Exception;

	/**
	 * Check if an account exists in database.
	 * 
	 * @param id the id of account
	 * @return true if account exists
	 * @throws SQLException
	 */
	public boolean isAccountExists(int id) throws Exception;

	/**
	 * Update an account in database by id.
	 * 
	 * @param id      the id of account
	 * @param account the account to be updated
	 * @return affected row count
	 * @throws SQLException
	 * @throws Exception    Cannot find account with given id
	 */
	public int updateAccountById(int id, Account account) throws Exception;

	/**
	 * Delete an account in database by id.
	 * 
	 * @param id the id of account
	 * @return affected row count
	 * @throws SQLException
	 * @throws Exception    Cannot find account with given id
	 */
	public int deleteAccountById(int id) throws Exception;
}
