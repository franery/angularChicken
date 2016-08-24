package com.chicken.negocio.mapeos;

import com.chicken.base.dto.DTO;
import com.chicken.base.mapeadores.Mapeador;
import com.chicken.persistencia.model.UsuarioModel;
import com.chicken.persistencia.model.Modelo;
import com.chicken.presentacion.bean.dto.UsuarioDTO;

public class UsuarioMapeador extends Mapeador {

	@Override
	public DTO map(Modelo vo) {
		UsuarioModel usuarioModel = (UsuarioModel) vo;
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setId(usuarioModel.getId());
		dto.setNombre(usuarioModel.getNombre());
		dto.setApellido(usuarioModel.getApellido());
		dto.setContrasenia(usuarioModel.getContrasenia());
		dto.setNombreUsuario(usuarioModel.getNombreUsuario());
		dto.setPerfil(usuarioModel.getPerfil());
		
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		UsuarioDTO usuarioDTO = (UsuarioDTO) dto;	
		UsuarioModel usuarioModel = (UsuarioModel) (vo != null ? vo : new UsuarioModel());
		
		usuarioModel.setId(usuarioDTO.getId());
		usuarioModel.setNombre(usuarioDTO.getNombre());
		usuarioModel.setApellido(usuarioDTO.getApellido());
		usuarioModel.setContrasenia(usuarioDTO.getContrasenia());
		usuarioModel.setNombreUsuario(usuarioDTO.getNombreUsuario());
		usuarioModel.setPerfil(usuarioDTO.getPerfil());
		
		return usuarioModel;
	}

}
