package com.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.chicken.persistencia.dao.DAO;
import com.chicken.persistencia.dao.IMovimientoDAO;
import com.chicken.persistencia.model.MovimientoModel;

public class MovimientoDAOImpl extends DAO implements IMovimientoDAO {
	
	@Transactional
	public MovimientoModel get(long id) {
		Session s = sessionFactory.openSession();
		MovimientoModel e = s.get(MovimientoModel.class, id);
		s.close();
		return e;
	}

	public List<MovimientoModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<MovimientoModel> lista = session.createQuery("from MovimientoModel").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(MovimientoModel movimientoModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(movimientoModel);
		tx.commit();
		s.close();
		
	}

	@Transactional
	public void modificar(MovimientoModel movimientoModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(movimientoModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(MovimientoModel.class,id));
		s.getTransaction().commit();
		s.close();
	}
}
