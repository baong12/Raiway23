package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table(name = "`account`")
@NoArgsConstructor
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@NonNull
	@Column(name = "Email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "Username", length = 50, nullable = false, unique = true)
	private String username;

	@Column(name = "FirstName", length = 50, nullable = false)
	private String firstName;

	@Column(name = "LastName", length = 50, nullable = false)
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "DepartmentID")
//	@JsonIgnoreProperties("accounts")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "PositionID")
//	@JsonIgnoreProperties("accounts")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "SalaryID")
//	@JsonIgnoreProperties("accounts")
	private Salary salary;
	
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public Account(@NonNull String email, String username, String firstName, String lastName, Department department,
			Position position, Salary salary, Date createDate) {
		this.email = email;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.position = position;
		this.salary = salary;
		this.createDate = createDate;
	}
}
