package com.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.chicken.base.dto.DTO;
import com.chicken.negocio.mapeos.MovimientoMapeador;
import com.chicken.negocio.servicios.IMovimientoServicio;
import com.chicken.persistencia.dao.IMovimientoDAO;
import com.chicken.persistencia.model.MovimientoModel;
import com.chicken.presentacion.bean.dto.MovimientoDTO;

public class MovimientoServicioImpl extends Servicio implements IMovimientoServicio {
MovimientoMapeador movimientoMapeador = new MovimientoMapeador();
	
	@Autowired
	IMovimientoDAO movimientoDAO;
	
	@Override
	public DTO buscar(long id) {
		return movimientoMapeador.map(movimientoDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return movimientoMapeador.map(movimientoDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		movimientoDAO.guardar((MovimientoModel)movimientoMapeador.map(dto, null));
	}

	@Override
	public void modificar(DTO dto) {
		MovimientoModel movimientoModel = (MovimientoModel)movimientoMapeador.map(dto, null);
		MovimientoDTO movimientoDTO = (MovimientoDTO) dto;
		movimientoModel.setId(movimientoDTO.getId());		
		movimientoDAO.modificar(movimientoModel);
	}

	@Override
	public void borrar(DTO dto) {
		movimientoDAO.borrar(((MovimientoDTO)dto).getId());		
	}

}
