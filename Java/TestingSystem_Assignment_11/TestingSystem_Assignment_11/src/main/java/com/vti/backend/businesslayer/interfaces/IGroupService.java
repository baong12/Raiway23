package com.vti.backend.businesslayer.interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Group;

public interface IGroupService {
	public List<Group> getListGroups() throws SQLException, ParseException;

	public List<Account> getListAccountsByGroupId(int id) throws SQLException;

	public int createGroup(Group group) throws SQLException;

	public Group getGroupById(int id) throws SQLException, ParseException;

	public boolean isGroupExists(int id) throws SQLException;

	public int updateGroupById(int id, Group group) throws SQLException, Exception;

	public int deleteGroupById(int id) throws SQLException, Exception;
}
