package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IVentaDAO;
import ar.com.escuelita.chicken.persistencia.dao.util.QueryParametrosUtil;
import ar.com.escuelita.chicken.persistencia.modelo.MovimientoModel;
import ar.com.escuelita.chicken.persistencia.modelo.VentaModel;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.VentaFiltro;

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
		List<VentaModel> lista = session.createQuery("from VentaModel where borrado=false").list();
		session.close();
		return lista;
	}
	
	public List<VentaModel> listar(VentaFiltro filtro) {
		String query = "select venta from VentaModel as venta" 
				+ " join venta.proveedor as proveedor";
		
		QueryParametrosUtil qp = generarConsulta(query, filtro);
		List<VentaModel> lista = (List<VentaModel>) buscarUsandoQueryConParametros(qp);
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
	
	private QueryParametrosUtil generarConsulta(String query, VentaFiltro filtro){
		QueryParametrosUtil qp = new QueryParametrosUtil();
		
		String str = " where venta.borrado=false ";
		
		/*   PROVEEDOR   */
		if (filtro.getProveedorId() != 0) {
			str += obtenerOperadorBusqueda(str) + " proveedor.id=" + filtro.getProveedorId();
		}
		
		/*   FECHA   */
		if (filtro.getFechaDesde() != null && !filtro.getFechaDesde().isEmpty() && filtro.getFechaHasta() != null && !filtro.getFechaHasta().isEmpty()) {
			str += obtenerOperadorBusqueda(str) + " venta.fecha between '" + filtro.getFechaDesde() + "' and '" + filtro.getFechaHasta() + "'";
		}
		
		/*   CANTIDAD   */
		if (filtro.getCantidadDesde() != null && !filtro.getCantidadDesde().isEmpty() && filtro.getCantidadHasta() != null && !filtro.getCantidadHasta().isEmpty()) {
			str += obtenerOperadorBusqueda(str) + " venta.cantidad between " + filtro.getCantidadDesde() + " and " + filtro.getCantidadHasta();
		}
		
		qp.setSql(query + str);
		return qp;
	}
}
