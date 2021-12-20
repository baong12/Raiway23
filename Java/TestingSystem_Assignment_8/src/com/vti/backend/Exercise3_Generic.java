package com.vti.backend;

import com.vti.entity.generic.Employee;
import com.vti.entity.generic.MyMap;
import com.vti.entity.generic.Phone;
import com.vti.entity.generic.Staff;
import com.vti.entity.generic.Student;

public class Exercise3_Generic {
//	Question 1: T generic (class)
//	Tạo class student có property id, name (trong đó id của student có thể
//	là int, long, float)
//	a) Tạo đối tượng student có id là int
//	b) Tạo đối tượng student có id là float
//	c) Tạo đối tượng student có id là double
	public static void question1() {
		System.out.println("--- Question 1:");
		Student<Integer> studentInt = new Student<Integer>(1, "Nguyễn Văn Int");
		Student<Float> studentFloat = new Student<Float>(1.0f, "Nguyễn Văn Float");
		Student<Double>	studentDouble = new Student<Double>(2.0d, "Nguyễn Văn Double");
		System.out.println(studentInt);
		System.out.println(studentFloat);
		System.out.println(studentDouble);
	}

//	Question 2: T generic (method)
//	Tạo method để in ra thông tin nhập vào (parameter)
//	(parameter có thể là họ và tên, hoặc student, hoặc int)
//	Gợi ý: tạo method print(T a) và cài đặt system out (a) ra
//	Demo chương trình với print(student), print(4), print(4.0)
	public static void question2() {
		System.out.println("--- Question 2:");
		print(new Student<Integer>(1, "Nguyễn"));
		print(4);
		print(5.0f);
	}
	
	private static <T> void print(T obj) {
		System.out.println(obj);
	}

//	Question 4: E generic
//	Tạo 1 array int, 1 array float, 1 array long, 1 array double
//	Tạo 1 method có parameter là array và in ra các số trong array đó
	public static void question4() {
		System.out.println("--- Question 4:");
		Integer[] intArray = { 1, 2, 3, 4 };
		Float[] floatArray = { 1.0f, 3.0f, 5.0f, 7.0f };
		Double[] doubleArray = { 2.0d, 2.5d, 3.0d, 3.5d };
		System.out.println("In ra array int");
		printArray(intArray);
		System.out.println("In ra array float");
		printArray(floatArray);
		System.out.println("In ra array double");
		printArray(doubleArray);
	}
	
	private static <T> void printArray(T[] array) {
		if (array == null) {
			return;
		}
		for (T element : array) {
			System.out.println(element);
		}
	}
	
//	Question 5: E generic
//	Tạo 1 class Employee có property id, name, salaries với salaries là
//	lương các tháng của Employee đó và là 1 array có data type có thể là
//	int, long, float.
//	Viết method trong Employee để in ra thông tin của Employee bao gồm
//	id, name, salaris.
//	Viết method trong Employee để in ra thông tin tháng lương cuối cùng
//	của Employee
//	a) Hãy tạo chương trình demo với Employee có salaries là
//	datatype int
//	b) Hãy tạo chương trình demo với Employee có salaries là
//	datatype float
//	c) Hãy tạo chương trình demo với Employee có salaries là
//	datatype double
	public static void question5() {
		System.out.println("--- Question 5:");
		Employee<Integer> salaryMan1 = new Employee<Integer>(1, "Nguyễn Văn Lương", new Integer[] { 
				1000, 2000, 3000 
		});
		Employee<Float> salaryMan2 = new Employee<Float>(2, "Ngô Bá Lương", new Float[] {
				1500f, 2000f, 2500f
		});
		Employee<Long> salaryMan3 = new Employee<Long>(3, "Phạm Hoàng Lương", new Long[] {
				2000l, 4000l, 6000l
		});

		System.out.println(salaryMan1);
		salaryMan1.printLastSalary();
		System.out.println(salaryMan2);
		salaryMan2.printLastSalary();		
		System.out.println(salaryMan3);
		salaryMan3.printLastSalary();
	}
	
//	Question 6: K & V generic
//	Tạo 1 class có tên là MyMap, lưu dữ liệu theo dạng key, value
//	Tạo các method
//	a) GetValue()
//	b) getKey ()
//	Viết chương trình demo: tạo 1 object Student có key là Mã sinh viên
//	và value là tên của sinh viên đó
	public static void question6() {
		System.out.println("--- Question 6:");
		MyMap<Integer, String> map = new MyMap<Integer, String>(1, "Nguyễn Văn An");
		Student<Integer> student = new Student<Integer>(map.getKey(), map.getValue());
		System.out.println(student);
	}
	
//	Question 7: K & V generic
//	Tạo 1 class có tên là Phone, lưu dữ liệu theo dạng key, value (extends
//	MyMap)
//	Với key là email hoặc là số thứ tự hoặc là tên người sử dụng
//	Với value là số điện thoại
//	Tạo các method
//	a) GetPhoneNumber()
//	b) getKey ()
//	Viết chương trình demo với
//	a) key là email
//	b) key là số thứ tự
//	c) key là tên của người sử dụng
	public static void question7() {
		System.out.println("--- Question 7:");
		Phone<String, String> emailKeyPhone = new Phone<String, String>("a.nguyen@gmail.com", "090-8877-6655");
		Phone<Integer, String> idKeyPhone = new Phone<Integer, String>(1, "0123-456-789");
		Phone<String, String> nameKeyPhone = new Phone<String, String>("Nguyễn Văn A", "080-9876-1234");
		System.out.println(emailKeyPhone);
		System.out.println(idKeyPhone);
		System.out.println(nameKeyPhone);
	}
	
//	Question 8: K & V generic
//	Tạo 1 class có tên là Staff, lưu dữ liệu theo dạng key, value (extends
//	MyMap)
//	Với key là id của Staff (ID có thể là int, long)
//	Với value là tên của Staff
//	Tạo các method
//	a) GetId ()
//	b) getName ()
//	Viết chương trình demo
	public static void question8() {
		System.out.println("--- Question 8:");
		Staff<Integer, String> staff = new Staff<Integer, String>(1, "Salary Man");
		System.out.println(staff);
		System.out.println(staff.getId());
		System.out.println(staff.getName());
	}
}
