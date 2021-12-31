package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.backend.datalayer.interfaces.IDepartmentRepository;
import com.vti.entity.Department;
import com.vti.utils.JDBCUtils;

public class DepartmentRepository implements IDepartmentRepository {
	public Department getDepartmentById(int id) throws SQLException {
		Department result = null;
		String sql = "SELECT * FROM department WHERE department_id = ?";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);

		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			String name = resultSet.getString("department_name");
			result = new Department(id, name);
		} else {
			System.out.println("Cannot find department which has id = " + id);
		}

		return result;
	}
}
