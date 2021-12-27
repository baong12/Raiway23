package com.vti.backend.businesslayer.interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.backend.datalayer.GroupRepository;
import com.vti.backend.datalayer.interfaces.IGroupRepository;
import com.vti.entity.Account;
import com.vti.entity.Group;

public class GroupService implements IGroupService {
	private IGroupRepository groupRepository = new GroupRepository();

	@Override
	public List<Group> getListGroups() throws SQLException, ParseException {
		return groupRepository.getListGroups();
	}

	@Override
	public List<Account> getListAccountsByGroupId(int id) throws SQLException {
		return groupRepository.getListAccountsByGroupId(id);
	}

	@Override
	public int createGroup(Group group) throws SQLException {
		return groupRepository.createGroup(group);
	}

	@Override
	public Group getGroupById(int id) throws SQLException, ParseException {
		return groupRepository.getGroupById(id);
	}

	@Override
	public boolean isGroupExists(int id) throws SQLException {
		return groupRepository.isGroupExists(id);
	}

	@Override
	public int updateGroupById(int id, Group group) throws SQLException, Exception {
		return groupRepository.updateGroupById(id, group);
	}

	@Override
	public int deleteGroupById(int id) throws SQLException, Exception {
		return groupRepository.deleteGroupById(id);
	}

}
