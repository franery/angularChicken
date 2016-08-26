package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.VentaModel;

public interface IVentaDAO {
	public VentaModel get(long id);
	
	public List<VentaModel> listar();
	
	public void guardar(VentaModel ventaModel);
	
	public void modificar(VentaModel ventaModel);
	
	public void borrar(long id);
}
