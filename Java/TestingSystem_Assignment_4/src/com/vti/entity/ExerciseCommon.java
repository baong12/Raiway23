package com.vti.entity;

import java.util.Date;

import com.vti.entity.enums.PositionName;

/**
 * @author baong
 *
 */
public class ExerciseCommon {
	public Department dp1 = new Department();
	public Department dp2 = new Department();
	public Department dp3 = new Department();
	public Department dp4 = new Department();
	public Department dp5 = new Department();
	public Position pos1 = new Position();
	public Position pos2 = new Position();
	public Position pos3 = new Position();
	public Position pos4 = new Position();
	public Account acc1 = new Account();
	public Account acc2 = new Account();
	public Account acc3 = new Account();
	public Account acc4 = new Account();
	public Account acc5 = new Account();
	public Group gr1 = new Group();
	public Group gr2 = new Group();
	public Group gr3 = new Group();
	public Group gr4 = new Group();
	
	public ExerciseCommon() {
		// Add Department objects
		dp1.id = 1;
		dp1.name = "Quản trị";

		dp2.id = 2;
		dp2.name = "Kinh doanh";

		dp3.id = 3;
		dp3.name = "Kĩ thuật";

		dp4.id = 4;
		dp4.name = "Sales";

		dp5.id = 5;
		dp5.name = "Kế toán";

		// Add Position objects
		pos1.id = 1;
		pos1.name = PositionName.DEV;

		pos2.id = 2;
		pos2.name = PositionName.TEST;

		pos3.id = 3;
		pos3.name = PositionName.PM;

		pos4.id = 4;
		pos4.name = PositionName.SCRUM_MASTER;

		// Add Account objects
		acc1.id = 1;
		acc1.email = "an.nguyen@gmail.com";
		acc1.username = "an.nguyen";
		acc1.fullName = "Nguyễn Văn An";
		acc1.department = dp1;
		acc1.position = pos1;
		acc1.createDate = new Date();

		acc2.id = 2;
		acc2.email = "binh.nguyen@gmail.com";
		acc2.username = "binh.nguyen";
		acc2.fullName = "Nguyễn Văn Bình";
		acc2.department = dp2;
		acc2.position = pos2;
		acc2.createDate = new Date();

		acc3.id = 3;
		acc3.email = "cuong.nguyen@gmail.com";
		acc3.username = "cuong.nguyen";
		acc3.fullName = "Nguyễn Văn Cường";
		acc3.department = dp3;
		acc3.position = pos4;
		acc3.createDate = new Date();

		acc4.id = 4;
		acc4.email = "dung.nguyen@gmail.com";
		acc4.username = "dung.nguyen";
		acc4.fullName = "Nguyễn Văn Dũng";
		acc4.department = dp1;
		acc4.position = pos4;
		acc4.createDate = new Date();

		acc5.id = 5;
		acc5.email = "em.nguyen@gmail.com";
		acc5.username = "em.nguyen";
		acc5.fullName = "Nguyễn Văn Em";
		acc5.department = dp2;
		acc5.position = pos2;
		acc5.createDate = new Date();

		// Group
		gr1.id = 1;
		gr1.name = "Railway 1";
		gr1.creator = acc1;
		gr1.createDate = new Date();

		gr2.id = 2;
		gr2.name = "Railway 2";
		gr2.creator = acc5;
		gr2.createDate = new Date();

		gr3.id = 3;
		gr3.name = "Railway 3";
		gr3.creator = acc1;
		gr3.createDate = new Date();

		gr4.id = 4;
		gr4.name = "Railway 4";
		gr4.creator = acc2;
		gr4.createDate = new Date();
	}
}
