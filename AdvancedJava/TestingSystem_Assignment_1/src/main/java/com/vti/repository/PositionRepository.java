package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;

public class PositionRepository {

	private HibernateUtils hibernateUtils;

	public PositionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	/**
	 * @param positionCreate
	 */
	public void createPosition(Position position) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(position);
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
	
	@SuppressWarnings("unchecked")
	public List<Position> getAllPositions() {
		Session session = null;
		List<Position> list = new ArrayList<Position>();
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = session.createQuery("FROM Position").list();
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

	public Position getPositionByID(short id) {
		Session session = null;
		Position position = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department by id
			position = session.get(Position.class, id);
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
		return position;
	}
}
