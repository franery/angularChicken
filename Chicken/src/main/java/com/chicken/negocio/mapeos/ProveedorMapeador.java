package com.chicken.negocio.mapeos;

import com.chicken.base.dto.DTO;
import com.chicken.base.mapeadores.Mapeador;
import com.chicken.persistencia.model.ProveedorModel;
import com.chicken.persistencia.model.Modelo;
import com.chicken.presentacion.bean.dto.ProveedorDTO;

public class ProveedorMapeador extends Mapeador {

	@Override
	public DTO map(Modelo vo) {
		ProveedorModel proveedorModel = (ProveedorModel) vo;
		ProveedorDTO dto = new ProveedorDTO();
		
		dto.setId(proveedorModel.getId());
		dto.setNombre(proveedorModel.getNombre());
		dto.setDireccion(proveedorModel.getDireccion());
		dto.setMail(proveedorModel.getMail());
		dto.setTelefono(proveedorModel.getTelefono());
		
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		ProveedorDTO proveedorDTO = (ProveedorDTO) dto;	
		ProveedorModel proveedorModel = (ProveedorModel) (vo != null ? vo : new ProveedorModel());
		
		proveedorModel.setNombre(proveedorDTO.getNombre());
		proveedorModel.setDireccion(proveedorDTO.getDireccion());
		proveedorModel.setMail(proveedorDTO.getMail());
		proveedorModel.setTelefono(proveedorDTO.getTelefono());
		
		return proveedorModel;
	}

}
