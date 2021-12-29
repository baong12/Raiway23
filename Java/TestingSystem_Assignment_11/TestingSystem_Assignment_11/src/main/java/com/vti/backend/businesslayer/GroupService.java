package com.vti.backend.businesslayer;

import java.util.List;

import com.vti.backend.businesslayer.interfaces.IGroupService;
import com.vti.backend.datalayer.GroupRepository;
import com.vti.backend.datalayer.interfaces.IGroupRepository;
import com.vti.entity.Group;

public class GroupService implements IGroupService {
	private IGroupRepository groupRepository = new GroupRepository();

	@Override
	public List<Group> getListGroups() throws Exception {
		return groupRepository.getListGroups();
	}

	@Override
	public int createGroup(Group group) throws Exception {
		return groupRepository.createGroup(group);
	}

	@Override
	public Group getGroupById(int id) throws Exception {
		return groupRepository.getGroupById(id);
	}

	@Override
	public boolean isGroupExists(int id) throws Exception {
		return groupRepository.isGroupExists(id);
	}

	@Override
	public int updateGroupById(int id, Group group) throws Exception {
		return groupRepository.updateGroupById(id, group);
	}

	@Override
	public int deleteGroupById(int id) throws Exception {
		return groupRepository.deleteGroupById(id);
	}

}
