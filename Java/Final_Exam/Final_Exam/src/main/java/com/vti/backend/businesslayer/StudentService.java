package com.vti.backend.businesslayer;

import java.sql.SQLException;

import com.mysql.cj.util.StringUtils;
import com.vti.backend.datalayer.IStudentRepository;
import com.vti.backend.datalayer.StudentRepository;
import com.vti.entity.Bachelor;
import com.vti.entity.Engineer;
import com.vti.entity.Student;

public class StudentService implements IStudentService {
	private IStudentRepository studentRepository = new StudentRepository();

	@Override
	public int createEngineer(Engineer engineer) throws SQLException {
		int number = engineer.getNumberOfGraduationProject();
		if (number < 1 || number > 5) {
			System.out.println("NumberOfGraduationProject: là số nguyên và chỉ nhận giá trị trong khoảng từ 1-5");
			return 0;
		}
		if (validateStudent(engineer) == false) {
			return 0;
		}
		return studentRepository.createEngineer(engineer);
	}

	@Override
	public int createBachelor(Bachelor bachelor) throws SQLException {
		String[] acceptableTypes = { "HTT", "MMT", "DOHOA" };
		boolean isTypeOk = false;
		for (String type : acceptableTypes) {
			if (bachelor.getTypeOfGraduationThesis().equals(type)) {
				isTypeOk = true;
				break;
			}
		}
		if (isTypeOk == false) {
			System.out.println("TypeOfGraduationThesis: chỉ chấp nhận một trong 3 giá trị (HTT, MMT, DOHOA)");
			return 0;
		}
		if (validateStudent(bachelor) == false) {
			return 0;
		}
		return studentRepository.createBachelor(bachelor);
	}

	private boolean validateStudent(Student student) {
		if (StringUtils.isNullOrEmpty(student.getFullName())) {
			System.out.println("FullName: không được để trống");
			return false;
		}
		int length = student.getPhone().length();
		if (length < 10 || length > 11) {
			System.out.println("Phone: chỉ nhập được từ 10 tới 11 số");
			return false;
		}
		if (student.getEmail().matches("[a-z0-9._]+@[a-z0-9.]+") == false) {
			System.out.println("Định dạng email không hợp lệ");
			return false;
		}
		return true;
	}

	@Override
	public boolean login(Student student) throws SQLException {
		if (student.getEmail().matches("[a-z0-9._]+@[a-z0-9.]+") == false) {
			System.out.println("Định dạng email không hợp lệ");
			return false;
		}
		int length = student.getPassword().length();
		if (length < 8 || length > 10) {
			System.out.println("Password: chỉ nhập từ 8 tới 10 ký tự");
			return false;
		}
		if (student.getPassword().matches(".*[A-Z]{1}.*") == false) {
			System.out.println("Password: có ít nhất 1 ký tự viết hoa");
			return false;
		}
		return studentRepository.login(student);
	}

}
