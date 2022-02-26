package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;

public class GroupRepository {

	private HibernateUtils hibernateUtils;

	public GroupRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public void createGroup(Group group) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(group);
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
	public List<Group> getAllGroups() {
		Session session = null;
		List<Group> list = new ArrayList<Group>();
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = session.createQuery("FROM Group").list();
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

	public Group getGroupByID(short id) {
		Session session = null;
		Group group = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department by id
			group = session.get(Group.class, id);
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
		return group;
	}

	@SuppressWarnings("unchecked")
	public Group getGroupByName(String name) {
		Session session = null;
		Group group = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<Group> query = session.createQuery("FROM group WHERE group_name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			group = query.uniqueResult();
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
		return group;
	}

	public void updateGroup(short id, String newName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Group group = session.load(Group.class, id);

			// update
			group.setName(newName);

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

	public void updateGroup(Group group) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(group);
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

	public void deleteGroup(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Group group = session.load(Group.class, id);

			// delete
			session.delete(group);
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

	public boolean isGroupExistsByID(short id) {
		// get department
		Group group = getGroupByID(id);

		// return result
		if (group == null) {
			return false;
		}

		return true;
	}

	public boolean isGroupExistsByName(String name) {
		Group group = getGroupByName(name);

		if (group == null) {
			return false;
		}
		return true;
	}
}
