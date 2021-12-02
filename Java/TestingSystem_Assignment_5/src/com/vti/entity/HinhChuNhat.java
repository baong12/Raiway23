package com.vti.entity;

public class HinhChuNhat {
	private Float width;
	private Float height;

	/**
	 * @param width
	 * @param height
	 */
	public HinhChuNhat(Float width, Float height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "HinhChuNhat [width=" + width + ", height=" + height + "]";
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float tinhDienTich() {
		return width * height;
	}

	public Float tinhChuVi() {
		return 2 * (width + height);
	}
}
