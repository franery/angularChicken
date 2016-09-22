package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IDepositoDAO;
import ar.com.escuelita.chicken.persistencia.dao.util.QueryParametrosUtil;
import ar.com.escuelita.chicken.persistencia.modelo.DepositoModel;
import ar.com.escuelita.chicken.presentacion.filtro.DepositoFiltro;

public class DepositoDAOImpl extends DAO implements IDepositoDAO {

	@Transactional
	public DepositoModel get(long id) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositoDAOImpl.class, "get");
		Session s = sessionFactory.openSession();
		DepositoModel e = s.get(DepositoModel.class, id);
		s.close();
		Constantes.CHICKEN_LOG.info("Se obtuvo el Deposito: {}",e.getNombre());
		return e;
	}

	public List<DepositoModel> listar() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositoDAOImpl.class, "listar");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DepositoModel> lista = session.createQuery("from DepositoModel where borrado=false").list();
		session.close();
		Constantes.CHICKEN_LOG.info("Se listaron los Depositos");
		return lista;
	}

	@Transactional
	public void guardar(DepositoModel depositoModel) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositoDAOImpl.class, "guardar");
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(depositoModel);
		tx.commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se guardo el Deposito: {}",depositoModel.getNombre());
	}

	@Transactional
	public void modificar(DepositoModel depositoModel) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositoDAOImpl.class, "modificar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(depositoModel);
		s.getTransaction().commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se modifico el Deposito: {}",depositoModel.getNombre());
	}

	@Transactional
	public void borrar(long id) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositoDAOImpl.class, "borrar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		DepositoModel model = s.get(DepositoModel.class, id);
		model.setBorrado(true);
		s.update(model);
		s.getTransaction().commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se borro el Deposito: {}",model.getNombre());
	}
	
	public List<DepositoModel> listar(DepositoFiltro filtro){
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositoDAOImpl.class, "listar");
		String query = "select deposito from DepositoModel as deposito";
		QueryParametrosUtil qp = generarConsulta(query, filtro);
		List<DepositoModel> lista = (List<DepositoModel>) buscarUsandoQueryConParametros(qp);
		Constantes.CHICKEN_LOG.info("Se listaron los Depositos utilizando filtro:  nombre: {}, id: {}", filtro.getDepositoNombre(), filtro.getDepositoId());
		return lista;
	}

	private QueryParametrosUtil generarConsulta(String query, DepositoFiltro filtro){
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositoDAOImpl.class, "generarConsulta");
		QueryParametrosUtil qp = new QueryParametrosUtil();
		String str = " where deposito.borrado=false ";
		
		/*   Nombre   */
		if (filtro.getDepositoNombre() != null) {
			str += obtenerOperadorBusqueda(str) + " deposito.nombre like '%" + filtro.getDepositoNombre() + "%'";
		}
		
		/*   Id   */
		if (filtro.getDepositoId() != 0) {
			str += obtenerOperadorBusqueda(str) + " deposito.id=" + filtro.getDepositoId();
		}
		qp.setSql(query + str);
		return qp;
	}
}
