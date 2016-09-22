package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IParametroDAO;
import ar.com.escuelita.chicken.persistencia.modelo.ParametroModel;

public class ParametroDAOImpl extends DAO implements IParametroDAO {

	@Transactional
	public ParametroModel get(long id) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", ParametroDAOImpl.class, "get");
		Session s = sessionFactory.openSession();
		ParametroModel e = s.get(ParametroModel.class, id);
		s.close();
		Constantes.CHICKEN_LOG.info("Se obtuvo el Parametro: {}", e.getDescripcion());
		return e;
	}

	public List<ParametroModel> listar() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", ParametroDAOImpl.class, "listar");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<ParametroModel> lista = session.createQuery("from ParametroModel where borrado=false").list();
		session.close();
		Constantes.CHICKEN_LOG.info("Se listaron los Parametros");
		return lista;
	}

	@Transactional
	public void guardar(ParametroModel parametroModel) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", ParametroDAOImpl.class, "guardar");
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(parametroModel);
		tx.commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se guardo el Parametro: {}", parametroModel.getDescripcion());
	}

	@Transactional
	public void modificar(ParametroModel parametroModel) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", ParametroDAOImpl.class, "modificar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(parametroModel);
		s.getTransaction().commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se modifico el Parametro: {}", parametroModel.getDescripcion());
	}

	@Transactional
	public void borrar(long id) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", ParametroDAOImpl.class, "borrar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		ParametroModel model = s.get(ParametroModel.class, id);
		model.setBorrado(true);
		s.update(model);
		s.getTransaction().commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se borro el Parametro: {}", model.getDescripcion());
	}
}
