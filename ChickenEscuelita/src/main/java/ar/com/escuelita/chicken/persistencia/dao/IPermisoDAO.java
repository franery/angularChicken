package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.PermisoModel;

public interface IPermisoDAO {

	// Permiso solo  admite listar. Los permisos son las vistas disponibles
	
	public PermisoModel get(long id);
	
	public List<PermisoModel> listar();
	
	public void guardar(PermisoModel permisoModel);
	
	public void modificar(PermisoModel permisoModel);
	
	public void borrar(long id);

}
