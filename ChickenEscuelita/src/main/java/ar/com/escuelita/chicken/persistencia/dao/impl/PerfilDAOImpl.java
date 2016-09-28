package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IPerfilDAO;
import ar.com.escuelita.chicken.persistencia.dao.util.QueryParametrosUtil;
import ar.com.escuelita.chicken.persistencia.modelo.PerfilModel;
import ar.com.escuelita.chicken.presentacion.filtro.PerfilFiltro;

public class PerfilDAOImpl extends DAO implements IPerfilDAO {

	@Transactional
	public PerfilModel get(long id) {
		Session s = sessionFactory.openSession();
		PerfilModel e = s.get(PerfilModel.class, id);
		s.close();
		return e;
	}

	public List<PerfilModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<PerfilModel> lista = session.createQuery("from PerfilModel").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(PerfilModel perfilModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(perfilModel);
		tx.commit();
		s.close();
	}

	@Transactional
	public void modificar(PerfilModel perfilModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(perfilModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(PerfilModel.class,id));
		s.getTransaction().commit();
		s.close();
	}
	
	
	@Override
	public List<PerfilModel> listar(PerfilFiltro filtro) {
		QueryParametrosUtil qp = new QueryParametrosUtil();
		String query = "select perfil from PerfilModel as perfil where perfil.id!=" + filtro.getPerfilId();
		qp.setSql(query);
		List<PerfilModel> lista = (List<PerfilModel>) buscarUsandoQueryConParametros(qp);
		return lista;
	}
	
}