package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.ProveedorModel;

public interface IProveedorDAO {
	public ProveedorModel get(long id);
	
	public List<ProveedorModel> listar();
	
	public void guardar(ProveedorModel proveedorModel);
	
	public void modificar(ProveedorModel proveedorModel);
	
	public void borrar(long id);
}
