package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IDepositoDAO;
import ar.com.escuelita.chicken.persistencia.dao.util.QueryParametrosUtil;
import ar.com.escuelita.chicken.persistencia.modelo.DepositoModel;
import ar.com.escuelita.chicken.persistencia.modelo.VentaModel;
import ar.com.escuelita.chicken.presentacion.filtro.DepositoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.VentaFiltro;

public class DepositoDAOImpl extends DAO implements IDepositoDAO {

	@Transactional
	public DepositoModel get(long id) {
		Session s = sessionFactory.openSession();
		DepositoModel e = s.get(DepositoModel.class, id);
		s.close();
		return e;
	}

	public List<DepositoModel> listar() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DepositoModel> lista = session.createQuery("from DepositoModel where borrado=false").list();
		session.close();
		return lista;
	}

	@Transactional
	public void guardar(DepositoModel depositoModel) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(depositoModel);
		tx.commit();
		s.close();
		
	}

	@Transactional
	public void modificar(DepositoModel depositoModel) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(depositoModel);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public void borrar(long id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		DepositoModel model = s.get(DepositoModel.class, id);
		model.setBorrado(true);
		s.update(model);
		//s.delete(s.get(DepositoModel.class,id));
		s.getTransaction().commit();
		s.close();
	}
	
	public List<DepositoModel> listar(DepositoFiltro filtro){
		String query = "select deposito from DepositoModel as deposito";
		
		QueryParametrosUtil qp = generarConsulta(query, filtro);
		List<DepositoModel> lista = (List<DepositoModel>) buscarUsandoQueryConParametros(qp);
		return lista;

	}


	private QueryParametrosUtil generarConsulta(String query, DepositoFiltro filtro){
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
