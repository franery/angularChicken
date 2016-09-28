package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IPermisoDAO;
import ar.com.escuelita.chicken.persistencia.modelo.PermisoModel;

public class PermisoDAOImpl extends DAO implements IPermisoDAO {

	@Transactional
	public PermisoModel get(long id) {
		Session s = sessionFactory.openSession();
		PermisoModel e = s.get(PermisoModel.class, id);
		s.close();
		return e;
	}

	public List<PermisoModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<PermisoModel> lista = session.createQuery("from PermisoModel").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(PermisoModel permisoModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(permisoModel);
		tx.commit();
		s.close();
	}

	@Transactional
	public void modificar(PermisoModel permisoModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(permisoModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(PermisoModel.class,id));
		s.getTransaction().commit();
		s.close();
	}
}