package ar.com.escuelita.chicken.persistencia.dao;

import java.util.List;

import ar.com.escuelita.chicken.persistencia.modelo.DepositoModel;

public interface IDepositoDAO {
	
	public DepositoModel get(long id);
	
	public List<DepositoModel> listar();
	
	public void guardar(DepositoModel DepositoModel);
	
	public void modificar(DepositoModel DepositoModel);
	
	public void borrar(long id);
	
}
