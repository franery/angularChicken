package ar.com.escuelita.chicken.persistencia.dao.impl;

import java.util.ArrayList;
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
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "get");
		Session s = sessionFactory.openSession();
		UsuarioModel e = s.get(UsuarioModel.class, id);
		s.close();
		Constantes.CHICKEN_LOG.info("Se obtuvo el Usuario: {}", e.getNombre());
		return e;
	}

	public List<UsuarioModel> listar() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "listar");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UsuarioModel> lista = session.createQuery("from UsuarioModel where borrado=false").list();
		session.close();
		Constantes.CHICKEN_LOG.info("Se listaron los Usuarios");
		return lista;
	}

	@Transactional
	public void guardar(UsuarioModel usuarioModel) throws PersistenciaExcepcion {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "guardar");
		try {
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.save(usuarioModel);
			tx.commit();
			s.close();
			Constantes.CHICKEN_LOG.info("Se guardo el Usuario: {}", usuarioModel.getNombre());
		} catch (Exception e) {
			throw new PersistenciaExcepcion(e.getMessage());
		}
	}

	@Transactional
	public void modificar(UsuarioModel usuarioModel) throws PersistenciaExcepcion {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "modificar");
		try {
			Session s = sessionFactory.openSession();

			s.beginTransaction();
			s.update(usuarioModel);
			s.getTransaction().commit();
			s.close();
			Constantes.CHICKEN_LOG.info("Se modifico el Usuario: {}", usuarioModel.getNombre());
		} catch (Exception e) {
			throw new PersistenciaExcepcion(e.getMessage());
		}
	}

	@Transactional
	public void borrar(long id) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "borrar");
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		UsuarioModel model = s.get(UsuarioModel.class, id);
		model.setBorrado(true);
		s.update(model);
		s.getTransaction().commit();
		s.close();
		Constantes.CHICKEN_LOG.info("Se borro el Usuario: {}", model.getNombre());
	}

	@Override
	public List<HashMap<String, String>> getProduccionTotal(UsuarioFiltro usuarioFiltro) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "getProduccionTotal");
		String query = "SELECT usuario, SUM(mov.cantidad) FROM MovimientoModel as mov"
				+ " join mov.gallinero as g"
				+ " join g.usuario as usuario";
		QueryParametrosUtil qp = generarConsulta(query, usuarioFiltro);
		qp.setSql(qp.getSql() + " group by usuario.id");
		List list = buscarUsandoQueryConParametros(qp);
		Iterator iterator = list.iterator();
		List<HashMap<String, String>> listaHash = new ArrayList<HashMap<String, String>>();
		while ( iterator.hasNext() ) {
			HashMap<String, String> hash = new HashMap<String, String>();
			Object[] tuple = (Object[]) iterator.next();
			UsuarioModel usuario = (UsuarioModel) tuple[0];
			hash.put("nombre", usuario.getNombre());
			hash.put("valor", String.valueOf(tuple[1]));
			listaHash.add(hash);
		}
		Constantes.CHICKEN_LOG.info("Se obtuvo la produccion total");
		return listaHash;
	}

	@Override
	public List<UsuarioModel> listar(UsuarioFiltro usuarioFiltro) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "listar");
		String query = "select usuario from UsuarioModel as usuario" ;
		QueryParametrosUtil qp = generarConsulta(query, usuarioFiltro);
		List<UsuarioModel> list = (List<UsuarioModel>) buscarUsandoQueryConParametros(qp);
		Constantes.CHICKEN_LOG.info("Se listaron los Usuarios usando filtro:  id: {}, nombre: {}, nombreUsuario: {}, apellido: {}", usuarioFiltro.getId(), usuarioFiltro.getNombre(), usuarioFiltro.getNombreUsuario(), usuarioFiltro.getApellido());
		return list;
	}
	
	private QueryParametrosUtil generarConsulta(String query, UsuarioFiltro filtro){
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", UsuarioDAOImpl.class, "generarConsulta");
		QueryParametrosUtil qp = new QueryParametrosUtil();
		String str = " where usuario.borrado=false ";
		if(filtro != null) {
			
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
		}
		qp.setSql(query + str);
		return qp;
	}

}
