package com.vti.entity;

import java.util.Date;

import com.vti.backend.enums.PositionName;
import com.vti.backend.enums.TypeName;

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
		dp1.setId((byte) 1);
		dp1.setName("Quản trị");

		dp2.setId((byte) 2);
		dp2.setName("Kinh doanh");

		dp3.setId((byte) 3);
		dp3.setName("Kĩ thuật");

		dp4.setId((byte) 4);
		dp4.setName("Sales");

		dp5.setId((byte) 5);
		dp5.setName("Kế toán");

		// Add Position objects
		pos1.setId((byte) 1);
		pos1.setName(PositionName.DEV);

		pos2.setId((byte) 2);
		pos2.setName(PositionName.TEST);

		pos3.setId((byte) 3);
		pos3.setName(PositionName.PM);

		pos4.setId((byte) 4);
		pos4.setName(PositionName.SCRUM_MASTER);

		// Add Account objects
		acc1.setId(1);
		acc1.setEmail("an.nguyen@gmail.com");
		acc1.setUsername("an.nguyen");
		acc1.setFullName("Nguyễn Văn An");
		acc1.setDepartment(dp1);
		acc1.setPosition(pos1);
		acc1.setCreateDate(new Date());

		acc2.setId(2);
		acc2.setEmail("binh.nguyen@gmail.com");
		acc2.setUsername("binh.nguyen");
		acc2.setFullName("Nguyễn Văn Bình");
		acc2.setDepartment(dp2);
		acc2.setPosition(pos2);
		acc2.setCreateDate(new Date());

		acc3.setId(3);
		acc3.setEmail("cuong.nguyen@gmail.com");
		acc3.setUsername("cuong.nguyen");
		acc3.setFullName("Nguyễn Văn Cường");
		acc3.setDepartment(dp3);
		acc3.setPosition(pos4);
		acc3.setCreateDate(new Date());

		acc4.setId(4);
		acc4.setEmail("dung.nguyen@gmail.com");
		acc4.setUsername("dung.nguyen");
		acc4.setFullName("Nguyễn Văn Dũng");
		acc4.setDepartment(dp1);
		acc4.setPosition(pos4);
		acc4.setCreateDate(new Date());

		acc5.setId(5);
		acc5.setEmail("em.nguyen@gmail.com");
		acc5.setUsername("em.nguyen");
		acc5.setFullName("Nguyễn Văn Em");
		acc5.setDepartment(dp2);
		acc5.setPosition(pos2);
		acc5.setCreateDate(new Date());

		// Group
		gr1.setId(1);
		gr1.setName("Railway 1");
		gr1.setCreator(acc1);
		gr1.setCreateDate(new Date());

		gr2.setId(2);
		gr2.setName("Railway 2");
		gr2.setCreator(acc5);
		gr2.setCreateDate(new Date());

		gr3.setId(3);
		gr3.setName("Railway 3");
		gr3.setCreator(acc1);
		gr3.setCreateDate(new Date());

		gr4.setId(4);
		gr4.setName("Railway 4");
		gr4.setCreator(acc2);
		gr4.setCreateDate(new Date());

		// GroupAccount
		ga1.setGroup(gr1);
		ga1.setAccount(acc1);
		ga1.setJoinDate(new Date());

		ga2.setGroup(gr1);
		ga2.setAccount(acc2);
		ga2.setJoinDate(new Date());

		ga3.setGroup(gr2);
		ga3.setAccount(acc1);
		ga3.setJoinDate(new Date());

		ga4.setGroup(gr4);
		ga4.setAccount(acc5);
		ga4.setJoinDate(new Date());

		ga5.setGroup(gr4);
		ga5.setAccount(acc2);
		ga5.setJoinDate(new Date());

		// TypeQuestion
		type1.setId((byte) 1);
		type1.setName(TypeName.ESSAY);

		type2.setId((byte) 2);
		type2.setName(TypeName.MULTIPLE_CHOICE);

		// CategoryQuestion
		cate1.setId(1);
		cate1.setName("Java");

		cate2.setId(2);
		cate2.setName(".NET");

		cate3.setId(3);
		cate3.setName("SQL");

		cate4.setId(4);
		cate4.setName("Postman");

		cate5.setId(5);
		cate5.setName("Ruby");

		// Question
		que1.setId(1);
		que1.setContent("Java là gì?");
		que1.setCategory(cate1);
		que1.setType(type1);
		que1.setCreator(acc5);
		que1.setCreateDate(new Date());

		que2.setId(2);
		que2.setContent(".NET là gì?");
		que2.setCategory(cate2);
		que2.setType(type1);
		que2.setCreator(acc2);
		que2.setCreateDate(new Date());

		que3.setId(3);
		que3.setContent("SQL là gì?");
		que3.setCategory(cate3);
		que3.setType(type2);
		que3.setCreator(acc1);
		que3.setCreateDate(new Date());

		que4.setId(4);
		que4.setContent("Postman là gì?");
		que4.setCategory(cate4);
		que4.setType(type1);
		que4.setCreator(acc5);
		que4.setCreateDate(new Date());

		que5.setId(5);
		que5.setContent("Ruby là gì?");
		que5.setCategory(cate5);
		que5.setType(type2);
		que5.setCreator(acc2);
		que5.setCreateDate(new Date());

		// Answer
		ans1.setId(1);
		ans1.setContent("Là ngôn ngữ lập trình.");
		ans1.setQuestion(que1);
		ans1.setCorrect(true);

		ans2.setId(2);
		ans2.setContent("Là tên một ca sĩ.");
		ans2.setQuestion(que1);
		ans2.setCorrect(true);

		ans3.setId(3);
		ans3.setContent("Là một loại trái cây.");
		ans3.setQuestion(que3);
		ans3.setCorrect(true);

		ans4.setId(4);
		ans4.setContent("Là một cầu thủ bóng đá.");
		ans4.setQuestion(que4);
		ans4.setCorrect(true);

		ans5.setId(5);
		ans5.setContent("Là một từ tiếng Anh.");
		ans5.setQuestion(que5);
		ans5.setCorrect(true);

		// Exam
		ex1.setId(1);
		ex1.setCode("JAV-001");
		ex1.setTitle("Kì thi Java số 1");
		ex1.setCategory(cate1);
		ex1.setDuration(45);
		ex1.setCreator(acc1);
		ex1.setCreateDate(new Date());

		ex2.setId(2);
		ex2.setCode("JAV-002");
		ex2.setTitle("Kì thi Java số 2");
		ex2.setCategory(cate3);
		ex2.setDuration(60);
		ex2.setCreator(acc1);
		ex2.setCreateDate(new Date());

		ex3.setId(3);
		ex3.setCode("SQL-001");
		ex3.setTitle("Kì thi SQL số 1");
		ex3.setCategory(cate2);
		ex3.setDuration(90);
		ex3.setCreator(acc5);
		ex3.setCreateDate(new Date());

		// ExamQuestion
		eq1.setExam(ex1);
		eq1.setQuestion(que1);

		eq2.setExam(ex1);
		eq2.setQuestion(que2);

		eq3.setExam(ex1);
		eq3.setQuestion(que3);

		eq4.setExam(ex1);
		eq4.setQuestion(que4);

		eq5.setExam(ex2);
		eq5.setQuestion(que2);

		eq6.setExam(ex2);
		eq6.setQuestion(que3);

		eq7.setExam(ex3);
		eq7.setQuestion(que1);

		eq8.setExam(ex3);
		eq8.setQuestion(que3);
	}
}
