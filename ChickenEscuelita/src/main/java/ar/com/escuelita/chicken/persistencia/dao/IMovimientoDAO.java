package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.MovimientoModel;

public interface IMovimientoDAO {
	public MovimientoModel get(long id);
	
	public List<MovimientoModel> listar();
	
	public void guardar(MovimientoModel movimientoModel);
	
	public void modificar(MovimientoModel movimientoModel);
	
	public void borrar(long id);
}
