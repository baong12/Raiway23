package com.vti.backend.businesslayer.interfaces;

import java.util.List;

import com.vti.entity.Group;

public interface IGroupService {
	public List<Group> getListGroups() throws Exception;

	public int createGroup(Group group) throws Exception;

	public Group getGroupById(int id) throws Exception;

	public boolean isGroupExists(int id) throws Exception;

	public int updateGroupById(int id, Group group) throws Exception;

	public int deleteGroupById(int id) throws Exception;
}
