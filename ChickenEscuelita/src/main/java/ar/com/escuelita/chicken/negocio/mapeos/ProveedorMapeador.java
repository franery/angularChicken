package ar.com.escuelita.chicken.negocio.mapeos;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.modelo.ProveedorModel;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.presentacion.dto.ProveedorDTO;

public class ProveedorMapeador extends Mapeador {

	@Override
	public DTO map(Modelo vo) {
		ProveedorModel proveedorModel = (ProveedorModel) vo;
		ProveedorDTO dto = new ProveedorDTO();
		
		dto.setId(String.valueOf(proveedorModel.getId()));
		dto.setNombre(proveedorModel.getNombre());
		dto.setDireccion(proveedorModel.getDireccion());
		dto.setMail(proveedorModel.getMail());
		dto.setTelefono(proveedorModel.getTelefono());
		dto.setBorrado(proveedorModel.isBorrado());
		
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
		proveedorModel.setBorrado(proveedorDTO.isBorrado());
		
		return proveedorModel;
	}

}
