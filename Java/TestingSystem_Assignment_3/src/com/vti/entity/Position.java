package com.vti.entity;

import com.vti.backend.enums.PositionName;

public class Position {
	private byte id;
	private PositionName name;

	public Position() {
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
	public PositionName getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(PositionName name) {
		this.name = name;
	}
}