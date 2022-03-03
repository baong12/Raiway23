package com.vti;

import java.util.List;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.repository.DepartmentCriteriaRepo;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.IDepartmentRepository;

public class DemoDepartmentCriteria {
	public static void main(String[] args) {
		IDepartmentRepository repository = new DepartmentCriteriaRepo();
		
//		System.out.println("\n\n***********CREATE DEPARTMENT***********");
//		Department departmentCreate = new Department();
//		departmentCreate.setName("Waiting");
//		departmentCreate.setAddress("None");
//		departmentCreate.setEmulationPoints(0);
//		repository.createDepartment(departmentCreate);
		
		System.out.println("***********GET ALL DEPARTMENTS***********");
		List<DepartmentDTO> departments = repository.getAllDepartments();
//		List<DepartmentDTO> departments = repository.getAllDepartments(1, 3);
//		List<DepartmentDTO> departments = repository.getAllDepartments("ing");
//		List<DepartmentDTO> departments = repository.getAllDepartments(40);
		for (var department : departments) {
			System.out.println(department);
		}
//
//		System.out.println("\n\n***********GET DEPARTMENT BY ID***********");
//
//		Department departmentById = repository.getDepartmentByID((short) 2);
//		System.out.println(departmentById);
//
//		System.out.println("\n\n***********GET DEPARTMENT BY NAME***********");
//
//		Department departmentByName = repository.getDepartmentByName("Marketting");
//		System.out.println(departmentByName);

//
//		System.out.println("\n\n***********UPDATE DEPARTMENT 1***********");
//
//		repository.updateDepartment((short) 3, "Security");
//
//		System.out.println("\n\n***********UPDATE DEPARTMENT 2***********");
//
//		Department departmentUpdate = new Department();
//		departmentUpdate.setId((short) 2);
//		departmentUpdate.setName("Security2");
//		repository.updateDepartment(departmentUpdate);
//
//		System.out.println("\n\n***********DELETE DEPARTMENTS***********");
//		repository.deleteDepartment((short) 2);
//
//		System.out.println("***********CHECK DEPARTMENT EXISTS BY ID***********");
//		System.out.println(repository.isDepartmentExistsByID((short) 1));
//
//		System.out.println("***********CHECK DEPARTMENT EXISTS BY NAME***********");
//		System.out.println(repository.isDepartmentExistsByName("Security"));

	}
}
