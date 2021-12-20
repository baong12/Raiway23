package com.vti.frontend;

import com.vti.entity.NgayThangNam;
import com.vti.entity.NgayThangNam.GioPhutGiay;
import com.vti.entity.OuterClass;
import com.vti.entity.OuterClass.InnerClass;

public class MainClass {
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		outerClass.show();
		
		InnerClass innerClass = outerClass.new InnerClass();
		innerClass.show();
		
		NgayThangNam date = new NgayThangNam();
		date.ngay = 31;
		date.thang = 10;
		date.nam = 2017;
		
		GioPhutGiay time = date.new GioPhutGiay();
		time.gio = 10;
		time.phut = 15;
		time.giay = 30;
		
		time.xuatThongTin();
	}
}
