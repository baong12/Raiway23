package com.vti;

import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.repository.AccountRepository;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.PositionRepository;

public class DemoAccount {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();
		DepartmentRepository depRepo = new DepartmentRepository();
		PositionRepository posRepo = new PositionRepository();

		System.out.println("***********GET ALL POSITIONS***********");

		List<Account> accounts = repository.getAllAccounts();

		for (Account item : accounts) {
			System.out.println(item);
		}

		System.out.println("\n\n***********GET POSITION BY ID***********");

		Account accountById = repository.getAccountByID((short) 2);
		System.out.println(accountById);

//		System.out.println("\n\n***********CREATE POSITION***********");
//
//		Account accountCreate = new Account();
//		accountCreate.setEmail("bao.nguyen@gmail.com");
//		accountCreate.setFirstName("Bao");
//		accountCreate.setLastName("Nguyen");
//		accountCreate.setUsername("bao.nguyen");
//		Department dep = depRepo.getDepartmentByID((short) 1);
//		Position pos = posRepo.getPositionByID((short) 1); 
//		accountCreate.setDepartment(dep);
//		accountCreate.setPosition(pos);
//		repository.createAccount(accountCreate);
	}
}
