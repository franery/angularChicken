package com.chicken.persistencia.dao;

import java.util.List;

import com.chicken.persistencia.model.UsuarioModel;

public interface IUsuarioDAO {
	public UsuarioModel get(long id);
	
	public List<UsuarioModel> listar();
	
	public void guardar(UsuarioModel usuarioModel);
	
	public void modificar(UsuarioModel usuarioModel);
	
	public void borrar(long id);
}
