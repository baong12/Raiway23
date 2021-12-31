package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.datalayer.interfaces.IGroupRepository;
import com.vti.entity.Group;
import com.vti.utils.JDBCUtils;

public class GroupRepository implements IGroupRepository {
	public List<Group> getGroupListByAccountId(int id) throws SQLException {
		List<Group> result = new ArrayList<Group>();
		String sql = "SELECT g.* FROM group_account ga " + "LEFT JOIN `group` g ON ga.group_id = g.group_id "
				+ "WHERE ga.account_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int groupId = resultSet.getInt("group_id");
			String name = resultSet.getString("group_name");
			result.add(new Group(groupId, name));
		}
		return result;
	}
}
