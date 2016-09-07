package ar.com.escuelita.chicken.negocio.mapeos;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class UsuarioMapeador extends Mapeador {

	@Override
	public DTO map(Modelo vo) {
		UsuarioModel usuarioModel = (UsuarioModel) vo;
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setId(String.valueOf(usuarioModel.getId()));
		dto.setNombre(usuarioModel.getNombre());
		dto.setApellido(usuarioModel.getApellido());
		dto.setContrasenia(usuarioModel.getContrasenia());
		dto.setNombreUsuario(usuarioModel.getNombreUsuario());
		dto.setPerfil(usuarioModel.getPerfil());
		dto.setBorrado(usuarioModel.isBorrado());
		
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		UsuarioDTO usuarioDTO = (UsuarioDTO) dto;	
		UsuarioModel usuarioModel = (UsuarioModel) (vo != null ? vo : new UsuarioModel());
		
		//usuarioModel.setId(usuarioDTO.getId());
		usuarioModel.setNombre(usuarioDTO.getNombre());
		usuarioModel.setApellido(usuarioDTO.getApellido());
		usuarioModel.setContrasenia(usuarioDTO.getContrasenia());
		usuarioModel.setNombreUsuario(usuarioDTO.getNombreUsuario());
		usuarioModel.setPerfil(usuarioDTO.getPerfil());
		usuarioModel.setBorrado(usuarioDTO.isBorrado());
		
		return usuarioModel;
	}

}
