package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private static int moneyGroup;
	private static int numberOfCreated;
	private static final int MAX_STUDENT = 7;
	
	public static String college;

	/**
	 * @param id
	 * @param name
	 */
	public Student(int id, String name) {
		if (numberOfCreated < MAX_STUDENT) {
			this.id = id;
			this.name = name;
			moneyGroup = 0;
			numberOfCreated++;
		} else {
			System.out.println("Chỉ dược phép tạo tối đa " + MAX_STUDENT + " Student");
		}
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

	public static String getCollege() {
		return college;
	}

	public static void setCollege(String college) {
		Student.college = college;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + "]";
	}

	public void nopQuy(int amount) {
		System.out.printf("Số tiền nộp: %,d %n", amount);
		moneyGroup += amount;
		tienDu();
	}

	public void xuatQuy(int amount) {
		System.out.printf("Số tiền xuất: %,d %n", amount);
		moneyGroup -= amount;
		tienDu();
	}
	
	public void tienDu() {
		System.out.printf("Số tiền dư: %,d %n", moneyGroup);
	}

	/**
	 * @return the numberOfCreated
	 */
	public static int getNumberOfCreated() {
		return numberOfCreated;
	}
}
