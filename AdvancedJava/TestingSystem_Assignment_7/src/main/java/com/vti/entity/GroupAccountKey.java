package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Embeddable
public class GroupAccountKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Column(name = "GroupID", nullable = false)
	private Short groupId;
	
	@NonNull
	@Column(name = "AccountID", nullable = false)
	private Short accountId;
}
