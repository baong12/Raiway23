package com.vti.entity;

public class BankAccount {
	public String id;
	public String name;
	public Integer balance;
	
	/**
	 * @param id số tài khoản
	 * @param name tên chủ tài khoản
	 * @param balance số dư tài khoản
	 */
	public BankAccount(String id, String name, Integer balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getBalance() {
		return balance;
	}
	
	public boolean credit(Integer amount) {
		this.balance += amount;
		return true;
	}
	
	public boolean debit(Integer amount) {
		boolean canDebit = this.balance >= amount;
		if (canDebit) {
			this.balance -= amount;
		}
		
		return canDebit;
	}
	
	public boolean transferTo(BankAccount account, Integer amount) {
		boolean canTransfer = false;
		canTransfer = this.balance >= amount && account != null;
		
		if (canTransfer) {
			debit(amount);
			account.credit(amount);
		}
		
		return canTransfer;
	}
}
