package com.chicken.persistencia.dao;

import java.util.List;

import com.chicken.persistencia.model.MovimientoModel;

public interface IMovimientoDAO {
	public MovimientoModel get(long id);
	
	public List<MovimientoModel> listar();
	
	public void guardar(MovimientoModel movimientoModel);
	
	public void modificar(MovimientoModel movimientoModel);
	
	public void borrar(long id);
}
