package com.vti.academy;

import java.util.Date;

import com.vti.academy.enums.PositionName;
import com.vti.academy.enums.TypeName;

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
	public GroupAccount ga1 = new GroupAccount();
	public GroupAccount ga2 = new GroupAccount();
	public GroupAccount ga3 = new GroupAccount();
	public GroupAccount ga4 = new GroupAccount();
	public GroupAccount ga5 = new GroupAccount();
	public TypeQuestion type1 = new TypeQuestion();
	public TypeQuestion type2 = new TypeQuestion();
	public CategoryQuestion cate1 = new CategoryQuestion();
	public CategoryQuestion cate2 = new CategoryQuestion();
	public CategoryQuestion cate3 = new CategoryQuestion();
	public CategoryQuestion cate4 = new CategoryQuestion();
	public CategoryQuestion cate5 = new CategoryQuestion();
	public Question que1 = new Question();
	public Question que2 = new Question();
	public Question que3 = new Question();
	public Question que4 = new Question();
	public Question que5 = new Question();
	public Answer ans1 = new Answer();
	public Answer ans2 = new Answer();
	public Answer ans3 = new Answer();
	public Answer ans4 = new Answer();
	public Answer ans5 = new Answer();
	public Exam ex1 = new Exam();
	public Exam ex2 = new Exam();
	public Exam ex3 = new Exam();
	public ExamQuestion eq1 = new ExamQuestion();
	public ExamQuestion eq2 = new ExamQuestion();
	public ExamQuestion eq3 = new ExamQuestion();
	public ExamQuestion eq4 = new ExamQuestion();
	public ExamQuestion eq5 = new ExamQuestion();
	public ExamQuestion eq6 = new ExamQuestion();
	public ExamQuestion eq7 = new ExamQuestion();
	public ExamQuestion eq8 = new ExamQuestion();
	
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

		// GroupAccount
		ga1.group = gr1;
		ga1.account = acc1;
		ga1.joinDate = new Date();

		ga2.group = gr1;
		ga2.account = acc2;
		ga2.joinDate = new Date();

		ga3.group = gr2;
		ga3.account = acc1;
		ga3.joinDate = new Date();

		ga4.group = gr4;
		ga4.account = acc5;
		ga4.joinDate = new Date();

		ga5.group = gr4;
		ga5.account = acc2;
		ga5.joinDate = new Date();

		// TypeQuestion
		type1.id = 1;
		type1.name = TypeName.ESSAY;

		type2.id = 2;
		type2.name = TypeName.MULTIPLE_CHOICE;

		// CategoryQuestion
		cate1.id = 1;
		cate1.name = "Java";

		cate2.id = 2;
		cate2.name = ".NET";

		cate3.id = 3;
		cate3.name = "SQL";

		cate4.id = 4;
		cate4.name = "Postman";

		cate5.id = 5;
		cate5.name = "Ruby";

		// Question
		que1.id = 1;
		que1.content = "Java là gì?";
		que1.category = cate1;
		que1.type = type1;
		que1.creator = acc5;
		que1.createDate = new Date();

		que2.id = 2;
		que2.content = ".NET là gì?";
		que2.category = cate2;
		que2.type = type1;
		que2.creator = acc2;
		que2.createDate = new Date();

		que3.id = 3;
		que3.content = "SQL là gì?";
		que3.category = cate3;
		que3.type = type2;
		que3.creator = acc1;
		que3.createDate = new Date();

		que4.id = 4;
		que4.content = "Postman là gì?";
		que4.category = cate4;
		que4.type = type1;
		que4.creator = acc5;
		que4.createDate = new Date();

		que5.id = 5;
		que5.content = "Ruby là gì?";
		que5.category = cate5;
		que5.type = type2;
		que5.creator = acc2;
		que5.createDate = new Date();

		// Answer
		ans1.id = 1;
		ans1.content = "Là ngôn ngữ lập trình.";
		ans1.question = que1;
		ans1.isCorrect = true;

		ans2.id = 2;
		ans2.content = "Là tên một ca sĩ.";
		ans2.question = que1;
		ans2.isCorrect = true;

		ans3.id = 3;
		ans3.content = "Là một loại trái cây.";
		ans3.question = que3;
		ans3.isCorrect = true;

		ans4.id = 4;
		ans4.content = "Là một cầu thủ bóng đá.";
		ans4.question = que4;
		ans4.isCorrect = true;

		ans5.id = 5;
		ans5.content = "Là một từ tiếng Anh.";
		ans5.question = que5;
		ans5.isCorrect = true;

		// Exam
		ex1.id = 1;
		ex1.code = "JAV-001";
		ex1.title = "Kì thi Java số 1";
		ex1.category = cate1;
		ex1.duration = 45;
		ex1.creator = acc1;
		ex1.createDate = new Date();

		ex2.id = 2;
		ex2.code = "JAV-002";
		ex2.title = "Kì thi Java số 2";
		ex2.category = cate3;
		ex2.duration = 60;
		ex2.creator = acc1;
		ex2.createDate = new Date();

		ex3.id = 3;
		ex3.code = "SQL-001";
		ex3.title = "Kì thi SQL số 1";
		ex3.category = cate2;
		ex3.duration = 90;
		ex3.creator = acc5;
		ex3.createDate = new Date();

		// ExamQuestion
		eq1.exam = ex1;
		eq1.question = que1;

		eq2.exam = ex1;
		eq2.question = que2;

		eq3.exam = ex1;
		eq3.question = que3;

		eq4.exam = ex1;
		eq4.question = que4;

		eq5.exam = ex2;
		eq5.question = que2;

		eq6.exam = ex2;
		eq6.question = que3;

		eq7.exam = ex3;
		eq7.question = que1;

		eq8.exam = ex3;
		eq8.question = que3;
	}
}
