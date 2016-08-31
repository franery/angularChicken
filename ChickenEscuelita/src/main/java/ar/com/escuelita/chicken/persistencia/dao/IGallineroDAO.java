package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.GallineroModel;
import ar.com.escuelita.chicken.presentacion.filtro.GallineroFiltro;

public interface IGallineroDAO {
	public GallineroModel get(long id);
	
	public List<GallineroModel> listar();
	
	public List<GallineroModel> listar(GallineroFiltro gallineroFiltro);
	
	public void guardar(GallineroModel gallineroModel);
	
	public void modificar(GallineroModel gallineroModel);
	
	public void borrar(long id);
	
}
