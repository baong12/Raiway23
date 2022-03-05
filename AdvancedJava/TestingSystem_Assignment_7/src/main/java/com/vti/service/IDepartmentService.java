package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Department;

public interface IDepartmentService {

	public Page<Department> getAllDepartments(Pageable pageable);

	public Department getDepartmentByID(Integer id);
	
	public Page<Department> getDepartmentByName(String name, Pageable pageable);

	public void createDepartment(Department department);

	public void updateDepartment(Integer id, String newName);
	
	public void updateDepartment(Department department);

	public void deleteDepartment(Integer id);

	public boolean isDepartmentExistsByID(Integer id);

	public boolean isDepartmentExistsByName(String name);
}
