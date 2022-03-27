package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Account;
import com.vti.form.AccountFilterForm;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class AccountSpecification {

	@SuppressWarnings("deprecation")
	public static Specification<Account> buildWhere(String search, AccountFilterForm filterForm) {
		Specification<Account> where = null;
		if (!StringUtils.isEmpty(search)) {
			search = search.trim();
			CustomSpecification username = new CustomSpecification("username", search);
			CustomSpecification departmentName = new CustomSpecification("departmentName", search);
			where = Specification.where(username).or(departmentName);
		}
		if (filterForm != null && filterForm.getDepartmentType() != null) {
			CustomSpecification departmentType = new CustomSpecification("departmentType", filterForm.getDepartmentType());
			where = where == null ? departmentType : where.and(departmentType);
		}
		return where;
	}
	
	@SuppressWarnings("serial")
	@RequiredArgsConstructor
	private static class CustomSpecification implements Specification<Account> {
		@NonNull
		private String field;
		@NonNull
		private Object value;
		
		@Override
		public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			if (field.equalsIgnoreCase("username")) {
				return criteriaBuilder.like(root.get("username"), "%" + value.toString() + "%");
			}
			if (field.equalsIgnoreCase("departmentName")) {
				return criteriaBuilder.like(root.get("department").get("name"), "%" + value.toString() + "%");
			}
			if (field.equalsIgnoreCase("departmentType")) {
				return criteriaBuilder.equal(root.get("department").get("type"), value);
			}
			
			return null;
		}
	}
}

