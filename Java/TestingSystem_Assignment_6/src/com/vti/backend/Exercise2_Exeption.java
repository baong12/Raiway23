package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.ScannerUtils;
import com.vti.entity.enums.PositionName;

public class Exercise2_Exeption {
	private Department[] depList;

//	Question 1: try…catch…finally
//		Hãy xử lý exception cho VD trên, khi bị lỗi thì sẽ in ra text "cannot
//		divide 0"
	public void question1() {
		float result = divide(7, 0);
		System.out.println(result);
	}

	private float divide(int a, int b) {
		float result = 0;
		try {
			result = a / b;
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by 0");
		}
		
		for (var name : PositionName.values()) {
			name.getClass();
		}
		
		return result;
	}

//	Question 2: tiếp tục Question 1
//		Sau khi thực hiện xong method divide dù có lỗi hay không sẽ in ra text
//		"divide completed!"
	public void question2() {
		float result = divide2(7, 0);
		System.out.println(result);
	}

	public float divide2(int a, int b) {
		float result = 0;
		try {
			result = a / b;
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by 0");
		} finally {
			System.out.println("Divide completed!");
		}
		return result;
	}

//	Question 3: Hãy xử lý exception cho VD trên và in ra thông tin lỗi.
	public void question3() {
		int[] numbers = { 1, 2, 3 };
		try {
			System.out.println(numbers[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index vượt quá độ dài mảng");
		}
	}

//	Question 4:
//		Tạo 1 array departments gồm 3 phần tử
//		Sau đó viết 1 method getIndex(int index) để lấy thông tin phần tử thứ
//		index trong array departments. Nếu index vượt quá length lấy ra thì sẽ
//		in ra text "Cannot find department."	
	public void question4() {
		depList = new Department[3];
		depList[0] = new Department("Ke toan");
		depList[1] = new Department("Sales");
		depList[2] = new Department("Ki thuat");

		getDepInfoByIndex(0);
		getDepInfoByIndex(10);
	}

	private void getDepInfoByIndex(int index) {
		try {
			System.out.println(depList[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Cannot find department");
		}
	}

//	Question 5:
//		Tạo 1 method inputAge() và trả về 1 số int.
//		Trong method hãy cài đặt như sau:
//		B1: Sau đó dùng scanner để nhập vào 1 số
//		B2: Check exeption
//		Nếu người dùng nhập vào 1 số thì return về số đó
//		Nếu người dùng không nhập vào 1 số thì sẽ in ra dòng
//		text "wrong inputing! Please input an age as int, input
//		again."
//		Nếu người dùng không nhập vào 1 số < 0 thì sẽ in ra
//		dòng text "Wrong inputing! The age must be greater
//		than 0, please input again."
//		B3: hãy demo trong method main()	
	public void question5() {
		System.out.println("Nhập tuổi:");
		int age = inputAge_goiy();
//		int age = inputAge();
		System.out.println("Tuổi bạn vừa nhập: " + age);
	}

	private int inputAge() {
		int age = 0;
		Scanner scanner = new Scanner(System.in);
		try {
			age = scanner.nextInt();
			if (age < 0) {
				age = 0;
				System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
			}
		} catch (java.util.InputMismatchException e) {
			System.out.println("wrong inputing! Please input an age as int, input again.");
		}
		scanner.close();
		return age;
	}
	
	private int inputAge_goiy() {
		int age = 0;
		Scanner scanner = new Scanner(System.in);
		try {
			String input = scanner.nextLine();
			age = Integer.parseInt(input);
			if (age < 0) {
				age = 0;
				System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
			}
		} catch (NumberFormatException e) {
			System.out.println("wrong inputing! Please input an age as int, input again.");
		}
		scanner.close();
		return age;
	}
	
//	Question 6: Tiếp tục Question 5
//		Sửa lại method inputAge() như sau:
//		Tại B2 của Question 5, Nếu người dùng không nhập vào 1 số thì sẽ in
//		ra dòng text "wrong inputing! Please input an age as int, input again.",
//		đồng thời yêu cầu người dùng nhập lại
//		Gợi ý: sử dụng while	
	public void question6() {
		System.out.println("Nhập tuổi:");
		int age = inputAge6();
		System.out.println("Tuổi bạn vừa nhập: " + age);
	}
	
	private int inputAge6() {
		int age = -1;
		Scanner scanner = new Scanner(System.in);
		boolean isOk = false;
		while (isOk == false) {
			try {
				String input = scanner.nextLine();
				age = Integer.valueOf(input);
				if (age < 0) {
					System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
				}
			} catch (NumberFormatException e) {
				System.out.println("wrong inputing! Please input an age as int, input again.");
			}
			isOk = age >= 0 ? true : false;
		}
		scanner.close();
		return age;
	}
	
//	Question 7: làm tương tự câu 6
//		Tạo 1 class ScannerUtils, trong class sẽ tạo 1 method inputInt() chuyên
//		để nhập dữ liệu dạng int như age, id, …
//		Gợi ý: inputInt() sẽ có parameter là String errorMessage để người dùng
//		có thể tự điền được errorMessage vào
	public void question7() {
		Scanner scanner = new Scanner(System.in);
		ScannerUtils su = new ScannerUtils(scanner);
		System.out.println("Nhập thử 1 số nguyên đi:");
		int num = su.inputInt("Có chắc là số nguyên không vậy? Nhập lại đi bạn:");
		System.out.println("Số vừa nhập: " + num);
	}
	
//	Question 8: làm tương tự câu 7
//		Làm tương tự câu 7 với các method inputFloat(), inputDouble(),
//		inputString()
//		Riêng với inputString() thì không cần phải handling exception
	public void question8() {
		Scanner scanner = new Scanner(System.in);
		ScannerUtils su = new ScannerUtils(scanner);
		
		System.out.println("Nhập thử 1 số float đi:");
		float numFloat = su.inputFloat("Có chắc là float không vậy? Nhập lại đi bạn:");
		System.out.println("Số vừa nhập: " + numFloat);
		
		System.out.println("Nhập thử 1 số double đi:");
		double numDouble = su.inputDouble("Có chắc là double không vậy? Nhập lại đi bạn:");
		System.out.println("Số vừa nhập: " + numDouble);
		
		System.out.println("Nhập thử 1 chuỗi đi:");
		String str = su.inputString();
		System.out.println("Chuỗi vừa nhập: \"" + str + "\"");
	}
	
//	Question 9:
//		Sử dụng ScannerUtils vừa tạo để nhập thông tin cho Department,
//		Position với điều kiện khi khởi tạo object sẽ yêu cầu nhập vào thông
//		tin luôn trong constructor (VD như hình dưới)
	public void question9() {
		Scanner scanner = new Scanner(System.in);
		ScannerUtils scUtils = new ScannerUtils(scanner);
		
		System.out.println("Tạo phòng ban");
		Department dep = new Department(scUtils);
		System.out.println(dep);
		
		System.out.println("Tạo chức vụ");
		Position pos = new Position(scUtils);
		System.out.println(pos);
		
//		scanner.close();
//		scUtils.scanner.close();
	}
	
//	Question 10: làm giống bài 9
//		Sử dụng ScannerUtils để nhập thông tin cho Group
//		Khi tạo các property array accounts thì hỏi người dùng xem, bạn có
//		muốn thêm accounts hay không, nếu người dùng đồng ý thì sẽ nhập
//		thông tin account
//		(với mỗi thông tin Account nhập vào ta sẽ tạo Object mới)
	public void question10() {
		System.out.println("Tạo nhóm");
		Group group = new Group(); 
		System.out.println(group);
	}
}
