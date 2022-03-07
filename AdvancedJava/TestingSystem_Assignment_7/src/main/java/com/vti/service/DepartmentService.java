package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	public Page<Department> getAllDepartments(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Department getDepartmentByID(Integer id) {
		return repository.findById(id).get();
	}

	public void createDepartment(Department department) {
		repository.save(department);
	}

	public void updateDepartment(Department department) {
		repository.save(department);
	}

	public void deleteDepartment(Integer id) {
		repository.deleteById(id);
	}

	public boolean isDepartmentExistsByID(Integer id) {
		return repository.existsById(id);
	}

	public Page<Department> getDepartmentByName(String name, Pageable pageable) {
		return repository.findByName(name, pageable);
	}

	public void updateDepartment(Integer id, String newName) {
		Department department = new Department(newName);
		department.setId(id.shortValue());
		repository.save(department);
	}

	public boolean isDepartmentExistsByName(String name) {
		return repository.existsByName(name);
	}
}
