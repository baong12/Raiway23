package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Entity
@Table(name = "Manager")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Manager extends Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NonNull
	@Column(name = "ManagementNumberOfYear", nullable = false)
	private Short managementNumberOfYear;
}
