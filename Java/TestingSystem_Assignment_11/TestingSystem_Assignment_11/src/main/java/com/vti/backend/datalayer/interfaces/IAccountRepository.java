package com.vti.backend.datalayer.interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Group;

public interface IAccountRepository {
	/**
	 * Get the list of accounts in database.
	 * 
	 * @return list of accounts
	 * @throws SQLException
	 * @throws ParseException
	 */
	public List<Account> getListAccounts() throws SQLException, ParseException;

	/**
	 * Get the list of groups that this account belongs to.
	 * 
	 * @param id the id of account
	 * @return list of groups
	 * @throws SQLException
	 */
	public List<Group> getGroupListByAccountId(int id) throws SQLException;

	/**
	 * Create an account in database.
	 * 
	 * @param account the account to be created
	 * @return affected row count
	 * @throws SQLException
	 */
	public int createAccount(Account account) throws SQLException;

	/**
	 * Get an account in database by id.
	 * 
	 * @param id the id of account
	 * @return null if account doesn't exist
	 * @throws SQLException
	 * @throws ParseException
	 */
	public Account getAccountById(int id) throws SQLException, ParseException;

	/**
	 * Check if an account exists in database.
	 * 
	 * @param id the id of account
	 * @return true if account exists
	 * @throws SQLException
	 */
	public boolean isAccountExists(int id) throws SQLException;

	/**
	 * Update an account in database by id.
	 * 
	 * @param id      the id of account
	 * @param account the account to be updated
	 * @return affected row count
	 * @throws SQLException
	 * @throws Exception    Cannot find account with given id
	 */
	public int updateAccountById(int id, Account account) throws SQLException, Exception;

	/**
	 * Delete an account in database by id.
	 * 
	 * @param id the id of account
	 * @return affected row count
	 * @throws SQLException
	 * @throws Exception    Cannot find account with given id
	 */
	public int deleteAccountById(int id) throws SQLException, Exception;
}
