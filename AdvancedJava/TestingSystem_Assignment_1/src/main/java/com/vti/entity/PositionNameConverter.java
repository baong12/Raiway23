/**
 * 
 */
package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.Position.PositionName;

/**
 * @description This class is
 * @author baong
 * @create_date Feb 23, 2022
 * @version 1.0
 * 
 */
@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<PositionName, String> {

	@Override
	public String convertToDatabaseColumn(PositionName attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getName();
	}

	@Override
	public PositionName convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return PositionName.toEnum(dbData);
	}
	
}
