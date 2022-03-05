package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

@Repository
public class DepartmentRepository implements IDepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Department> getAllDepartments(int page, int size, String filterBy, String filter, String sortBy,
			boolean isAsc) {
		Session session = null;
		List<Department> list = new ArrayList<Department>();
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create criteria
			Criteria criteria = session.createCriteria(Department.class);
			if (filterBy != null && filter != null) {
				String[] filterBies = filterBy.split(",");
				String[] filters = filter.split(",");
				for (int i = 0; i < filters.length; i++) {
					 if (filterBies[i].isBlank() || filterBies[i].isEmpty()) {
						 continue;
					 }
					 if (filterBies[i].equals("id")) {
						 criteria.add(Restrictions.idEq(Integer.parseInt(filters[i])));
					 } else {
						 criteria.add(Restrictions.ilike(filterBies[i], "%" + filters[i] + "%"));
					 }
				}
			}
			if (sortBy != null && !sortBy.isBlank() && !sortBy.isEmpty()) {
				if (isAsc) {
					criteria.addOrder(Order.asc(sortBy));
				} else {
					criteria.addOrder(Order.desc(sortBy));
				}
			}
			
			int offset = (page - 1) * size;
			criteria.setFirstResult(offset);
			criteria.setMaxResults(size);
			
			list = criteria.list();
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

	public Department getDepartmentByID(int id) {
		Session session = null;
		Department department = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department by id
			department = session.get(Department.class, id);
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
		return department;
	}

	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {
		Session session = null;
		Department department = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			department = query.uniqueResult();
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
		return department;
	}

	public void createDepartment(Department department) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);
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

	public void updateDepartment(int id, String newName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = session.load(Department.class, id);

			// update
			department.setName(newName);

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

	public void updateDepartment(Department department) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(department);
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

	public void deleteDepartment(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// delete
			session.delete(department);
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

	public boolean isDepartmentExistsByID(int id) {
		// get department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}
}
