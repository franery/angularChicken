package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IParametroDAO;
import ar.com.escuelita.chicken.persistencia.modelo.DepositoModel;
import ar.com.escuelita.chicken.persistencia.modelo.ParametroModel;

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
		List<ParametroModel> lista = session.createQuery("from ParametroModel where borrado=false").list();
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
		ParametroModel model = s.get(ParametroModel.class, id);
		model.setBorrado(true);
		s.update(model);
		//s.delete(s.get(ParametroModel.class,id));
		s.getTransaction().commit();
		s.close();
	}
}
