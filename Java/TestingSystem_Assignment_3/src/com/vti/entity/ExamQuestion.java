package com.vti.entity;

public class ExamQuestion {
	private Exam exam;
	private Question question;

	public ExamQuestion() {
	}

	/**
	 * @return the exam
	 */
	public Exam getExam() {
		return exam;
	}

	/**
	 * @param exam the exam to set
	 */
	public void setExam(Exam exam) {
		this.exam = exam;
	}

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
}