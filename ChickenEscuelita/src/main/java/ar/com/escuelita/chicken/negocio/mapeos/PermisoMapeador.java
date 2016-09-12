package ar.com.escuelita.chicken.negocio.mapeos;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.persistencia.modelo.PermisoModel;
import ar.com.escuelita.chicken.presentacion.dto.PermisoDTO;

public class PermisoMapeador extends Mapeador {

	@Override
	public DTO map(Modelo vo) {
		PermisoModel permisoModel = (PermisoModel) vo;
		PermisoDTO dto = new PermisoDTO();
		dto.setId(String.valueOf(permisoModel.getId()));
		dto.setNombre(permisoModel.getNombre());
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		PermisoDTO permisoDTO = (PermisoDTO) dto;	
		PermisoModel permisoModel = (PermisoModel) (vo != null ? vo : new PermisoModel());

		permisoModel.setNombre(permisoDTO.getNombre());
		
		return permisoModel;
	}
}