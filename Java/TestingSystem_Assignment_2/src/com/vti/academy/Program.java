package com.vti.academy;

import java.util.Date;

import com.vti.academy.enums.PositionName;
import com.vti.academy.enums.TypeName;

import java.text.ParseException;
//import java.text.SimpleDateFormat;

public class Program {
	public static void main(String[] args) throws ParseException {
		// Add Department objects
		Department dp1 = new Department();
		dp1.id = 1;
		dp1.name = "Quản trị";

		Department dp2 = new Department();
		dp2.id = 2;
		dp2.name = "Kinh doanh";

		Department dp3 = new Department();
		dp3.id = 3;
		dp3.name = "Kĩ thuật";

		System.out.println("dp1: id = " + dp1.id + ", name = " + dp1.name);
		System.out.println("dp2: id = " + dp2.id + ", name = " + dp2.name);
		System.out.println("dp3: id = " + dp3.id + ", name = " + dp3.name);

		// Add Position objects
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.DEV;

		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.TEST;

		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.PM;

		Position pos4 = new Position();
		pos4.id = 4;
		pos4.name = PositionName.SCRUM_MASTER;

		System.out.println("pos1: id = " + pos1.id + ", name = " + pos1.name.getPositionName());
		System.out.println("pos2: id = " + pos2.id + ", name = " + pos2.name.getPositionName());
		System.out.println("pos3: id = " + pos3.id + ", name = " + pos3.name.getPositionName());
		System.out.println("pos4: id = " + pos4.id + ", name = " + pos4.name.getPositionName());

		// Add Account objects
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "a.nguyen@gmail.com";
		acc1.username = "a.nguyen";
		acc1.fullName = "Nguyễn Văn A";
		acc1.department = dp1;
		acc1.position = pos1;
		acc1.createDate = new Date();

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "b.nguyen@gmail.com";
		acc2.username = "b.nguyen";
		acc2.fullName = "Nguyễn Văn B";
		acc2.department = dp2;
		acc2.position = pos2;
		acc2.createDate = new Date();

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "c.nguyen@gmail.com";
		acc3.username = "c.nguyen";
		acc3.fullName = "Nguyễn Văn C";
		acc3.department = dp3;
		acc3.position = pos4;
		acc3.createDate = new Date();

		Account acc4 = new Account();
		acc4.id = 4;
		acc4.email = "d.nguyen@gmail.com";
		acc4.username = "d.nguyen";
		acc4.fullName = "Nguyễn Văn D";
		acc4.department = dp1;
		acc4.position = pos4;
		acc4.createDate = new Date();

		Account acc5 = new Account();
		acc5.id = 5;
		acc5.email = "e.nguyen@gmail.com";
		acc5.username = "e.nguyen";
		acc5.fullName = "Nguyễn Văn E";
		acc5.department = dp2;
		acc5.position = pos2;
		acc5.createDate = new Date();

		System.out.println("acc1: id=" + acc1.id + ", email=" + acc1.email + ", username=" + acc1.username
				+ ", fullName=" + acc1.fullName + ", department=" + acc1.department.name + ", position="
				+ acc1.position.name.getPositionName() + ", createDate=" + acc1.createDate);
		System.out.println("acc2: id=" + acc2.id + ", email=" + acc2.email + ", username=" + acc2.username
				+ ", fullName=" + acc2.fullName + ", department=" + acc2.department.name + ", position="
				+ acc2.position.name.getPositionName() + ", createDate=" + acc2.createDate);
		System.out.println("acc3: id=" + acc3.id + ", email=" + acc3.email + ", username=" + acc3.username
				+ ", fullName=" + acc3.fullName + ", department=" + acc3.department.name + ", position="
				+ acc3.position.name.getPositionName() + ", createDate=" + acc3.createDate);
		System.out.println("acc4: id=" + acc4.id + ", email=" + acc4.email + ", username=" + acc4.username
				+ ", fullName=" + acc4.fullName + ", department=" + acc4.department.name + ", position="
				+ acc4.position.name.getPositionName() + ", createDate=" + acc4.createDate);
		System.out.println("acc5: id=" + acc5.id + ", email=" + acc5.email + ", username=" + acc5.username
				+ ", fullName=" + acc5.fullName + ", department=" + acc5.department.name + ", position="
				+ acc5.position.name.getPositionName() + ", createDate=" + acc5.createDate);

		// Group
		Group gr1 = new Group();
		gr1.id = 1;
		gr1.name = "Railway 1";
		gr1.creator = acc1;
		gr1.createDate = new Date();

		Group gr2 = new Group();
		gr2.id = 2;
		gr2.name = "Railway 2";
		gr2.creator = acc5;
		gr2.createDate = new Date();

		Group gr3 = new Group();
		gr3.id = 3;
		gr3.name = "Railway 3";
		gr3.creator = acc1;
		gr3.createDate = new Date();

		Group gr4 = new Group();
		gr4.id = 4;
		gr4.name = "Railway 4";
		gr4.creator = acc2;
		gr4.createDate = new Date();

		System.out.println("gr1: id=" + gr1.id + ", name=" + gr1.name + ", creator=" + gr1.creator.fullName
				+ ", createDate=" + gr1.createDate);
		System.out.println("gr2: id=" + gr2.id + ", name=" + gr2.name + ", creator=" + gr2.creator.fullName
				+ ", createDate=" + gr2.createDate);
		System.out.println("gr3: id=" + gr3.id + ", name=" + gr3.name + ", creator=" + gr3.creator.fullName
				+ ", createDate=" + gr3.createDate);
		System.out.println("gr4: id=" + gr4.id + ", name=" + gr4.name + ", creator=" + gr4.creator.fullName
				+ ", createDate=" + gr4.createDate);

		// GroupAccount
		GroupAccount ga1 = new GroupAccount();
		ga1.group = gr1;
		ga1.account = acc1;
		ga1.joinDate = new Date();

		GroupAccount ga2 = new GroupAccount();
		ga2.group = gr1;
		ga2.account = acc2;
		ga2.joinDate = new Date();

		GroupAccount ga3 = new GroupAccount();
		ga3.group = gr2;
		ga3.account = acc1;
		ga3.joinDate = new Date();

		GroupAccount ga4 = new GroupAccount();
		ga4.group = gr4;
		ga4.account = acc5;
		ga4.joinDate = new Date();

		GroupAccount ga5 = new GroupAccount();
		ga5.group = gr4;
		ga5.account = acc2;
		ga5.joinDate = new Date();

		System.out.println(
				"ga1: group=" + ga1.group.name + ", account=" + ga1.account.fullName + ", joinDate=" + ga1.joinDate);
		System.out.println(
				"ga2: group=" + ga2.group.name + ", account=" + ga2.account.fullName + ", joinDate=" + ga2.joinDate);
		System.out.println(
				"ga3: group=" + ga3.group.name + ", account=" + ga3.account.fullName + ", joinDate=" + ga3.joinDate);
		System.out.println(
				"ga4: group=" + ga4.group.name + ", account=" + ga4.account.fullName + ", joinDate=" + ga4.joinDate);
		System.out.println(
				"ga5: group=" + ga5.group.name + ", account=" + ga5.account.fullName + ", joinDate=" + ga5.joinDate);

		// TypeQuestion
		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.name = TypeName.ESSAY;

		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.name = TypeName.MULTIPLE_CHOICE;

		System.out.println("type1: id=" + type1.id + ", name=" + type1.name.getTypeName());
		System.out.println("type2: id=" + type2.id + ", name=" + type2.name.getTypeName());

		// CategoryQuestion
		CategoryQuestion cate1 = new CategoryQuestion();
		cate1.id = 1;
		cate1.name = "Java";

		CategoryQuestion cate2 = new CategoryQuestion();
		cate2.id = 2;
		cate2.name = ".NET";

		CategoryQuestion cate3 = new CategoryQuestion();
		cate3.id = 3;
		cate3.name = "SQL";

		CategoryQuestion cate4 = new CategoryQuestion();
		cate4.id = 4;
		cate4.name = "Postman";

		CategoryQuestion cate5 = new CategoryQuestion();
		cate5.id = 5;
		cate5.name = "Ruby";

		System.out.println("cate1: id=" + cate1.id + ", name=" + cate1.name);
		System.out.println("cate2: id=" + cate2.id + ", name=" + cate2.name);
		System.out.println("cate3: id=" + cate3.id + ", name=" + cate3.name);
		System.out.println("cate4: id=" + cate4.id + ", name=" + cate4.name);
		System.out.println("cate5: id=" + cate5.id + ", name=" + cate5.name);

		// Question
		Question que1 = new Question();
		que1.id = 1;
		que1.content = "Java là gì?";
		que1.category = cate1;
		que1.type = type1;
		que1.creator = acc5;
		que1.createDate = new Date();

		Question que2 = new Question();
		que2.id = 2;
		que2.content = ".NET là gì?";
		que2.category = cate2;
		que2.type = type1;
		que2.creator = acc2;
		que2.createDate = new Date();

		Question que3 = new Question();
		que3.id = 3;
		que3.content = "SQL là gì?";
		que3.category = cate3;
		que3.type = type2;
		que3.creator = acc1;
		que3.createDate = new Date();

		Question que4 = new Question();
		que4.id = 4;
		que4.content = "Postman là gì?";
		que4.category = cate4;
		que4.type = type1;
		que4.creator = acc5;
		que4.createDate = new Date();

		Question que5 = new Question();
		que5.id = 5;
		que5.content = "Ruby là gì?";
		que5.category = cate5;
		que5.type = type2;
		que5.creator = acc2;
		que5.createDate = new Date();

		System.out.println(
				"que1: id=" + que1.id + ", content=" + que1.content + ", category=" + que1.category.name + ", type="
						+ que1.type.name + ", creator=" + que1.creator.fullName + ", createDate=" + que1.createDate);
		System.out.println(
				"que2: id=" + que2.id + ", content=" + que2.content + ", category=" + que2.category.name + ", type="
						+ que2.type.name + ", creator=" + que2.creator.fullName + ", createDate=" + que2.createDate);
		System.out.println(
				"que3: id=" + que3.id + ", content=" + que3.content + ", category=" + que3.category.name + ", type="
						+ que3.type.name + ", creator=" + que3.creator.fullName + ", createDate=" + que3.createDate);
		System.out.println(
				"que4: id=" + que4.id + ", content=" + que4.content + ", category=" + que4.category.name + ", type="
						+ que4.type.name + ", creator=" + que4.creator.fullName + ", createDate=" + que4.createDate);
		System.out.println(
				"que5: id=" + que5.id + ", content=" + que5.content + ", category=" + que5.category.name + ", type="
						+ que5.type.name + ", creator=" + que5.creator.fullName + ", createDate=" + que5.createDate);

		// Answer
		Answer ans1 = new Answer();
		ans1.id = 1;
		ans1.content = "Là ngôn ngữ lập trình.";
		ans1.question = que1;
		ans1.isCorrect = true;

		Answer ans2 = new Answer();
		ans2.id = 2;
		ans2.content = "Là tên một ca sĩ.";
		ans2.question = que1;
		ans2.isCorrect = true;

		Answer ans3 = new Answer();
		ans3.id = 3;
		ans3.content = "Là một loại trái cây.";
		ans3.question = que3;
		ans3.isCorrect = true;

		Answer ans4 = new Answer();
		ans4.id = 4;
		ans4.content = "Là một cầu thủ bóng đá.";
		ans4.question = que4;
		ans4.isCorrect = true;

		Answer ans5 = new Answer();
		ans5.id = 5;
		ans5.content = "Là một từ tiếng Anh.";
		ans5.question = que5;
		ans5.isCorrect = true;

		System.out.println("ans1: id=" + ans1.id + ", content=" + ans1.content + ", question=" + ans1.question.content
				+ ", isCorrect=" + ans1.isCorrect);
		System.out.println("ans2: id=" + ans2.id + ", content=" + ans2.content + ", question=" + ans2.question.content
				+ ", isCorrect=" + ans2.isCorrect);
		System.out.println("ans3: id=" + ans3.id + ", content=" + ans3.content + ", question=" + ans3.question.content
				+ ", isCorrect=" + ans3.isCorrect);
		System.out.println("ans4: id=" + ans4.id + ", content=" + ans4.content + ", question=" + ans4.question.content
				+ ", isCorrect=" + ans4.isCorrect);
		System.out.println("ans5: id=" + ans5.id + ", content=" + ans5.content + ", question=" + ans5.question.content
				+ ", isCorrect=" + ans5.isCorrect);

		// Exam
		Exam ex1 = new Exam();
		ex1.id = 1;
		ex1.code = "JAV-001";
		ex1.title = "Kì thi Java số 1";
		ex1.category = cate1;
		ex1.duration = 45;
		ex1.creator = acc1;
		ex1.createDate = new Date();

		Exam ex2 = new Exam();
		ex2.id = 2;
		ex2.code = "JAV-002";
		ex2.title = "Kì thi Java số 2";
		ex2.category = cate3;
		ex2.duration = 60;
		ex2.creator = acc1;
		ex2.createDate = new Date();

		Exam ex3 = new Exam();
		ex3.id = 3;
		ex3.code = "SQL-001";
		ex3.title = "Kì thi SQL số 1";
		ex3.category = cate2;
		ex3.duration = 90;
		ex3.creator = acc5;
		ex3.createDate = new Date();

		System.out.println("ex1: id=" + ex1.id + ", code=" + ex1.code + ", title=" + ex1.title + ", category="
				+ ex1.category.name + ", duration=" + ex1.duration + ", creator=" + ex1.creator.fullName
				+ ", createDate=" + ex1.createDate);
		System.out.println("ex2: id=" + ex2.id + ", code=" + ex2.code + ", title=" + ex2.title + ", category="
				+ ex2.category.name + ", duration=" + ex2.duration + ", creator=" + ex2.creator.fullName
				+ ", createDate=" + ex2.createDate);
		System.out.println("ex3: id=" + ex3.id + ", code=" + ex3.code + ", title=" + ex3.title + ", category="
				+ ex3.category.name + ", duration=" + ex3.duration + ", creator=" + ex3.creator.fullName
				+ ", createDate=" + ex3.createDate);

		// ExamQuestion
		ExamQuestion eq1 = new ExamQuestion();
		eq1.exam = ex1;
		eq1.question = que1;

		ExamQuestion eq2 = new ExamQuestion();
		eq2.exam = ex1;
		eq2.question = que2;

		ExamQuestion eq3 = new ExamQuestion();
		eq3.exam = ex1;
		eq3.question = que3;

		ExamQuestion eq4 = new ExamQuestion();
		eq4.exam = ex1;
		eq4.question = que4;

		ExamQuestion eq5 = new ExamQuestion();
		eq5.exam = ex2;
		eq5.question = que2;

		ExamQuestion eq6 = new ExamQuestion();
		eq6.exam = ex2;
		eq6.question = que3;

		ExamQuestion eq7 = new ExamQuestion();
		eq7.exam = ex3;
		eq7.question = que1;

		ExamQuestion eq8 = new ExamQuestion();
		eq8.exam = ex3;
		eq8.question = que3;

		System.out.println("eq1: exam=" + eq1.exam.title + ", question=" + eq1.question.content);
		System.out.println("eq2: exam=" + eq2.exam.title + ", question=" + eq2.question.content);
		System.out.println("eq3: exam=" + eq3.exam.title + ", question=" + eq3.question.content);
		System.out.println("eq4: exam=" + eq4.exam.title + ", question=" + eq4.question.content);
		System.out.println("eq5: exam=" + eq5.exam.title + ", question=" + eq5.question.content);
		System.out.println("eq6: exam=" + eq6.exam.title + ", question=" + eq6.question.content);
		System.out.println("eq7: exam=" + eq7.exam.title + ", question=" + eq7.question.content);
		System.out.println("eq8: exam=" + eq8.exam.title + ", question=" + eq8.question.content);
	}

//	public static Date getDate(String dateString) throws ParseException {
//		// Instantiating the SimpleDateFormat class
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		// Parsing the given String to Date object
//		Date date = formatter.parse(dateString);
//
//		return date;
//	}
}
