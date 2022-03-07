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
@Table(name = "`Position`")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;

	@NonNull
	@Column(name = "PositionName")
	@Enumerated(EnumType.STRING)
	private PositionName name;
	
	public enum PositionName {
		DEV("Dev"), TEST("Test"), SCRUM_MASTER("ScrumMaster"), PM("PM");

		private String name;

		public String getName() {
			return name;
		}

		public static PositionName toEnum(String name) {
			for (PositionName item : PositionName.values()) {
				if (item.getName().equals(name)) {
					return item;
				}
			}
			return null;
		}

		private PositionName(String name) {
			this.name = name;
		}
	}
}
