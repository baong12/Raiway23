package com.vti.entity.generic;

import java.util.Arrays;

public class Employee<T> {
	private int id;
	private String name;
	private T[] salaries;
		
	/**
	 * @param id
	 * @param name
	 * @param salaries
	 */
	public Employee(int id, String name, T[] salaries) {
		super();
		this.id = id;
		this.name = name;
		this.salaries = salaries;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T[] getSalaries() {
		return salaries;
	}

	public void setSalaries(T[] salaries) {
		this.salaries = salaries;
	}

	public void printLastSalary() {
		if (salaries == null) {
			return;
		}
		System.out.println("Tháng lương cuối cùng:");
		if (salaries.length == 0) {
			System.out.println("Không có");
		} else {
			System.out.println(salaries[salaries.length - 1]);
		}
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salaries=" + Arrays.toString(salaries) + "]";
	}
}
