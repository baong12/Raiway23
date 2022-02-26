/**
 * 
 */
package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @description This class is
 * @author baong
 * @create_date Feb 27, 2022
 * @version 1.0
 * 
 */
@Entity
@DiscriminatorValue(value = "0")
public class Member extends Employee {
	private static final long serialVersionUID = 1L;

	@Column(name = "skill", length = 45)
	private String skill;

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Member [skill=" + skill + ", " + super.toString() + "]";
	}
}
