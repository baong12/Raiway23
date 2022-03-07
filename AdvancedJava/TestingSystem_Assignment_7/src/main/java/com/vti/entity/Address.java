package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "AddressID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@NonNull
	@Column(name = "AddressName", length = 100, nullable = false, unique = true)
	private String name;

	public Address(@NonNull String name) {
		this.name = name;
	}
}
