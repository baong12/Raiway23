package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "DepartmentID")
@Entity
@Table(name = "DetailDepartment")
public class DetailDepartment extends Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "AddressID")
	@JsonIgnoreProperties("detailDepartment")
	private Address address;
	
	@Column(name = "EmulationPoint")
	private Short emulationPoint;

	public DetailDepartment(String name, Short totalMember, Address address, Short emulationPoint) {
		this.address = address;
		this.emulationPoint = emulationPoint;
	}
}
