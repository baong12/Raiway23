package com.vti.backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vti.entity.Student;

public class Exercise1_List {
//	Question 1: List
//		Tạo 1 student có property id, name (trong đó có 3 student có name
//		trùng nhau, id sẽ là auto increment)
//		Khai báo 1 ArrayList students, sau đó
//		a) In ra tổng số phần tử của students
//		b) Lấy phần tử thứ 4 của students
//		c) In ra phần tử đầu và phần tử cuối của students
//		d) Thêm 1 phần tử vào vị trí đầu của students
//		e) Thêm 1 phần tử vào vị trí cuối của students
//		f) Đảo ngược vị trí của students
//		g) Tạo 1 method tìm kiếm student theo id
//		h) Tạo 1 method tìm kiếm student theo name
//		i) Tạo 1 method để in ra các student có trùng tên
//		j) Xóa name của student có id = 2;
//		k) Delete student có id = 5;
//		l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
//		studentCopies
	public static void question1() {
		System.out.println("--- Question 1:");
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Nguyễn Văn A"));
		students.add(new Student("Nguyễn Văn B"));
		students.add(new Student("Nguyễn Văn C"));
		students.add(new Student("Nguyễn Văn D"));
		students.add(new Student("Nguyễn Văn D"));
		students.add(new Student("Nguyễn Văn D"));
		students.add(new Student("Nguyễn Văn E"));
		students.add(new Student("Nguyễn Văn F"));
		students.add(new Student("Nguyễn Văn G"));
		students.add(new Student("Nguyễn Văn H"));
		students.add(new Student("Nguyễn Văn H"));

		System.out.println("a) In ra tổng số phần tử của students");
		System.out.println(students.size());

		System.out.println("b) Lấy phần tử thứ 4 của students");
		System.out.println(students.get(3));

		System.out.println("c) In ra phần tử đầu và phần tử cuối của students");
		System.out.println(students.get(0));
		System.out.println(students.get(students.size() - 1));

		System.out.println("d) Thêm 1 phần tử vào vị trí đầu của students");
		students.add(0, new Student("Nguyễn Kim Bảo"));
		System.out.println(students.get(0));
		
		System.out.println("e) Thêm 1 phần tử vào vị trí cuối của students");
		students.add(new Student("Bảo Nguyễn"));
		System.out.println(students.get(students.size() - 1));
		
		System.out.println("f) Đảo ngược vị trí của students");
		Collections.reverse(students);
		for (Student student : students) {
			System.out.println(student);
		}
		
		System.out.println("g) Tạo 1 method tìm kiếm student theo id");
		Student resultById = findStudentById(students, 3);
		System.out.println(resultById);
		
		System.out.println("h) Tạo 1 method tìm kiếm student theo name");
		Student[] resultByName = findStudentByName(students, "Nguyễn Văn D");
		for (Student student : resultByName) {
			System.out.println(student);
		}
		
		System.out.println("i) Tạo 1 method để in ra các student có trùng tên");
		Student[] resultSameName = findStudentsWithSameName(students);
		for (Student student : resultSameName) {
			System.out.println(student);
		}
		
		System.out.println("j) Xóa name của student có id = 2");
		students = clearNameOfStudentById(students, 2);
		for (Student student : students) {
			System.out.println(student);
		}
		
		System.out.println("k) Delete student có id = 5");
		students = deleteStudentById(students, 5);
		for (Student student : students) {
			System.out.println(student);
		}
		
		System.out.println("l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies");
		ArrayList<Student> studentCopies = new ArrayList<Student>();
		studentCopies.addAll(students);
		for (Student student : studentCopies) {
			System.out.println(student);
		}
	}

	private static List<Student> clearNameOfStudentById(List<Student> students, int id) {
		int index = -1;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		if (index >= 0) {
			students.get(index).setName("");
		}
		return students;
	}

	private static List<Student> deleteStudentById(List<Student> students, int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				students.remove(student);
				break;
			}
		}
		return students;
	}

	private static Student[] findStudentsWithSameName(List<Student> students) {
		ArrayList<Student> resultList = new ArrayList<Student>();
		// Sắp xếp theo tên -> tên giống nhau sẽ nằm ở cạnh nhau
		students.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName()); 
			}
		});
		boolean isSame = false;
		int length = students.size();
		for (int i = 0; i < length; i++) {
			Student student = students.get(i);
//			Student nextStudent = students.get(i + 1);
			Student nextStudent = i < length - 1 ? students.get(i + 1) : new Student("");
			
			if (student.getName().equals(nextStudent.getName())) {
				isSame = true;
				resultList.add(student);
			} else {
				if (isSame) {
					resultList.add(student);
				}
				isSame = false;
			}
		}
		
		Student[] result = new Student[resultList.size()];
		result = resultList.toArray(result);
		return result;
	}

	private static Student[] findStudentByName(List<Student> students, String name) {
		ArrayList<Student> resultList = new ArrayList<Student>();
		for (Student student : students) {
			if (student.getName().equals(name)) {
				resultList.add(student);
			}
		}
		Student[] result = new Student[resultList.size()];
		result = resultList.toArray(result);
		return result;
	}

	private static Student findStudentById(List<Student> students, int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

//	Question 6: Map
//		Để thay thế 1 object ta có thể tạo 1 map tên là students có key = id của
//		student , value là name của students
	public static void question6() {
		System.out.println("--- Question 6:");
		Map<Integer, String> students = new HashMap<Integer, String>();
		students.put(1, "Nguyễn Văn A");
		students.put(2, "Nguyễn Văn B");
		students.put(3, "Nguyễn Văn C");
		students.put(4, "Nguyễn Văn D");
		students.put(4, "Nguyễn Văn D");
		students.put(5, "Nguyễn Văn D");
		System.out.println(students);
	}
}
