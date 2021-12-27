package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.backend.businesslayer.interfaces.GroupService;
import com.vti.backend.businesslayer.interfaces.IGroupService;
import com.vti.entity.Account;
import com.vti.entity.Group;

public class GroupController {
	private IGroupService groupService = new GroupService();
	
	public List<Group> getListGroups() throws SQLException, ParseException {
		return groupService.getListGroups();
	}

	public List<Account> getListAccountsByGroupId(int id) throws SQLException {
		return groupService.getListAccountsByGroupId(id);
	}

	public int createGroup(Group group) throws SQLException {
		return groupService.createGroup(group);
	}

	public Group getGroupById(int id) throws SQLException, ParseException {
		return groupService.getGroupById(id);
	}

	public boolean isGroupExists(int id) throws SQLException {
		return groupService.isGroupExists(id);
	}

	public int updateGroupById(int id, Group group) throws SQLException, Exception {
		return groupService.updateGroupById(id, group);
	}

	public int deleteGroupById(int id) throws SQLException, Exception {
		return groupService.deleteGroupById(id);
	}
}
