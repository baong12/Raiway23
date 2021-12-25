package com.vti.entity;

import com.vti.entity.enums.PositionName;

public class Position {
	public int id;
	public PositionName name;

	/**
	 * @param id
	 * @param name
	 */
	public Position(int id, PositionName name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}
}