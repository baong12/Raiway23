package com.vti.backend.datalayer.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Group;

public interface IGroupRepository {
	public List<Group> getGroupListByAccountId(int id) throws SQLException;
}
