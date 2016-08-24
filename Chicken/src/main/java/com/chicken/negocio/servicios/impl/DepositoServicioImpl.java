package com.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.chicken.base.dto.DTO;
import com.chicken.negocio.mapeos.DepositoMapeador;
import com.chicken.negocio.servicios.IDepositoServicio;
import com.chicken.persistencia.dao.IDepositoDAO;
import com.chicken.persistencia.model.DepositoModel;
import com.chicken.presentacion.bean.dto.DepositoDTO;

public class DepositoServicioImpl extends Servicio implements IDepositoServicio {

	DepositoMapeador depositoMapeador = new DepositoMapeador();
	
	@Autowired
	IDepositoDAO depositoDAO;
	
	@Override
	public DTO buscar(long id) {
		return depositoMapeador.map(depositoDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return depositoMapeador.map(depositoDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		depositoDAO.guardar((DepositoModel)depositoMapeador.map(dto, null));
	}

	@Override
	public void modificar(DTO dto) {
		DepositoModel depositoModel = (DepositoModel)depositoMapeador.map(dto, null);
		DepositoDTO depositoDTO = (DepositoDTO) dto;
		depositoModel.setId(depositoDTO.getId());		
		depositoDAO.modificar(depositoModel);
	}

	@Override
	public void borrar(DTO dto) {
		depositoDAO.borrar(((DepositoDTO)dto).getId());		
	}

	public DepositoMapeador getDepositoMapeador() {
		return depositoMapeador;
	}

	public void setDepositoMapeador(DepositoMapeador depositoMapeador) {
		this.depositoMapeador = depositoMapeador;
	}

	public IDepositoDAO getDepositoDAO() {
		return depositoDAO;
	}

	public void setDepositoDAO(IDepositoDAO depositoDAO) {
		this.depositoDAO = depositoDAO;
	}

	
}
