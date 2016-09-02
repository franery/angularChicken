package ar.com.escuelita.chicken.persistencia.dao;

import java.util.HashMap;
import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;

public interface IUsuarioDAO {
	public UsuarioModel get(long id);
	
	public List<UsuarioModel> listar();
	
	public void guardar(UsuarioModel usuarioModel);
	
	public void modificar(UsuarioModel usuarioModel);
	
	public void borrar(long id);

	HashMap<UsuarioModel, Long> getProduccionTotal(UsuarioFiltro usuarioFiltro);
}
