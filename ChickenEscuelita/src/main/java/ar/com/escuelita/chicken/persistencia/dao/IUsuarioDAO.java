package ar.com.escuelita.chicken.persistencia.dao;

import java.util.HashMap;
import java.util.List;

import ar.com.escuelita.chicken.base.excepciones.PersistenciaExcepcion;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;

public interface IUsuarioDAO {
	public UsuarioModel get(long id);
	
	public List<UsuarioModel> listar();
	
	public List<UsuarioModel> listar(UsuarioFiltro usuarioFiltro);
	
	public void guardar(UsuarioModel usuarioModel) throws PersistenciaExcepcion;
	
	public void modificar(UsuarioModel usuarioModel) throws PersistenciaExcepcion;
	
	public void borrar(long id);

	List<HashMap<String, String>> getProduccionTotal(UsuarioFiltro usuarioFiltro);

}
