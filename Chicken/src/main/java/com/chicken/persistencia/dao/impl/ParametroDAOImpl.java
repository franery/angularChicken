package com.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.chicken.persistencia.dao.DAO;
import com.chicken.persistencia.dao.IParametroDAO;
import com.chicken.persistencia.model.ParametroModel;

public class ParametroDAOImpl extends DAO implements IParametroDAO {

	@Transactional
	public ParametroModel get(long id) {
		Session s = sessionFactory.openSession();
		ParametroModel e = s.get(ParametroModel.class, id);
		s.close();
		return e;
	}

	public List<ParametroModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<ParametroModel> lista = session.createQuery("from ParametroModel").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(ParametroModel parametroModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(parametroModel);
		tx.commit();
		s.close();
		
	}

	@Transactional
	public void modificar(ParametroModel parametroModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(parametroModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(ParametroModel.class,id));
		s.getTransaction().commit();
		s.close();
	}
}
