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
@DiscriminatorValue(value = "1")
public class Leader extends Employee {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "exp_in_year")
	private int expInYear;

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	@Override
	public String toString() {
		return "Leader [expInYear=" + expInYear + ", " + super.toString() + "]";
	}
}
