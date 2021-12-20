package com.vti.backend;

import com.vti.entity.generic.Salary;

public class Exercise4_WildCard {
//	Question 1:
//		Tạo 1 class Salary để đại diện cho datatype là các số
//		a) Hãy config class Salary như sau: Salary <N> với N phải được
//		extends từ Number.class
//		b) Tạo method để print ra salary hiện tại
	public static void question1() {
		Salary<Integer> salary1 = new Salary<Integer>(100000);
		salary1.print();
		Salary<Float> salary2 = new Salary<Float>(100000000.234f);
		salary2.print();
		Salary<Double> salaryStr = new Salary<Double>(20000.234685);
		salaryStr.print();
	}
	
//	Question 2:
//		Tạo 1 class MyNumber để đại diện cho datatype là các số
//		Hãy config class MyNumber như sau: MyNumber<N> với N phải
//		được extends từ Number.class
	
//	Question 3: T generic (method)
//		Tạo method tính max của 2 số (số nhập vào có thể là float, double, int,
//		long).
//		Demo chương trình
	public static void question3() {
		getMax(3, 5);
		getMax(3000.54f, 2000.2f);
		getMax(500342.231, 62323.2333);
	}
	private static <T extends Number> void getMax(T a, T b) {
		System.out.println(a.doubleValue() >= b.doubleValue() ? a : b);
	}
	
//	Question 4: T generic (method & class)
//		Tạo class MyMath<T> có thể làm việc được với các số int, long,
//		double và có chứa các method sau:
//		a) tính tổng của 2 số
//		b) tính tổng của 3 số
//		c) tính tổng của 4 số
//		d) tính hiệu của 2 số
//		e) hàm tính số mũ (a,b)
//		Gợi ý: sử dụng optional parameter để làm câu a,b,c.
//		Demo chương trình
//	Question 5:
//		Tạo 1 cursor như sau: ArrayList <Object> listWildcards.
//		Hãy khởi tạo đối tượng có chứa thông tin của khách hàng (mỗi thông
//		tin là 1 element) và thêm các giá trị vào trong ArrayList như:
//		a) Nguyễn Văn Nam
//		b) 30 tuổi
//		c) Hà đông, Hà nội
}
