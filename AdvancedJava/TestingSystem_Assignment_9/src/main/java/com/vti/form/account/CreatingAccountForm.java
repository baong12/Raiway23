package com.vti.form.account;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.vti.validation.EmailNotExists;
import com.vti.validation.UsernameNotExists;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingAccountForm {

	@Length(max = 50, message = "Email mustn't be longer than 50 characters")
	@Email(message = "Email must have correct formant. Ex: abc@domain.com")
	@NotBlank(message = "Email mustn't be null value")
	@EmailNotExists
	private String email;

	@Length(min = 6, max = 50, message = "Username must be between 6 and 50 characters long")
	@NotBlank(message = "Username mustn't be null value")
	@UsernameNotExists
	private String username;

	@Length(max = 50, message = "FirstName mustn't be longer than 50 characters")
	@NotBlank(message = "FirstName mustn't be null value")
	private String firstName;
	
	@Length(max = 50, message = "LastName mustn't be longer than 50 characters")
	@NotBlank(message = "LastName mustn't be null value")
	private String lastName;

	@NotNull(message = "DepartmentID mustn't be null value")
	private Integer departmentId;

	@NotNull(message = "PositionID mustn't be null value")
	private Integer positionId;
	
	@NotNull(message = "SalaryID mustn't be null value")
	private Integer salaryId;
	
	@NotNull(message = "CreateDate mustn't be null value")
	private Date createDate;
}

