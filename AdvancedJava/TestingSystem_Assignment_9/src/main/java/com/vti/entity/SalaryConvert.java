package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SalaryConvert implements AttributeConverter<Salary.SalaryName, String> {

	@Override
	public String convertToDatabaseColumn(Salary.SalaryName name) {
		if (name == null) {
			return null;
		}

		return name.getName();
	}

	@Override
	public Salary.SalaryName convertToEntityAttribute(String sqlValue) {
		if (sqlValue == null) {
			return null;
		}

		return Salary.SalaryName.toEnum(sqlValue);
	}

}
