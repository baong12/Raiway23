package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {
		Session session = null;
		List<Account> list = new ArrayList<Account>();
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = session.createQuery("FROM Account").list();
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

	public Account getAccountByID(short id) {
		Session session = null;
		Account account = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department by id
			account = session.get(Account.class, id);
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
		return account;
	}

	public void createAccount(Account account) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(account);
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
