package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IVentaDAO;
import ar.com.escuelita.chicken.persistencia.modelo.VentaModel;

public class VentaDAOImpl extends DAO implements IVentaDAO {

	@Transactional
	public VentaModel get(long id) {
		Session s = sessionFactory.openSession();
		VentaModel e = s.get(VentaModel.class, id);
		s.close();
		return e;
	}

	public List<VentaModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<VentaModel> lista = session.createQuery("from VentaModel").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(VentaModel ventaModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(ventaModel);
		tx.commit();
		s.close();
		
	}

	@Transactional
	public void modificar(VentaModel ventaModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(ventaModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(VentaModel.class,id));
		s.getTransaction().commit();
		s.close();
	}
}
