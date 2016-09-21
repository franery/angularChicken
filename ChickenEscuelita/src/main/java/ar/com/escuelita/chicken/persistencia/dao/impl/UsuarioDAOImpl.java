package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.excepciones.PersistenciaExcepcion;
import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.dao.util.QueryParametrosUtil;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;

public class UsuarioDAOImpl extends DAO implements IUsuarioDAO {

	@Transactional
	public UsuarioModel get(long id) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "get");
		Session s = sessionFactory.openSession();
		UsuarioModel e = s.get(UsuarioModel.class, id);
		s.close();
		return e;
	}

	public List<UsuarioModel> listar() {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "listar");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UsuarioModel> lista = session.createQuery("from UsuarioModel where borrado=false").list();
		session.close();
		return lista;
	}

	public List<UsuarioModel> listarProductores(){
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "listarProductores");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UsuarioModel> lista = session.createQuery("from UsuarioModel U where U.borrado=false").list();
		session.close();
		return lista;	}


	@Transactional
	public void guardar(UsuarioModel usuarioModel) throws PersistenciaExcepcion {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "guardar");
		try {
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.save(usuarioModel);
			tx.commit();
			s.close();
		} catch (Exception e) {
			throw new PersistenciaExcepcion(e.getMessage());
		}
	}

	@Transactional
	public void modificar(UsuarioModel usuarioModel) throws PersistenciaExcepcion {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "modificar");
		try {
			Session s = sessionFactory.openSession();

			s.beginTransaction();
			s.update(usuarioModel);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			throw new PersistenciaExcepcion(e.getMessage());
		}
	}

	@Transactional
	public void borrar(long id) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "borrar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		UsuarioModel model = s.get(UsuarioModel.class, id);
		model.setBorrado(true);
		s.update(model);
		//s.delete(s.get(UsuarioModel.class,id));
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public HashMap<UsuarioModel, Long> getProduccionTotal(UsuarioFiltro usuarioFiltro) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "getProduccionTotal");

		String query = "SELECT usuario, SUM(mov.cantidad) FROM MovimientoModel as mov"
				+ " join mov.gallinero as g"
				+ " join g.usuario as usuario";


		QueryParametrosUtil qp = generarConsulta(query, usuarioFiltro);;
		qp.setSql(qp.getSql() + " group by usuario.id");
		List list = buscarUsandoQueryConParametros(qp);

		Iterator iterator = list.iterator();

		HashMap<UsuarioModel, Long> hash = new HashMap<UsuarioModel, Long>();
		while ( iterator.hasNext() ) {
			Object[] tuple = (Object[]) iterator.next();
			UsuarioModel kitten = (UsuarioModel) tuple[0];
			Long mother = (Long) tuple[1];
			hash.put(kitten, mother);
		}

		return hash;
	}

	@Override
	public List<UsuarioModel> listar(UsuarioFiltro usuarioFiltro) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "listar");
		String query = "select usuario from UsuarioModel as usuario" ;
		
		QueryParametrosUtil qp = generarConsulta(query, usuarioFiltro);
		List<UsuarioModel> list = (List<UsuarioModel>) buscarUsandoQueryConParametros(qp);
		return list;
	}
	
	private QueryParametrosUtil generarConsulta(String query, UsuarioFiltro filtro){
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "generarConsulta");
		QueryParametrosUtil qp = new QueryParametrosUtil();

		String str = " where usuario.borrado=false ";

		/*   Id   */
		if (filtro.getId() != 0) {
			str += obtenerOperadorBusqueda(str) + " usuario.id=" + filtro.getId();
		}

		/*   NombreUsuario   */
		if (filtro.getNombreUsuario() != null) {
			str += obtenerOperadorBusqueda(str) + " usuario.nombreUsuario like '" + filtro.getNombreUsuario() + "'";
		}
		
		/*   Nombre   */
		if (filtro.getNombre() != null) {
			str += obtenerOperadorBusqueda(str) + " usuario.nombre like '%" + filtro.getNombre() + "%'";
		}

		/*   Apellido   */
		if (filtro.getApellido() != null) {
			str += obtenerOperadorBusqueda(str) + " usuario.apellido like '%" + filtro.getApellido() + "%'";
		}

		qp.setSql(query + str);
		return qp;
	}

}
