package com.chicken.persistencia.dao;

import java.util.List;

import com.chicken.persistencia.model.ParametroModel;

public interface IParametroDAO {
	public ParametroModel get(long id);
	
	public List<ParametroModel> listar();
	
	public void guardar(ParametroModel parametroModel);
	
	public void modificar(ParametroModel parametroModel);
	
	public void borrar(long id);
}
