package com.vti.backend.datalayer;

import java.sql.SQLException;

import com.vti.entity.Bachelor;
import com.vti.entity.Engineer;
import com.vti.entity.Student;

public interface IStudentRepository {
	public int createEngineer(Engineer engineer) throws SQLException;
	
	public int createBachelor(Bachelor bachelor) throws SQLException;
	
	public boolean login(Student student) throws SQLException;
}
