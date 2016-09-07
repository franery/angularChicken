package ar.com.escuelita.chicken.negocio.mapeos;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.modelo.GallineroModel;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;

public class GallineroMapeador extends Mapeador {
	
	@Autowired 
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public DTO map(Modelo vo) {
		GallineroModel gallineroModel = (GallineroModel) vo;
		GallineroDTO dto = new GallineroDTO();
		
		dto.setId(String.valueOf(gallineroModel.getId()));
		dto.setNombre(gallineroModel.getNombre());
		dto.setStockGallinas(gallineroModel.getStockGallinas());
		dto.setUsuarioId(String.valueOf(gallineroModel.getUsuario().getId()));
		dto.setUsuarioNombre(gallineroModel.getUsuario().getNombre());
		dto.setBorrado(String.valueOf(gallineroModel.isBorrado()));
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		GallineroDTO gallineroDTO = (GallineroDTO) dto;
		GallineroModel gallineroModel = (GallineroModel) (vo != null ? vo : new GallineroModel());
		
		gallineroModel.setNombre(gallineroDTO.getNombre());
		gallineroModel.setStockGallinas(gallineroDTO.getStockGallinas());
		gallineroModel.setUsuario(usuarioDAO.get(Long.parseLong(gallineroDTO.getUsuarioId())));
		gallineroModel.setBorrado(Boolean.parseBoolean(gallineroDTO.getBorrado()));
		return gallineroModel;
	}
}
