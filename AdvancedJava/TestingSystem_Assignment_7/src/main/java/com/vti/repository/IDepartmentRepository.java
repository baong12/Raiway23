package com.vti.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vti.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

	@Query("SELECT d FROM Department d WHERE name LIKE %?1%")
	Page<Department> findByName(String name, Pageable pageable);

	boolean existsByName(String name);
}
