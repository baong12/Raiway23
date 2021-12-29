package com.vti.backend.datalayer.interfaces;

import com.vti.entity.Position;

public interface IPositionRepository {
	public Position getPositionById(int id) throws Exception;
}
