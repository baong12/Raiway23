package com.vti.repository;

import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentRepository {

	public List<Department> getAllDepartments(int page, int size, String filterBy, String filter, String sortBy,
			boolean isAsc);

	public Department getDepartmentByID(int id);

	public Department getDepartmentByName(String name);

	public void createDepartment(Department department);

	public void updateDepartment(int id, String newName);

	public void updateDepartment(Department department);

	public void deleteDepartment(int id);

	public boolean isDepartmentExistsByID(int id);

	public boolean isDepartmentExistsByName(String name);

}