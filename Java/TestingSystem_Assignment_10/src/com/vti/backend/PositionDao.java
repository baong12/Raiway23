package com.vti.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.Position;
import com.vti.entity.enums.PositionName;
import com.vti.utils.JdbcUtils;

public class PositionDao {

	public static Position getPositionById(int id) throws SQLException {
		String sql = "SELECT * FROM position WHERE position_id = ?;";
		PreparedStatement preparedStatement = JdbcUtils.connect().prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String positionName = resultSet.getString("position_name");
			for (PositionName name : PositionName.values()) {
				if (positionName.equals(name.getPositionName())) {
					return new Position(id, name);
				}
			}
		}
		return null;
	}
	
}
