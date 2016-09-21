package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IProveedorDAO;
import ar.com.escuelita.chicken.persistencia.modelo.ProveedorModel;

public class ProveedorDAOImpl extends DAO implements IProveedorDAO {

	@Transactional
	public ProveedorModel get(long id) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedorDAOImpl.class, "get");
		Session s = sessionFactory.openSession();
		ProveedorModel e = s.get(ProveedorModel.class, id);
		s.close();
		return e;
	}

	public List<ProveedorModel> listar() {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedorDAOImpl.class, "listar");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<ProveedorModel> lista = session.createQuery("from ProveedorModel where borrado=false").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(ProveedorModel proveedorModel) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedorDAOImpl.class, "guardar");
		
		System.out.println("ProveedorDAOImpl.guardar");
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(proveedorModel);
		tx.commit();
		s.close();
		
	}

	@Transactional
	public void modificar(ProveedorModel proveedorModel) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedorDAOImpl.class, "modificar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(proveedorModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedorDAOImpl.class, "borrar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		ProveedorModel model = s.get(ProveedorModel.class, id);
		model.setBorrado(true);
		s.update(model);
		s.getTransaction().commit();
		s.close();
	}
}
