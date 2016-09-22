package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IVentaDAO;
import ar.com.escuelita.chicken.persistencia.dao.util.QueryParametrosUtil;
import ar.com.escuelita.chicken.persistencia.modelo.VentaModel;
import ar.com.escuelita.chicken.presentacion.filtro.VentaFiltro;

public class VentaDAOImpl extends DAO implements IVentaDAO {

	@Transactional
	public VentaModel get(long id) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", VentaDAOImpl.class, "get");
		Session s = sessionFactory.openSession();
		VentaModel e = s.get(VentaModel.class, id);
		s.close();
		Constantes.CHICKEN_LOG.info("Se obtuvo la Venta:  usuario: {}, proveedor: {}, cantidad: {}, precio: {}", e.getUsuario(), e.getProveedor(), e.getCantidad(), e.getPrecio());
		return e;
	}

	public List<VentaModel> listar() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", VentaDAOImpl.class, "listar");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<VentaModel> lista = session.createQuery("from VentaModel where borrado=false").list();
		session.close();
		Constantes.CHICKEN_LOG.info("Se listaron las Ventas");
		return lista;
	}
	
	public List<VentaModel> listar(VentaFiltro filtro) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", VentaDAOImpl.class, "listar");
		String query = "select venta from VentaModel as venta" 
				+ " join venta.proveedor as proveedor";
		QueryParametrosUtil qp = generarConsulta(query, filtro);
		List<VentaModel> lista = (List<VentaModel>) buscarUsandoQueryConParametros(qp);
		Constantes.CHICKEN_LOG.info("Se listaron las Ventas usando filtro:  proveedor: {}, cantidadDesde: {}, cantidadHasta: {}, fechaDesde: {}, fechaHasta: {}", filtro.getProveedorId(), filtro.getCantidadDesde(), filtro.getCantidadHasta(), filtro.getFechaDesde(), filtro.getFechaHasta());
		return lista;
	}

	@Transactional
	public void guardar(VentaModel ventaModel) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", VentaDAOImpl.class, "guardar");
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(ventaModel);
		tx.commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se guardo la Venta:  usuario: {}, proveedor: {}, cantidad: {}, precio: {}", ventaModel.getUsuario(), ventaModel.getProveedor(), ventaModel.getCantidad(), ventaModel.getPrecio());
	}

	@Transactional
	public void modificar(VentaModel ventaModel) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", VentaDAOImpl.class, "modificar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(ventaModel);
		s.getTransaction().commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se modifico la Venta:  usuario: {}, proveedor: {}, cantidad: {}, precio: {}", ventaModel.getUsuario(), ventaModel.getProveedor(), ventaModel.getCantidad(), ventaModel.getPrecio());
	}

	@Transactional
	public void borrar(long id) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", VentaDAOImpl.class, "borrar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		VentaModel model = s.get(VentaModel.class, id);
		model.setBorrado(true);
		s.update(model);
		s.getTransaction().commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se borro la Venta:  usuario: {}, proveedor: {}, cantidad: {}, precio: {}", model.getUsuario(), model.getProveedor(), model.getCantidad(), model.getPrecio());
	}
	
	private QueryParametrosUtil generarConsulta(String query, VentaFiltro filtro){
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", VentaDAOImpl.class, "generarConsulta");
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
