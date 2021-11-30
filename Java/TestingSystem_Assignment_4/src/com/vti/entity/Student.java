package com.vti.entity;

/**
 * @author baong
 *
 */
public class Student {
	private int id;
	private String name;
	private String homeTown;
	private float score;

	/**
	 * @param name     họ tên sinh viên
	 * @param homeTown quê quán của sinh viên
	 */
	public Student(String name, String homeTown) {
		super();
		this.id = 0;
		this.name = name;
		this.homeTown = homeTown;
		this.score = 0;
	}

	/**
	 * @param grade điểm của sinh viên
	 */
	public void setScore(float grade) {
		this.score = grade >= 0 && grade <= 10 ? grade : 0;
	}
	
	/**
	 * @param amount số điểm cộng thêm
	 */
	public void addScore(float amount) {
		if (this.score + amount <= 10) {
			this.score += amount;
		} else {
			this.score = 10;
		}
	}
	
//	Method để in ra thông tin của sinh viên bao gồm có tên,
//	điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm >
//	4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0
//	thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)
	public String getInfo(boolean isSysout) {
		String rank = "N/A";
		if (score < 4.0) {
			rank = "Yếu";
		} else if (score < 6.0) {
			rank = "Trung bình";
		} else if (score < 8.0) {
			rank = "Khá";
		} else {
			rank = "Giỏi";
		}
		
		String output = "Student [name=" + name + ", rank=" + rank + "]";
		
		if (isSysout) {
			System.out.println(output);
		}
		return output;
	}
}
