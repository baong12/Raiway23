package com.vti.backend.presentationlayer;

import java.sql.SQLException;

import com.vti.backend.businesslayer.IStudentService;
import com.vti.backend.businesslayer.StudentService;
import com.vti.entity.Bachelor;
import com.vti.entity.Engineer;
import com.vti.entity.Student;
import com.vti.utils.JDBCUtils;

public class StudentController {
	private IStudentService studentService = new StudentService();
	
	public int createEngineer(Engineer engineer) {
		try {
			return studentService.createEngineer(engineer);
		} catch (SQLException e) {
			System.out.println(JDBCUtils.SQL_EXC);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int createBachelor(Bachelor bachelor) {
		try {
			return studentService.createBachelor(bachelor);
		} catch (SQLException e) {
			System.out.println(JDBCUtils.SQL_EXC);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean login(Student student) {
		try {
			return studentService.login(student);
		} catch (SQLException e) {
			System.out.println(JDBCUtils.SQL_EXC);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
