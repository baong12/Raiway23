package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.Bachelor;
import com.vti.entity.Engineer;
import com.vti.entity.Student;
import com.vti.utils.JDBCUtils;

public class StudentRepository implements IStudentRepository {

	@Override
	public int createEngineer(Engineer engineer) throws SQLException {
		String sql = "INSERT INTO student(`fulll_name`, `phone`, `email`, `password`, `number_of_graduation_thesis`, `type_id`) VALUES "
				+ "(?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setString(1, engineer.getFullName());
		preparedStatement.setString(2, engineer.getPhone());
		preparedStatement.setString(3, engineer.getEmail());
		preparedStatement.setString(4, engineer.getPassword());
		preparedStatement.setInt(5, engineer.getNumberOfGraduationProject());
		preparedStatement.setInt(6, 1);
		return preparedStatement.executeUpdate();
	}

	@Override
	public int createBachelor(Bachelor bachelor) throws SQLException {
		String sql = "INSERT INTO student(`fulll_name`, `phone`, `email`, `password`, `type_of_graduation_thesis`, `type_id`) VALUES "
				+ "(?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setString(1, bachelor.getFullName());
		preparedStatement.setString(2, bachelor.getPhone());
		preparedStatement.setString(3, bachelor.getEmail());
		preparedStatement.setString(4, bachelor.getPassword());
		preparedStatement.setString(5, bachelor.getTypeOfGraduationThesis());
		preparedStatement.setInt(6, 2);
		return preparedStatement.executeUpdate();
	}

	@Override
	public boolean login(Student student) throws SQLException {
		String sql = "SELECT * FROM student WHERE password = ? AND email = ?";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setString(1, student.getPassword());
		preparedStatement.setString(2, student.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

}
