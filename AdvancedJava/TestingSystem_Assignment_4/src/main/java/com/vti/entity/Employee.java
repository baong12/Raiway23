/**
 * 
 */
package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @description This class is
 * @author baong
 * @create_date Feb 27, 2022
 * @version 1.0
 * 
 */
@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "employee_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 

	@Column(name = "full_name", length = 45, nullable = false)
	private String fullName;
	
	@Column(name = "email", length = 45, nullable = false, unique = true)
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", email=" + email + "]";
	}
}
