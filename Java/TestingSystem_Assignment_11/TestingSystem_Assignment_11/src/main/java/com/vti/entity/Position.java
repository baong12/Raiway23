package com.vti.entity;

import com.vti.entity.enums.PositionName;

public class Position {
	private int id;
	private PositionName name;

	/**
	 * @param id
	 * @param name
	 */
	public Position(int id, PositionName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name.getPositionName() + "]";
	}
}