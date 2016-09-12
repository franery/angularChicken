package ar.com.escuelita.chicken.negocio.mapeos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.persistencia.modelo.PerfilModel;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class UsuarioMapeador extends Mapeador {

	@Autowired PerfilMapeador perfilMapeo;
	
	@SuppressWarnings("unchecked")
	@Override
	public DTO map(Modelo vo) {
		UsuarioModel usuarioModel = (UsuarioModel) vo;
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setId(String.valueOf(usuarioModel.getId()));
		dto.setNombre(usuarioModel.getNombre());
		dto.setApellido(usuarioModel.getApellido());
		dto.setContrasenia(usuarioModel.getContrasenia());
		dto.setNombreUsuario(usuarioModel.getNombreUsuario());
		
		dto.setListaPerfiles((List<PerfilDTO>)perfilMapeo.map(usuarioModel.getListaPerfiles()));

		dto.setBorrado(String.valueOf(usuarioModel.isBorrado()));
		
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Modelo map(DTO dto, Modelo vo) {
		UsuarioDTO usuarioDTO = (UsuarioDTO) dto;	
		UsuarioModel usuarioModel = (UsuarioModel) (vo != null ? vo : new UsuarioModel());
		
		usuarioModel.setNombre(usuarioDTO.getNombre());
		usuarioModel.setApellido(usuarioDTO.getApellido());
		usuarioModel.setContrasenia(usuarioDTO.getContrasenia());
		usuarioModel.setNombreUsuario(usuarioDTO.getNombreUsuario());
		
		usuarioModel.setListaPerfiles((List<PerfilModel>)perfilMapeo.map(usuarioDTO.getListaPerfiles()));
		
		usuarioModel.setBorrado(Boolean.parseBoolean(usuarioDTO.getBorrado()));
		
		return usuarioModel;
	}

}
