package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PositionNameConvert implements AttributeConverter<Position.PositionName, String> {

	@Override
	public String convertToDatabaseColumn(Position.PositionName name) {
		if (name == null) {
			return null;
		}

		return name.getValue();
	}

	@Override
	public Position.PositionName convertToEntityAttribute(String sqlValue) {
		if (sqlValue == null) {
			return null;
		}

		return Position.PositionName.toEnum(sqlValue);
	}

}
