package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "`Position`")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "`PositionName`", nullable = false)
	@Convert(converter = PositionNameConvert.class)
	private PositionName name;
	
	@OneToMany(mappedBy = "position")
	private List<Account> accounts;
	
	public enum PositionName {
		DEV("Dev"), TEST("Test"), ScrumMaster("ScrumMaster"), PM("PM");

		private String value;

		private PositionName(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static PositionName toEnum(String sqlValue) {
			for (PositionName name : PositionName.values()) {
				if (name.getValue().equals(sqlValue)) {
					return name;
				}
			}
			return null;
		}
	}
}
