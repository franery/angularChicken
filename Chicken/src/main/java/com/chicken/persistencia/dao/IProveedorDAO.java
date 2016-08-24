package com.chicken.persistencia.dao;

import java.util.List;

import com.chicken.persistencia.model.ProveedorModel;

public interface IProveedorDAO {
	public ProveedorModel get(long id);
	
	public List<ProveedorModel> listar();
	
	public void guardar(ProveedorModel proveedorModel);
	
	public void modificar(ProveedorModel proveedorModel);
	
	public void borrar(long id);
}
