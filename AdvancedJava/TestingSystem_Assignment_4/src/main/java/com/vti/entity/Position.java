/**
 * 
 */
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

/**
 * @description This class is
 * @author baong
 * @create_date Feb 23, 2022
 * @version 1.0
 * 
 */

@Entity
@Table(name = "`position`")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "position_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "position_name", nullable = false)
	@Convert(converter = PositionNameConverter.class)
	private PositionName name;

	@OneToMany(mappedBy = "department")
	private List<Account> accounts;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name.getName() + "]";
	}

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
