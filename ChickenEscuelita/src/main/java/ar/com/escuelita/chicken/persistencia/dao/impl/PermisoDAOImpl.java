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
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PermisoDAOImpl.class, "get");
		Session s = sessionFactory.openSession();
		PermisoModel e = s.get(PermisoModel.class, id);
		s.close();
		Constantes.CHICKEN_LOG.info("Se obtuvo el Permiso:  modulo: {}, operacion: {}", e.getModulo(), e.getOperacion());
		return e;
	}

	public List<PermisoModel> listar() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PermisoDAOImpl.class, "listar");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<PermisoModel> lista = session.createQuery("from PermisoModel").list();
		session.close();
		Constantes.CHICKEN_LOG.info("Se listaron los Permisos");
		return lista;
	}

	@Transactional
	public void guardar(PermisoModel permisoModel) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PermisoDAOImpl.class, "guardar");
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(permisoModel);
		tx.commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se guardo el Permiso:  modulo: {}, operacion: {}", permisoModel.getModulo(), permisoModel.getOperacion());
	}

	@Transactional
	public void modificar(PermisoModel permisoModel) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PermisoDAOImpl.class, "modificar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(permisoModel);
		s.getTransaction().commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se modifico el Permiso:  modulo: {}, operacion: {}", permisoModel.getModulo(), permisoModel.getOperacion());
	}

	@Transactional
	public void borrar(long id) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PermisoDAOImpl.class, "borrar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(PermisoModel.class,id));
		s.getTransaction().commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se borro el Permiso:  id: {}", id);
	}
}