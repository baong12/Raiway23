/**
 * 
 */
package com.vti.dto;

/**
 * @description This class is
 * @author baong
 * @create_date Mar 3, 2022
 * @version 1.0
 * 
 */
public class DepartmentDTO {
	private Integer id;
	
	private String name;
	
	private String address;

	public DepartmentDTO() {
	}

	public DepartmentDTO(Integer id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
