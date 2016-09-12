package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.base.excepciones.PersistenciaExcepcion;
import ar.com.escuelita.chicken.persistencia.modelo.PerfilModel;

public interface IPerfilDAO {

	public PerfilModel get(long id);
	
	public List<PerfilModel> listar();
	
	public void guardar(PerfilModel perfilModel);
	
	public void modificar(PerfilModel perfilModel);
	
	public void borrar(long id);

}
