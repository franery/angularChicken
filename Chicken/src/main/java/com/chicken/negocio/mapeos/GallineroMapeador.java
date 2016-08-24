package com.chicken.negocio.mapeos;

import com.chicken.base.dto.DTO;
import com.chicken.base.mapeadores.Mapeador;
import com.chicken.persistencia.model.GallineroModel;
import com.chicken.persistencia.model.Modelo;
import com.chicken.persistencia.model.UsuarioModel;
import com.chicken.presentacion.bean.dto.GallineroDTO;
import com.chicken.presentacion.bean.dto.UsuarioDTO;

public class GallineroMapeador extends Mapeador {

	private UsuarioMapeador usuarioMapeador = new UsuarioMapeador();
	
	@Override
	public DTO map(Modelo vo) {
		GallineroModel gallineroModel = (GallineroModel) vo;
		GallineroDTO dto = new GallineroDTO();
		
		dto.setId(gallineroModel.getId());
		dto.setNombre(gallineroModel.getNombre());
		dto.setStockGallinas(gallineroModel.getStockGallinas());
		dto.setUsuario((UsuarioDTO)usuarioMapeador.map(gallineroModel.getUsuario()));
		
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		GallineroDTO gallineroDTO = (GallineroDTO) dto;
		GallineroModel gallineroModel = (GallineroModel) (vo != null ? vo : new GallineroModel());
		
		gallineroModel.setNombre(gallineroDTO.getNombre());
		gallineroModel.setStockGallinas(gallineroDTO.getStockGallinas());
		gallineroModel.setUsuario((UsuarioModel)usuarioMapeador.map(gallineroDTO.getUsuario(),gallineroModel.getUsuario()));
		
		return gallineroModel;
	}
}
