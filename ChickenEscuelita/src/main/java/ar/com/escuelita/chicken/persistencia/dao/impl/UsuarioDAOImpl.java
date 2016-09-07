package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.excepciones.PersistenciaExcepcion;
import ar.com.escuelita.chicken.persistencia.dao.DAO;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.dao.util.QueryParametrosUtil;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;

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
		List<UsuarioModel> lista = session.createQuery("from UsuarioModel where borrado=false").list();
		session.close();
		return lista;
	}

	public List<UsuarioModel> listarProductores(){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UsuarioModel> lista = session.createQuery("from UsuarioModel U where U.perfil=2 and U.borrado=false").list();
		session.close();
		return lista;	}


	@Transactional
	public void guardar(UsuarioModel usuarioModel) throws PersistenciaExcepcion {
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
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(s.get(UsuarioModel.class,id));
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public HashMap<UsuarioModel, Long> getProduccionTotal(UsuarioFiltro usuarioFiltro) {

		String query = "SELECT usuario, SUM(mov.cantidad) FROM MovimientoModel as mov"
				+ " join mov.gallinero as g"
				+ " join g.usuario as usuario";


		QueryParametrosUtil qp = generarConsulta(query, usuarioFiltro);;

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


	private QueryParametrosUtil generarConsulta(String query, UsuarioFiltro filtro){
		QueryParametrosUtil qp = new QueryParametrosUtil();

		String str = " where usuario.borrado=false ";

		/*   Id   */
		if (filtro.getId() != 0) {
			str += obtenerOperadorBusqueda(str) + " usuario.id=" + filtro.getId();
		}

		/*   Nombre   */
		if (filtro.getNombre() != null) {
			str += obtenerOperadorBusqueda(str) + " usuario.nombre like '%" + filtro.getNombre() + "%'";
		}

		/*   Apellido   */
		if (filtro.getApellido() != null) {
			str += obtenerOperadorBusqueda(str) + " usuario.apellido like '%" + filtro.getApellido() + "%'";
		}

		qp.setSql(query + str	+ " group by usuario.id");
		return qp;
	}

}
