package com.vti.backend.datalayer.interfaces;

import com.vti.entity.Department;

public interface IDepartmentRepository {
	public Department getDepartmentById(int id) throws Exception;
}
