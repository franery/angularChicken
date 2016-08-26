package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IDepositoDAO;
import ar.com.escuelita.chicken.persistencia.modelo.DepositoModel;

public class DepositoDAOImpl extends DAO implements IDepositoDAO {

	@Transactional
	public DepositoModel get(long id) {
		Session s = sessionFactory.openSession();
		DepositoModel e = s.get(DepositoModel.class, id);
		s.close();
		return e;
	}

	public List<DepositoModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DepositoModel> lista = session.createQuery("from DepositoModel").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(DepositoModel depositoModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(depositoModel);
		tx.commit();
		s.close();
		
	}

	@Transactional
	public void modificar(DepositoModel depositoModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(depositoModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(DepositoModel.class,id));
		s.getTransaction().commit();
		s.close();
	}

}
