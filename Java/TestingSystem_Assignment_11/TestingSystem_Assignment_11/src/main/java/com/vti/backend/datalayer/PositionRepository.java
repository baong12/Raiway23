package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vti.backend.datalayer.interfaces.IPositionRepository;
import com.vti.entity.Position;
import com.vti.entity.enums.PositionName;
import com.vti.utils.JDBCUtils;

public class PositionRepository implements IPositionRepository {

	@Override
	public Position getPositionById(int id) throws Exception {
		String sql = "SELECT * FROM `position` WHERE position_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			PositionName position = null;
			for (PositionName key : PositionName.values()) {
				position = key.getKey(resultSet.getString("position_name"));
				if (position != null) {
					break;
				}
			}
			return new Position(id, position);
		}
		return null;
	}

}
