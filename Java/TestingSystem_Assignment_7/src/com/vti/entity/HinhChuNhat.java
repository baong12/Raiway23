package com.vti.entity;

public class HinhChuNhat extends HinhHoc {
	private int width;
	private int height;
	
	/**
	 * @param width
	 * @param height
	 * @throws Exception
	 */
	public HinhChuNhat(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	public float TinhChuVi() {
		return 2 * (width + height);
	}
	
	public float TinhDienTich() {
		return width * height;
	}
}
