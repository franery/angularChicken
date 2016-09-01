package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.VentaModel;
import ar.com.escuelita.chicken.presentacion.filtro.VentaFiltro;

public interface IVentaDAO {
	public VentaModel get(long id);
	
	public List<VentaModel> listar();
	
	public List<VentaModel> listar(VentaFiltro filtro);
	
	public void guardar(VentaModel ventaModel);
	
	public void modificar(VentaModel ventaModel);
	
	public void borrar(long id);
}
