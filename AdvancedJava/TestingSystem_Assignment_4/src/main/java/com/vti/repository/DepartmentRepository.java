package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

public class DepartmentRepository implements IDepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
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

	public List<DepartmentDTO> getAllDepartments() {
		return getAllDepartments(1, 9999, "", -1);
	}

	public List<DepartmentDTO> getAllDepartments(int pageNumber, int pageSize) {
		return getAllDepartments(pageNumber, pageSize, "", -1);
	}

	public List<DepartmentDTO> getAllDepartments(String search) {
		return getAllDepartments(1, 9999, search, -1);
	}

	public List<DepartmentDTO> getAllDepartments(int emulationPoints) {
		return getAllDepartments(1, 9999, "", emulationPoints);
	}

	@SuppressWarnings("unchecked")
	public List<DepartmentDTO> getAllDepartments(int pageNumber, int pageSize, String search, int emulationPoints) {
		Session session = null;
		List<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
//			Query<DepartmentDTO> query = session.createQuery(
//					"SELECT new com.vti.dto.DepartmentDTO(d.id, d.name, d.address) "
//							+ "FROM Department d "
//							+ "ORDER BY d.name ASC");
			Query<DepartmentDTO> query = session
					.createQuery("SELECT new com.vti.dto.DepartmentDTO(d.id, d.name, d.address) " + "FROM Department d "
							+ "WHERE d.name LIKE CONCAT('%', :nameParam, '%') "
							+ "AND d.emulationPoints > :emuPointParam " + "ORDER BY d.name ASC");

			query.setParameter("nameParam", search);
			query.setParameter("emuPointParam", emulationPoints);

			int offset = (pageNumber - 1) * pageSize;
			query.setFirstResult(offset);
			query.setMaxResults(pageSize);

			list = query.list();
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

	public int getTotalCount() {
		return getAllDepartments().size();
	}

	public int getTotalCount(String search) {
		return getAllDepartments(search).size();
	}

	public int getTotalCount(int emulationPoints) {
		return getAllDepartments(emulationPoints).size();
	}

	@SuppressWarnings("unchecked")
	public DepartmentDTO getDepartmentByID(int id) {
		Session session = null;
		DepartmentDTO department = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<DepartmentDTO> query = session
					.createQuery("SELECT new com.vti.dto.DepartmentDTO(d.id, d.name, d.address)"
							+ "FROM Department WHERE id = :idParameter");

			// set parameter
			query.setParameter("idParameter", id);

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

	@SuppressWarnings("unchecked")
	public DepartmentDTO getDepartmentByName(String name) {
		Session session = null;
		DepartmentDTO department = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<DepartmentDTO> query = session
					.createQuery("SELECT new com.vti.dto.DepartmentDTO(d.id, d.name, d.address)"
							+ "FROM Department WHERE name = :nameParameter");

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

	public void deleteDepartment(int[] idies) {
		for (int i = 0; i < idies.length; i++) {
			deleteDepartment(i);
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
		DepartmentDTO department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

	public boolean isDepartmentExistsByName(String name) {
		DepartmentDTO department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}
}
