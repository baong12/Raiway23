package com.vti.entity;

import com.vti.entity.enums.PositionName;

public class Position {
	public byte id;
	public PositionName name;

	public Position() {
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}
}