package com.chicken.persistencia.dao;

import java.util.List;

import com.chicken.persistencia.model.GallineroModel;

public interface IGallineroDAO {
	public GallineroModel get(long id);
	
	public List<GallineroModel> listar();
	
	public void guardar(GallineroModel gallineroModel);
	
	public void modificar(GallineroModel gallineroModel);
	
	public void borrar(long id);
	
}
