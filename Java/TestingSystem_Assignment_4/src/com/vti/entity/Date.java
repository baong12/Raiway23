package com.vti.entity;

public class Date {
	private Integer day;
	private Integer month;
	private Integer year;
	
	/**
	 * @param day ngày
	 * @param month tháng
	 * @param year năm
	 */
	public Date(Integer day, Integer month, Integer year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return String.format("%02d/%02d/%d", day, month, year);
	}
	
	public boolean isLeapYear() {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
}
