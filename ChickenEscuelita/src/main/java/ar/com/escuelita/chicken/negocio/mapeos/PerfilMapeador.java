package ar.com.escuelita.chicken.negocio.mapeos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.persistencia.modelo.PerfilModel;
import ar.com.escuelita.chicken.persistencia.modelo.PermisoModel;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;
import ar.com.escuelita.chicken.presentacion.dto.PermisoDTO;

public class PerfilMapeador extends Mapeador {

	@Autowired PermisoMapeador permisoMapeo;
	
	@SuppressWarnings("unchecked")
	@Override
	public DTO map(Modelo vo) {
		PerfilModel perfilModel = (PerfilModel) vo;
		PerfilDTO dto = new PerfilDTO();
		dto.setId(String.valueOf(perfilModel.getId()));
		dto.setNombre(perfilModel.getNombre());
		dto.setListaPermisos((List<PermisoDTO>)permisoMapeo.map(perfilModel.getListaPermisos()));
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Modelo map(DTO dto, Modelo vo) {
		PerfilDTO perfilDTO = (PerfilDTO) dto;	
		PerfilModel perfilModel = (PerfilModel) (vo != null ? vo : new PerfilModel());
		
		perfilModel.setNombre(perfilDTO.getNombre());
		perfilModel.setListaPermisos((List<PermisoModel>)permisoMapeo.map(perfilDTO.getListaPermisos()));
		return perfilModel;
	}

}
