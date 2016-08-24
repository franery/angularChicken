package com.chicken.persistencia.dao;

import java.util.List;

import com.chicken.persistencia.model.DepositoModel;

public interface IDepositoDAO {
	
	public DepositoModel get(long id);
	
	public List<DepositoModel> listar();
	
	public void guardar(DepositoModel DepositoModel);
	
	public void modificar(DepositoModel DepositoModel);
	
	public void borrar(long id);
	
}
