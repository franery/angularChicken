package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.ParametroModel;

public interface IParametroDAO {
	public ParametroModel get(long id);
	
	public List<ParametroModel> listar();
	
	public void guardar(ParametroModel parametroModel);
	
	public void modificar(ParametroModel parametroModel);
	
	public void borrar(long id);
}
