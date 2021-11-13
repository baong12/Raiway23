package testing_system;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
	/*
	 * Question 2: Tạo file Program.java có chứa main() method và khởi tạo ít nhất 3
	 * đối tượng đối với mỗi table trong java
	 */
	public static void main(String[] args) throws ParseException {
		// Add Department objects
		Department dp1 = new Department();
		dp1.departmentId = 1;
		dp1.departmentName = "Quản trị";

		Department dp2 = new Department();
		dp2.departmentId = 2;
		dp2.departmentName = "Kinh doanh";

		Department dp3 = new Department();
		dp3.departmentId = 3;
		dp3.departmentName = "Kĩ thuật";

		// Add Position objects
		Position pos1 = new Position();
		pos1.positionId = 1;
		pos1.positionName = PositionName.DEV;

		Position pos2 = new Position();
		pos2.positionId = 2;
		pos2.positionName = PositionName.TEST;

		Position pos3 = new Position();
		pos3.positionId = 3;
		pos3.positionName = PositionName.PM;

		// Add Account objects
		Account acc1 = new Account();
		acc1.accountId = 1;
		acc1.email = "a.nguyen@gmail.com";
		acc1.username = "a.nguyen";
		acc1.fullName = "Nguyễn Văn A";
		acc1.department = dp1;
		acc1.position = pos1;
//		acc1.createDate = new Date();
		acc1.createDate = getDate("2021-11-12");

		Account acc2 = new Account();
		acc2.accountId = 2;
		acc2.email = "b.nguyen@gmail.com";
		acc2.username = "b.nguyen";
		acc2.fullName = "Nguyễn Văn B";
		acc2.department = dp2;
		acc2.position = pos2;
//		acc1.createDate = new Date();
		acc2.createDate = getDate("2021-11-12");

		Account acc3 = new Account();
		acc3.accountId = 3;
		acc3.email = "c.nguyen@gmail.com";
		acc3.username = "c.nguyen";
		acc3.fullName = "Nguyễn Văn C";
		acc3.department = dp3;
		acc3.position = pos3;
//		acc1.createDate = new Date();
		acc3.createDate = getDate("2021-11-12");

		// Group
		Group gr1 = new Group();
		gr1.groupId = 1;
		gr1.groupName = "Railway 1";
		gr1.creator = acc1;
		gr1.createDate = getDate("2021-11-14");

		Group gr2 = new Group();
		gr2.groupId = 2;
		gr2.groupName = "Railway 2";
		gr2.creator = acc3;
		gr2.createDate = getDate("2021-11-14");

		Group gr3 = new Group();
		gr3.groupId = 3;
		gr3.groupName = "Railway 3";
		gr3.creator = acc1;
		gr3.createDate = getDate("2021-11-14");

		Group gr4 = new Group();
		gr3.groupId = 4;
		gr3.groupName = "Railway 4";
		gr3.creator = acc2;
		gr3.createDate = getDate("2021-11-14");

		// GroupAccount
		GroupAccount ga1 = new GroupAccount();
		ga1.group = gr1;
		ga1.account = acc1;
		ga1.joinDate = getDate("2021-11-14");

		GroupAccount ga2 = new GroupAccount();
		ga2.group = gr1;
		ga2.account = acc2;
		ga2.joinDate = getDate("2021-11-14");

		GroupAccount ga3 = new GroupAccount();
		ga3.group = gr2;
		ga3.account = acc1;
		ga3.joinDate = getDate("2021-11-14");

		GroupAccount ga4 = new GroupAccount();
		ga4.group = gr3;
		ga4.account = acc3;
		ga4.joinDate = getDate("2021-11-14");

		GroupAccount ga5 = new GroupAccount();
		ga5.group = gr3;
		ga5.account = acc2;
		ga5.joinDate = getDate("2021-11-14");

		// TypeQuestion
		TypeQuestion type1 = new TypeQuestion();
		type1.typeId = 1;
		type1.typeName = TypeName.ESSAY;

		TypeQuestion type2 = new TypeQuestion();
		type2.typeId = 2;
		type2.typeName = TypeName.MULTIPLE_CHOICE;

		// CategoryQuestion
		CategoryQuestion cate1 = new CategoryQuestion();
		cate1.categoryId = 1;
		cate1.categoryName = "Java";

		CategoryQuestion cate2 = new CategoryQuestion();
		cate2.categoryId = 2;
		cate2.categoryName = ".NET";

		CategoryQuestion cate3 = new CategoryQuestion();
		cate3.categoryId = 3;
		cate3.categoryName = "SQL";

		CategoryQuestion cate4 = new CategoryQuestion();
		cate4.categoryId = 4;
		cate4.categoryName = "Postman";

		CategoryQuestion cate5 = new CategoryQuestion();
		cate5.categoryId = 5;
		cate5.categoryName = "Ruby";
		
		// Question
		Question que1 = new Question();
		que1.questionId = 1;
		que1.content = "Java là gì?";
		que1.category = cate1;
		que1.type = type1;
		que1.creator = acc3;
		que1.createDate = getDate("2021-11-12");

		Question que2 = new Question();
		que2.questionId = 2;
		que2.content = ".NET là gì?";
		que2.category = cate2;
		que2.type = type1;
		que2.creator = acc2;
		que2.createDate = getDate("2021-11-13");

		Question que3 = new Question();
		que3.questionId = 3;
		que3.content = "SQL là gì?";
		que3.category = cate3;
		que3.type = type2;
		que3.creator = acc1;
		que3.createDate = getDate("2021-11-14");

		Question que4 = new Question();
		que4.questionId = 4;
		que4.content = "Postman là gì?";
		que4.category = cate4;
		que4.type = type1;
		que4.creator = acc3;
		que4.createDate = getDate("2021-11-12");

		Question que5 = new Question();
		que5.questionId = 5;
		que5.content = "Ruby là gì?";
		que5.category = cate5;
		que5.type = type2;
		que5.creator = acc2;
		que5.createDate = getDate("2021-11-12");
		
		// Answer
		Answer ans1 = new Answer();
		ans1.answerId = 1;
		ans1.content = "Là ngôn ngữ lập trình.";
		ans1.question = que1;
		ans1.isCorrect = true;		

		Answer ans2 = new Answer();
		ans2.answerId = 2;
		ans2.content = "Là tên một ca sĩ.";
		ans2.question = que1;
		ans2.isCorrect = true;

		Answer ans3 = new Answer();
		ans3.answerId = 3;
		ans3.content = "Là một loại trái cây.";
		ans3.question = que3;
		ans3.isCorrect = true;

		Answer ans4 = new Answer();
		ans4.answerId = 4;
		ans4.content = "Là một cầu thủ bóng đá.";
		ans4.question = que4;
		ans4.isCorrect = true;
		
		Answer ans5 = new Answer();
		ans5.answerId = 5;
		ans5.content = "Là một từ tiếng Anh.";
		ans5.question = que5;
		ans5.isCorrect = true;
		
		// Exam
		Exam ex1 = new Exam();
		ex1.examId = 1;
		ex1.code = "JAV-001";
		ex1.title = "Kì thi Java số 1";
		ex1.category = cate1;
		ex1.duration = 45;
		ex1.creator = acc1;
		ex1.createDate = getDate("2021-11-12");

		Exam ex2 = new Exam();
		ex2.examId = 2;
		ex2.code = "JAV-002";
		ex2.title = "Kì thi Java số 2";
		ex2.category = cate3;
		ex2.duration = 60;
		ex2.creator = acc1;
		ex2.createDate = getDate("2021-11-12");

		Exam ex3 = new Exam();
		ex3.examId = 3;
		ex3.code = "SQL-001";
		ex3.title = "Kì thi SQL số 1";
		ex3.category = cate2;
		ex3.duration = 90;
		ex3.creator = acc3;
		ex3.createDate = getDate("2021-11-12");		
		
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
		
		/*
		 * Question 3: Trong file Program.java, hãy in ít nhất 1 giá trị của mỗi đối
		 * tượng ra
		 */
		System.out.println("dp1.departmentName = " + dp1.departmentName);
		System.out.println("pos1.positionName = " + pos1.positionName);
		System.out.println("acc1.username = " + acc1.username);
		System.out.println("gr1.creator.accountId = " + gr1.creator.accountId);
		System.out.println("ga1.group.groupName = " + ga1.group.groupName);
		System.out.println("type1.typeName = " + type1.typeName);
		System.out.println("cate1.categoryId = " + cate1.categoryId);
		System.out.println("que1.content = " + que1.content);
		System.out.println("ans1.isCorrect = " + ans1.isCorrect);
		System.out.println("ex1.title = " + ex1.title);
		System.out.println("eq1.question.createDate = " + eq1.question.createDate);
	}

	public static Date getDate(String dateString) throws ParseException {
		// Instantiating the SimpleDateFormat class
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// Parsing the given String to Date object
		Date date = formatter.parse(dateString);
		
		return date;
	}

}
