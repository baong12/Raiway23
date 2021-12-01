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
		return getType(this) + " [width=" + width + ", height=" + height + "]";
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

	public void tinhDienTich() {
		System.out.println("Tính diện tích theo " + getType(this) + ": " + width * height);
	}

	public void tinhChuVi() {
		System.out.println("Tính chu vi theo " + getType(this) + ": " + 2 * (width + height));
	}

	private String getType(HinhChuNhat obj) {
		String type = "không xác định";
		if (obj instanceof HinhChuNhat) {
			type = "hình chữ nhật";
		}
		if (obj instanceof HinhVuong) {
			type = "hình vuông";
		}
		if (obj instanceof HinhChuNhatDacBiet) {
			type = "hình chữ nhật đặc biệt";
		}
		return type;
	}
}
