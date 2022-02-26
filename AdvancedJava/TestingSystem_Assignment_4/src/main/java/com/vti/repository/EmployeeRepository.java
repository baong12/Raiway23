package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;

public class EmployeeRepository {

	private HibernateUtils hibernateUtils;

	public EmployeeRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		Session session = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list.addAll(session.createQuery("FROM Leader").list());
			list.addAll(session.createQuery("FROM Member").list());
		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
	
	public Employee getEmployeeByID(int id) {
		Session session = null;
		Employee employee = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department by id
			employee = session.get(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;
	}

	public void createEmployee(Employee employee) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(employee);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
