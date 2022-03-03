/**
 * 
 */
package com.vti.repository;

import java.util.List;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;

/**
 * @description This class is
 * @author baong
 * @create_date Mar 3, 2022
 * @version 1.0
 * 
 */
public interface IDepartmentRepository {
	void createDepartment(Department department);

	List<DepartmentDTO> getAllDepartments();

	List<DepartmentDTO> getAllDepartments(int pageNumber, int pageSize);

	List<DepartmentDTO> getAllDepartments(String search);

	List<DepartmentDTO> getAllDepartments(int emulationPoints);

	List<DepartmentDTO> getAllDepartments(int pageNumber, int pageSize, String search, int emulationPoints);

	int getTotalCount();

	int getTotalCount(String search);

	int getTotalCount(int emulationPoints);

	DepartmentDTO getDepartmentByID(int id);

	DepartmentDTO getDepartmentByName(String name);

	void updateDepartment(Department department);

	void deleteDepartment(int[] idies);

	void deleteDepartment(int id);

	boolean isDepartmentExistsByID(int id);

	boolean isDepartmentExistsByName(String name);
}
