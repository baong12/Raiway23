package com.vti.entity;

import com.vti.backend.enums.TypeName;

public class TypeQuestion {
	private byte id;
	private TypeName name;

	public TypeQuestion() {
	}

	/**
	 * @return the id
	 */
	public byte getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(byte id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public TypeName getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(TypeName name) {
		this.name = name;
	}
}