package com.vti.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class DepartmentSpecification {

	@SuppressWarnings("deprecation")
	public static Specification<Department> buildWhere(String search, DepartmentFilterForm filterForm) {
		Specification<Department> where = null;
		if (!StringUtils.isEmpty(search)) {
			search = search.trim();
			CustomSpecification name = new CustomSpecification("name", search);
			where = Specification.where(name);
		}
		if (filterForm != null && filterForm.getMinId() != null) {
			CustomSpecification minId = new CustomSpecification("minId", filterForm.getMinId());
			where = where == null ? minId : where.and(minId);
		}
		if (filterForm != null && filterForm.getMaxId() != null) {
			CustomSpecification maxId = new CustomSpecification("maxId", filterForm.getMaxId());
			where = where == null ? maxId : where.and(maxId);
		}
		if (filterForm != null && filterForm.getMinTotalMember() != null) {
			CustomSpecification minTotalMember = new CustomSpecification("minTotalMember",
					filterForm.getMinTotalMember());
			where = where == null ? minTotalMember : where.and(minTotalMember);
		}
		if (filterForm != null && filterForm.getMaxTotalMember() != null) {
			CustomSpecification maxTotalMember = new CustomSpecification("maxTotalMember",
					filterForm.getMaxTotalMember());
			where = where == null ? maxTotalMember : where.and(maxTotalMember);
		}
		if (filterForm != null && filterForm.getMinYear() != null) {
			CustomSpecification minYear = new CustomSpecification("minYear", filterForm.getMinYear());
			where = where == null ? minYear : where.and(minYear);
		}
		if (filterForm != null && filterForm.getMaxYear() != null) {
			CustomSpecification maxYear = new CustomSpecification("maxYear", filterForm.getMaxYear());
			where = where == null ? maxYear : where.and(maxYear);
		}
		if (filterForm != null && filterForm.getType() != null) {
			CustomSpecification type = new CustomSpecification("type", filterForm.getType());
			where = where == null ? type : where.and(type);
		}
		if (filterForm != null && filterForm.getMinAccountCount() != null) {
			CustomSpecification minAccountCount = new CustomSpecification("minAccountCount", filterForm.getMinAccountCount());
			where = where == null ? minAccountCount : where.and(minAccountCount);
		}
		if (filterForm != null && filterForm.getMaxAccountCount() != null) {
			CustomSpecification maxAccountCount = new CustomSpecification("maxAccountCount", filterForm.getMaxAccountCount());
			where = where == null ? maxAccountCount : where.and(maxAccountCount);
		}
		
		return where;
	}

	@SuppressWarnings("serial")
	@RequiredArgsConstructor
	private static class CustomSpecification implements Specification<Department> {
		@NonNull
		private String field;
		@NonNull
		private Object value;

		@Override
		public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			if (field.equalsIgnoreCase("name")) {
				return criteriaBuilder.like(root.get("name"), "%" + value.toString() + "%");
			}
			if (field.equalsIgnoreCase("minId")) {
				return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());
			}
			if (field.equalsIgnoreCase("maxId")) {
				return criteriaBuilder.lessThanOrEqualTo(root.get("id"), value.toString());
			}
			if (field.equalsIgnoreCase("minTotalMember")) {
				return criteriaBuilder.greaterThanOrEqualTo(root.get("totalMember"), value.toString());
			}
			if (field.equalsIgnoreCase("maxTotalMember")) {
				return criteriaBuilder.lessThanOrEqualTo(root.get("totalMember"), value.toString());
			}
			if (field.equalsIgnoreCase("minCreatedDate")) {
				return criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate").as(java.sql.Date.class), (Date) value);
			}
			if (field.equalsIgnoreCase("maxCreatedDate")) {
				return criteriaBuilder.lessThanOrEqualTo(root.get("createdDate").as(java.sql.Date.class), (Date) value);
			}
			if (field.equalsIgnoreCase("minYear")) {
				return criteriaBuilder.greaterThanOrEqualTo(
						criteriaBuilder.function("YEAR", Integer.class, root.get("createdDate")), (Integer) value);
			}
			if (field.equalsIgnoreCase("maxYear")) {
				return criteriaBuilder.lessThanOrEqualTo(
						criteriaBuilder.function("YEAR", Integer.class, root.get("createdDate")), (Integer) value);
			}
			if (field.equalsIgnoreCase("type")) {
				return criteriaBuilder.equal(root.get("type"), value);
			}
			if (field.equalsIgnoreCase("minAccountCount")) {
				return criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.size(root.get("accounts")), (Integer) value);
			}
			if (field.equalsIgnoreCase("maxAccountCount")) {
				return criteriaBuilder.lessThanOrEqualTo(criteriaBuilder.size(root.get("accounts")), (Integer) value);
			}
			
			return null;
		}
	}
}
