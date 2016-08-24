package com.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.chicken.persistencia.dao.DAO;
import com.chicken.persistencia.dao.IUsuarioDAO;
import com.chicken.persistencia.model.UsuarioModel;

public class UsuarioDAOImpl extends DAO implements IUsuarioDAO {

	@Transactional
	public UsuarioModel get(long id) {
		Session s = sessionFactory.openSession();
		UsuarioModel e = s.get(UsuarioModel.class, id);
		s.close();
		return e;
	}

	public List<UsuarioModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UsuarioModel> lista = session.createQuery("from UsuarioModel").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(UsuarioModel usuarioModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(usuarioModel);
		tx.commit();
		s.close();
		
	}

	@Transactional
	public void modificar(UsuarioModel usuarioModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(usuarioModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(UsuarioModel.class,id));
		s.getTransaction().commit();
		s.close();
	}
}
