package com.vti.dto;

import org.springframework.hateoas.RepresentationModel;

import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class AccountDTO extends RepresentationModel<AccountDTO> {
	private Integer id;

	@NonNull
	private String username;
	
	@NonNull
	private String departmentName;

	private Department.Type departmentType;
}
