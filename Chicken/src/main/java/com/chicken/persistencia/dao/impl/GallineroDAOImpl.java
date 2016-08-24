package com.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.chicken.persistencia.dao.DAO;
import com.chicken.persistencia.dao.IGallineroDAO;
import com.chicken.persistencia.model.GallineroModel;

public class GallineroDAOImpl extends DAO implements IGallineroDAO {
	
	@Transactional
	public GallineroModel get(long id) {
		Session s = sessionFactory.openSession();
		GallineroModel e = s.get(GallineroModel.class, id);
		s.close();
		return e;
	}

	public List<GallineroModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<GallineroModel> lista = session.createQuery("from GallineroModel").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(GallineroModel gallineroModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(gallineroModel);
		tx.commit();
		s.close();
		
	}

	@Transactional
	public void modificar(GallineroModel gallineroModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(gallineroModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(GallineroModel.class,id));
		s.getTransaction().commit();
		s.close();
	}
}
