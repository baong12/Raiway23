package com.vti;

import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Leader;
import com.vti.entity.Member;
import com.vti.repository.EmployeeRepository;

public class DemoEmployee {
	public static void main(String[] args) {
		EmployeeRepository repository = new EmployeeRepository();

		System.out.println("***********GET ALL EMPLOYEES***********");

		List<Employee> employees = repository.getAllEmployees();

		for (Employee item : employees) {
			System.out.println(item);
		}

//		System.out.println("\n\n***********GET EMPLOYEE BY ID***********");
//
//		Employee employeeById = repository.getEmployeeByID(2);
//		System.out.println(employeeById);
//
//		System.out.println("\n\n***********CREATE EMPLOYEE***********");
//
//		Leader leaderCreate = new Leader();
//		leaderCreate.setEmail("bao.nguyen@gmail.com");
//		leaderCreate.setFullName("Bao Nguyen");
//		leaderCreate.setExpInYear(5);
//		repository.createEmployee(leaderCreate);
//		
//		Member memberCreate = new Member();
//		memberCreate.setEmail("johnny.depp@gmail.com");
//		memberCreate.setFullName("Johnny Depp");
//		memberCreate.setSkill("Pirate");
//		repository.createEmployee(memberCreate);
	}
}
