package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.base.excepciones.PersistenciaExcepcion;
import ar.com.escuelita.chicken.persistencia.modelo.PermisoModel;

public interface IPermisoDAO {

	// Permiso solo  admite listar. Los permisos son las vistas disponibles
	
	public PermisoModel get(long id);
	
	public List<PermisoModel> listar();
	
	public void guardar(PermisoModel permisoModel) throws PersistenciaExcepcion;
	
	public void modificar(PermisoModel permisoModel) throws PersistenciaExcepcion;
	
	public void borrar(long id);

}
