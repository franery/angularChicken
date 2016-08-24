package com.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.chicken.base.dto.DTO;
import com.chicken.negocio.mapeos.ParametroMapeador;
import com.chicken.negocio.servicios.IParametroServicio;
import com.chicken.persistencia.dao.IParametroDAO;
import com.chicken.persistencia.model.ParametroModel;
import com.chicken.presentacion.bean.dto.ParametroDTO;

public class ParametroServicioImpl extends Servicio implements IParametroServicio {
	
	ParametroMapeador parametroMapeador = new ParametroMapeador();
	
	@Autowired
	IParametroDAO parametroDAO;
	
	@Override
	public DTO buscar(long id) {
		return parametroMapeador.map(parametroDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return parametroMapeador.map(parametroDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		ParametroModel p = (ParametroModel)parametroMapeador.map(dto,null);
		parametroDAO.guardar(p);
	}

	@Override
	public void modificar(DTO dto) {
		// Recuperar el modelo
		ParametroModel model = parametroDAO.get(((ParametroDTO)dto).getId());
		ParametroModel parametroModel = (ParametroModel)parametroMapeador.map(dto, model);
		parametroDAO.modificar(parametroModel);
	}

	@Override
	public void borrar(DTO dto) {
		parametroDAO.borrar(((ParametroDTO)dto).getId());		
	}

	
	
	/**
	 * GETTERS & SETTERS
	 */

	
	public ParametroMapeador getParametroMapeador() {
		return parametroMapeador;
	}

	public void setParametroMapeador(ParametroMapeador parametroMapeador) {
		this.parametroMapeador = parametroMapeador;
	}

	public IParametroDAO getParametroDAO() {
		return parametroDAO;
	}

	public void setParametroDAO(IParametroDAO parametroDAO) {
		this.parametroDAO = parametroDAO;
	}
}
