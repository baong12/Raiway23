package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.vti.entity.MyException;
import com.vti.entity.Student;
import com.vti.utils.IOManager;
import com.vti.utils.LogUtils;
import com.vti.utils.ScannerUtils;

public class Exercise5 {
//	Question 1: Tạo class Student có property id, name.
//		a) Sau đó khởi 3 instance từ console (sử dụng ScannerUtils)
//		b) Write 3 student này ra file tên là StudentInformation.txt
//		c) Sau đó đọc thông tin file StudentInformation.txt và in ra màn hình
	public static void question1() {
		System.out.println("--- Question 1:");
		Student[] students = new Student[3];
		ScannerUtils.initScanner();
		for (int i = 0; i < students.length; i++) {
			System.out.println("Student thứ " + (i + 1));
			System.out.println("Nhập id:");
			int id = ScannerUtils.inputInt("Dữ liệu sai, mời nhập lại:");
			System.out.println("Nhập tên:");
			String name = ScannerUtils.inputString();
			students[i] = new Student(id, name);
		}
		
		String output = "";
		for (int i = 0; i < students.length; i++) {
			output += "Student " + (i + 1) + "\n"
					+ "\tId: " + students[i].getId() + "\n"
					+ "\tHọ và tên: " + students[i].getName() + "\n"
					+ "\n";
		}
		
		IOManager.writeFile("StudentInformation.txt", false, output);
		String content = IOManager.readFile("StudentInformation.txt");
		System.out.println(content);
	}
	
//	Question 2: Tạo LogUtils (sử dụng write Object Exception)
//		Tạo 1 custom Exception Object, sau đó tại hàm main sẽ bắt exception
//		ko mong muốn và lưu thông tin Exception.ser file
//		Các bước làm sẽ như sau:
//		B1: Tạo 1 object MyException sẽ extends Exception, trong
//		MyException sẽ chứa các thông tin như: message, reason, StackTrace,
//		time (thời gian bị Exception), …
//		B2: Sau đó tạo class LogUtils có 1 vài method như sau:
//		1. void writeLog (String message, String reason, StackTrace,
//		Datetime time) (gợi ý: sử dụng IOManager ở trên để write file)
//		2. void writeLog (MyException exception)
//		B3: đặt try catch ở method main() hoặc ở bất kỳ chỗ nào muốn lưu lại
//		thông tin exception
//		B4: Tạo method để đọc thông tin trong file Exception và in ra màn
//		hình
//		B5: Demo chương trình
	public static void question2() {
		System.out.println("--- Question 2:");
		Object obj = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\baong\\Desktop\\student.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			obj = objectInputStream.readObject();
			fileInputStream.close();
			objectInputStream.close();
		} catch (IOException e) {
			MyException myEx = new MyException(e.getMessage(), e, e.getStackTrace(), new Date());
			LogUtils.writeLog(myEx);
		} catch (ClassNotFoundException e) {
			MyException myEx = new MyException(e.getMessage(), e, e.getStackTrace(), new Date());
			LogUtils.writeLog(myEx);
		}
		System.out.println(obj);
	}
}
