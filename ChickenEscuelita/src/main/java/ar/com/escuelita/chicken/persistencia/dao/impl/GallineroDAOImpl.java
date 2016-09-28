package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IGallineroDAO;
import ar.com.escuelita.chicken.persistencia.dao.util.QueryParametrosUtil;
import ar.com.escuelita.chicken.persistencia.modelo.GallineroModel;
import ar.com.escuelita.chicken.presentacion.filtro.GallineroFiltro;

public class GallineroDAOImpl extends DAO implements IGallineroDAO {
	
	@Transactional
	public GallineroModel get(long id) {
		Session s = sessionFactory.openSession();
		GallineroModel e = s.get(GallineroModel.class, id);
		s.close();
		return e;
	}

	public List<GallineroModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<GallineroModel> lista = session.createQuery("from GallineroModel where borrado=false").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(GallineroModel gallineroModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(gallineroModel);
		tx.commit();
		s.close();
	}

	@Transactional
	public void modificar(GallineroModel gallineroModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(gallineroModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		GallineroModel model = s.get(GallineroModel.class, id);
		model.setBorrado(true);
		s.update(model);
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public List<GallineroModel> listar(GallineroFiltro gallineroFiltro) {
		String query = "select g from GallineroModel as g" 
				+ " join g.usuario as u";
		QueryParametrosUtil qp = generarConsulta(query, gallineroFiltro);
		List<GallineroModel> list = (List<GallineroModel>) buscarUsandoQueryConParametros(qp);
		return list;
	}
	
	private QueryParametrosUtil generarConsulta(String query, GallineroFiltro filtro){
		QueryParametrosUtil qp = new QueryParametrosUtil();
		String str = " where g.borrado=false ";
		/*   ID PRODUCTOR   */
		if (filtro.getUsuarioId() != -1) {
			str += obtenerOperadorBusqueda(str) + " u.id=" + filtro.getUsuarioId();
		}
		qp.setSql(query + str);
		return qp;
	}
}
