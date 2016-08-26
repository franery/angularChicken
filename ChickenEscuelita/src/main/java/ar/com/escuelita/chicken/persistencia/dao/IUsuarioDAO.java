package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;

public interface IUsuarioDAO {
	public UsuarioModel get(long id);
	
	public List<UsuarioModel> listar();
	
	public void guardar(UsuarioModel usuarioModel);
	
	public void modificar(UsuarioModel usuarioModel);
	
	public void borrar(long id);
}
