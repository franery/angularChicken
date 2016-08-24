package com.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.chicken.base.dto.DTO;
import com.chicken.negocio.mapeos.GallineroMapeador;
import com.chicken.negocio.servicios.IGallineroServicio;
import com.chicken.persistencia.dao.IGallineroDAO;
import com.chicken.persistencia.model.GallineroModel;
import com.chicken.presentacion.bean.dto.GallineroDTO;

public class GallineroServicioImpl extends Servicio implements IGallineroServicio {

GallineroMapeador gallineroMapeador = new GallineroMapeador();
	
	@Autowired
	IGallineroDAO gallineroDAO;
	
	@Override
	public DTO buscar(long id) {
		return gallineroMapeador.map(gallineroDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return gallineroMapeador.map(gallineroDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		gallineroDAO.guardar((GallineroModel)gallineroMapeador.map(dto, null));
	}

	@Override
	public void modificar(DTO dto) {
		GallineroModel gallineroModel = (GallineroModel)gallineroMapeador.map(dto, null);
		GallineroDTO gallineroDTO = (GallineroDTO) dto;
		gallineroModel.setId(gallineroDTO.getId());		
		gallineroDAO.modificar(gallineroModel);
	}

	@Override
	public void borrar(DTO dto) {
		gallineroDAO.borrar(((GallineroDTO)dto).getId());		
	}

}
