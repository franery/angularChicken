package com.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.chicken.persistencia.dao.DAO;
import com.chicken.persistencia.dao.IProveedorDAO;
import com.chicken.persistencia.model.ProveedorModel;

public class ProveedorDAOImpl extends DAO implements IProveedorDAO {

	@Transactional
	public ProveedorModel get(long id) {
		Session s = sessionFactory.openSession();
		ProveedorModel e = s.get(ProveedorModel.class, id);
		s.close();
		return e;
	}

	public List<ProveedorModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<ProveedorModel> lista = session.createQuery("from ProveedorModel").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(ProveedorModel proveedorModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(proveedorModel);
		tx.commit();
		s.close();
		
	}

	@Transactional
	public void modificar(ProveedorModel proveedorModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(proveedorModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(ProveedorModel.class,id));
		s.getTransaction().commit();
		s.close();
	}
}
