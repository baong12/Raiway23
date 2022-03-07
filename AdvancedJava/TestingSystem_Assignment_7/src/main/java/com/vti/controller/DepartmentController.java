package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Department;
import com.vti.form.DepartmentForm;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping()
	public Page<Department> getAllDepartments(Pageable pageable) {
		return service.getAllDepartments(pageable);
	}

	@GetMapping(value = "/{id}")
	public Department getDepartmentByID(@PathVariable(name = "id") int id) {
		return service.getDepartmentByID(id);
	}

	@GetMapping("/name")
	public Page<Department> getDepartmentByName(
			@RequestParam(name = "name", required = false) String name,
			Pageable pageable) {
		name = name == null ? "" : name;
		return service.getDepartmentByName(name, pageable);
	}
	
	@GetMapping("/exist")
	public boolean isDepartmentExistsByName(@RequestParam(name = "name") String name) {
		return service.isDepartmentExistsByName(name);
	}
	
	@PostMapping()
	public void createDepartment(@RequestBody DepartmentForm form) {
		service.createDepartment(form.toEntity());
	}

	@PutMapping(value = "/{id}")
	public void updateDepartment(@PathVariable(name = "id") Integer id, @RequestBody DepartmentForm form) {
		Department department = form.toEntity();
		department.setId(id.shortValue());
		service.updateDepartment(department);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") Integer id) {
		service.deleteDepartment(id);
	}
}
