package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Salary")
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "SalaryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@NonNull
	@Column(name = "SalaryName")
	@Enumerated(EnumType.STRING)
	private SalaryName name;
	
	public enum SalaryName {
		DEV("600"), TEST("700"), SCRUM_MASTER("1500"), PM("2000");

		private String name;

		public String getName() {
			return name;
		}

		public static SalaryName toEnum(String name) {
			for (SalaryName item : SalaryName.values()) {
				if (item.getName().equals(name)) {
					return item;
				}
			}
			return null;
		}

		private SalaryName(String name) {
			this.name = name;
		}
	}
}
