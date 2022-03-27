package com.vti.form;

import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountFilterForm {
	
	private String username;

	private String departmentName;
	
	private Department.Type departmentType;
}

