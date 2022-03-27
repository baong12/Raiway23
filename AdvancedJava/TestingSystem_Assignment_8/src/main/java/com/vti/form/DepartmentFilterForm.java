package com.vti.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentFilterForm {
	
	private Integer minId;
	
	private Integer maxId;
	
	private Integer minTotalMember;
	
	private Integer maxTotalMember;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minCreatedDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxCreatedDate;

	private Integer minYear;
	
	private Integer maxYear;
	
	private Department.Type type;
	
	private Integer minAccountCount;
	
	private Integer maxAccountCount;
}

