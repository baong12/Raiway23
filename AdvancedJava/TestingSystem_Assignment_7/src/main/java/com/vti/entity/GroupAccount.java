package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "GroupAccount")
public class GroupAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private GroupAccountKey id;
	
	@ManyToOne
	@MapsId("GroupID")
	@JoinColumn(name = "GroupID")
	private Group group;

	@ManyToOne
	@MapsId("AccountID")
	@JoinColumn(name = "AccountID")
	private Account account;
	
	@Column(name = "JoinDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date joinDate;
}
