package com.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.chicken.base.dto.DTO;
import com.chicken.negocio.mapeos.ProveedorMapeador;
import com.chicken.negocio.servicios.IProveedorServicio;
import com.chicken.persistencia.dao.IProveedorDAO;
import com.chicken.persistencia.model.ProveedorModel;
import com.chicken.presentacion.bean.dto.ProveedorDTO;

public class ProveedorServicioImpl extends Servicio implements IProveedorServicio {
ProveedorMapeador proveedorMapeador = new ProveedorMapeador();
	
	@Autowired
	IProveedorDAO proveedorDAO;
	
	@Override
	public DTO buscar(long id) {
		return proveedorMapeador.map(proveedorDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return proveedorMapeador.map(proveedorDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		proveedorDAO.guardar((ProveedorModel)proveedorMapeador.map(dto, null));
	}

	@Override
	public void modificar(DTO dto) {
		ProveedorModel proveedorModel = (ProveedorModel)proveedorMapeador.map(dto, null);
		ProveedorDTO proveedorDTO = (ProveedorDTO) dto;
		proveedorModel.setId(proveedorDTO.getId());		
		proveedorDAO.modificar(proveedorModel);
	}

	@Override
	public void borrar(DTO dto) {
		proveedorDAO.borrar(((ProveedorDTO)dto).getId());		
	}

}
