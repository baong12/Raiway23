package com.vti.entity;

import java.util.Date;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class Group {
	public int id;
	public String name;
	public Account creator;
	public Date createDate;
	public Account[] accounts;

	public Group() {
		Scanner scanner = new Scanner(System.in);
		ScannerUtils scannerUtils = new ScannerUtils(scanner);
		System.out.println("Nhập id:");
		this.id = scannerUtils.inputInt("Dữ liệu vừa nhập không phải int, mời nhập lại:");
		
		System.out.println("Nhập tên nhóm:");
		this.name = scannerUtils.inputString();
		
		System.out.println("Nhập username người tạo nhóm:");
		this.creator = new Account(0, null, scannerUtils.inputString(), null, null);
		this.createDate = new Date();
		
		this.accounts = new Account[] {};
		boolean isOk = false;
		while (isOk == false) {
			System.out.println("Bạn có muốn thêm accounts hay không? \n1-có, 2-không");
			int select = scannerUtils.inputInt("Bạn cần nhập số nguyên, mời nhập lại:");
			if (select != 1) {
				isOk = true;
			} else {
				System.out.println("Nhập username của account:");
				Account newAcc = new Account(0, null, scannerUtils.inputString(), null, null);
				this.accounts = ArrayUtils.add(this.accounts, newAcc);
				System.out.println("Nhập thành công \n" + newAcc.username + "\"");
			}
		}
	}

	public Group(String groupName, Account creator, Account[] accounts, Date createDate) {
		super();
		this.name = groupName;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = accounts;
	}

	public Group(String groupName, Account creator, String[] usernames, Date createDate) {
		super();
		this.name = groupName;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = new Account[usernames.length];
		for (int i = 0; i < usernames.length; i++) {
			Account acc = new Account();
			acc.username = usernames[i];
			this.accounts[i] = acc;
		}
	}

	@Override
	public String toString() {
		String output = "";
		output += "Group [id=" + id + ", name=" + name + ", creator=" + creator + ", createDate=" + createDate + ",";
		output += "\naccounts=";
		if (accounts != null) {
			for (Account account : accounts) {
				output += "\n\t" + account;
			}
		} else {
			output += "null";
		}
		output += "\n]";
		return output;
	}
}