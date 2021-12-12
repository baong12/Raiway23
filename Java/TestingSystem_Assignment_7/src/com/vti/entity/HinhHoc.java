package com.vti.entity;

public class HinhHoc {
	private static int soLuongHinh;

	public HinhHoc() {
		soLuongHinh++;
	}

	public static int getSoLuongHinh() {
		return soLuongHinh;
	}
}
