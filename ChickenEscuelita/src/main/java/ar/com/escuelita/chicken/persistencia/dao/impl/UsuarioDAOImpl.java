package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.dao.util.QueryParametrosUtil;
import ar.com.escuelita.chicken.persistencia.modelo.MovimientoModel;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;

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
	
	
	
	@Override
	public HashMap<UsuarioModel, Long> getProduccionTotal() {

		String query = "SELECT user, SUM(mov.cantidad) FROM MovimientoModel as mov"
				+ " join mov.gallinero as g"
				+ " join g.usuario as user"
				+ " group by user.id";
		
		QueryParametrosUtil qp = new QueryParametrosUtil();
		qp.setSql(query);
		List list = buscarUsandoQueryConParametros(qp);
		System.out.println("pasaba por aca...");
		return null;
	}
//	
//	private QueryParametrosUtil generarConsulta(String query, MovimientoFiltro filtro){
//		QueryParametrosUtil qp = new QueryParametrosUtil();
//		
//		String str = "";
//		
//		/*   ID PRODUCTOR   */
//		if (filtro.getProductorId() != -1) {
//			str += " where u.id=" + filtro.getProductorId();
//		}
//		
//		/*   CANTIDAD  DESDE */
//		if (filtro.getCantidadDesde() != null && !filtro.getCantidadDesde().isEmpty()) {
//			str += obtenerOperadorBusqueda(str) + " mov.cantidad>=" + filtro.getCantidadDesde();
//		}
//		
//		/*   CANTIDAD  HASTA*/
//		if (filtro.getCantidadHasta() != null && !filtro.getCantidadHasta().isEmpty()) {
//			str += obtenerOperadorBusqueda(str) + " mov.cantidad<=" + filtro.getCantidadHasta();
//		}
//		
//		/*   FECHA DESDE  */
//		if (filtro.getFechaDesde() != null && !filtro.getFechaDesde().isEmpty()) {
//			str += obtenerOperadorBusqueda(str) + " mov.fecha>='" + filtro.getFechaDesde() + "'";
//		}
//		
//		/*   FECHA HASTA*/
//		if (filtro.getFechaHasta() != null && !filtro.getFechaHasta().isEmpty()) {
//			str += obtenerOperadorBusqueda(str) + " mov.fecha<='" + filtro.getFechaHasta() + "'";
//		}
//		
//		qp.setSql(query + str);
//		return qp;
//	}
//	
//	
	
	
}
