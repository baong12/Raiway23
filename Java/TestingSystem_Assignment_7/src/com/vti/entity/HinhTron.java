package com.vti.entity;

public class HinhTron extends HinhHoc {
	private int radius;
	
	public HinhTron(int radius) {
		super();
		this.radius = radius;
	}
	
	public float tinhChuVi() {
		return 2 * radius * 3.14f;
	}
	
	public float tinhDienTich() {
		return radius * radius * 3.14f;
	}
}
