package testing_system;

import java.util.Date;

public class Question {
	public int questionId;
	public String content;
	public CategoryQuestion category;
	public TypeQuestion type;
	public Account creator;
	public Date createDate;

	public Question() {
	}
}