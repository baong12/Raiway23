package com.vti.dto;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class DepartmentDTO extends RepresentationModel<DepartmentDTO> {
	private Integer id;
	
	@NonNull
	private String name;
	
	private Integer totalMember;
	
	private Department.Type type;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;
	
	private List<AccountDTO> accounts;
	
	@Data
	@NoArgsConstructor
	public static class AccountDTO extends RepresentationModel<AccountDTO> {
		private Integer id;
		
		@NonNull
		private String username;
	}
}
