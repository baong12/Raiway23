package com.vti.entity.generic;

import java.text.NumberFormat;
import java.util.Locale;

public class Salary<N extends Number> {
	private N value;

	/**
	 * @param value
	 */
	public Salary(N value) {
		super();
		this.value = value;
	}

	public void print() {
		NumberFormat numberFormat = NumberFormat.getInstance();
		System.out.println("$" + numberFormat.format(value));
	}
}
