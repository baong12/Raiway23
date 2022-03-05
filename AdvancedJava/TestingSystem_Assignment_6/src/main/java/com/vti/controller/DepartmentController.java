package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping()
	public List<Department> getAllDepartments(
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size,
			@RequestParam(name = "id", required = false) String filterId,
			@RequestParam(name = "name", required = false) String filterName,
			@RequestParam(name = "address", required = false) String filterAddress,
			@RequestParam(name = "createDate", required = false) String filterCreateDate,
			@RequestParam(name = "sortBy", required = false) String sortBy) {
		boolean isAsc = true;
		String filterBy = "";
		String filter = "";
		
		page = page == null || page <= 0 ? 1 : page;
		size = size == null || size <= 0 ? 1000 : size;
		if (sortBy != null) {
			isAsc = sortBy.substring(0, 1).equals("-") ? false : true;
			sortBy = sortBy.substring(1);
		}
		if (filterId != null) {
			filterBy += "id,";
			filter += filterId + ",";
		}
		if (filterName != null) {
			filterBy += "name,";
			filter += filterName + ",";
		}
		if (filterAddress != null) {
			filterBy += "address,";
			filter += filterAddress + ",";
		}
		if (filterCreateDate != null) {
			filterBy += "createDate";
			filter += filterCreateDate;
		}
		
		return service.getAllDepartments(page, size, filterBy, filter, sortBy, isAsc);
	}

	@GetMapping(value = "/{id}")
	public Department getDepartmentByID(@PathVariable(name = "id") int id) {
		return service.getDepartmentByID(id);
	}

	@PostMapping()
	public void createDepartment(@RequestBody Department department) {
		service.createDepartment(department);
	}

	@PutMapping(value = "/{id}")
	public void updateDepartment(@PathVariable(name = "id") int id, @RequestBody Department department) {
		department.setId(id);
		service.updateDepartment(department);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") int id) {
		service.deleteDepartment(id);
	}
}
