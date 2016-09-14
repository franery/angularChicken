package ar.com.escuelita.chicken.persistencia.dao;

import java.util.Collection;
import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.PerfilModel;
import ar.com.escuelita.chicken.presentacion.filtro.PerfilFiltro;

public interface IPerfilDAO {

	public PerfilModel get(long id);
	
	public List<PerfilModel> listar();
	
	public void guardar(PerfilModel perfilModel);
	
	public void modificar(PerfilModel perfilModel);
	
	public void borrar(long id);

	public List<PerfilModel> listar(PerfilFiltro filtro);

}
