package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.backend.businesslayer.GroupService;
import com.vti.backend.businesslayer.interfaces.IGroupService;
import com.vti.entity.Account;
import com.vti.entity.Group;

public class GroupController {
	private IGroupService groupService = new GroupService();
	
	public List<Group> getListGroups() throws Exception {
		return groupService.getListGroups();
	}

	public int createGroup(Group group) throws Exception {
		return groupService.createGroup(group);
	}

	public Group getGroupById(int id) throws Exception {
		return groupService.getGroupById(id);
	}

	public boolean isGroupExists(int id) throws Exception {
		return groupService.isGroupExists(id);
	}

	public int updateGroupById(int id, Group group) throws Exception {
		return groupService.updateGroupById(id, group);
	}

	public int deleteGroupById(int id) throws Exception {
		return groupService.deleteGroupById(id);
	}
}
