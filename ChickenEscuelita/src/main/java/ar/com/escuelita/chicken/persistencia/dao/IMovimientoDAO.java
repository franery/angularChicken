package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.MovimientoModel;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;

public interface IMovimientoDAO {
	public MovimientoModel get(long id);
	
	public List<MovimientoModel> listar();
	
	public List<MovimientoModel> listar(MovimientoFiltro movimientoFiltro);
	
	public void guardar(MovimientoModel movimientoModel);
	
	public void modificar(MovimientoModel movimientoModel);
	
	public void borrar(long id);
}
