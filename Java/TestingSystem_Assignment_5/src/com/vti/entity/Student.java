package com.vti.entity;

public class Student implements IStudent {
	private Integer id;
	private String name;
	private Integer group;
	
	/**
	 * @param id
	 * @param name
	 * @param group
	 */
	public Student(Integer id, String name, Integer group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	@Override
	public void diemDanh() {
		System.out.println(name + " điểm danh");
	}

	@Override
	public void hocBai() {
		System.out.println(name + " đang học bài");
	}

	@Override
	public void diDonVeSinh() {
		System.out.println(name + " đang đi dọn vệ sinh");
	}

}
