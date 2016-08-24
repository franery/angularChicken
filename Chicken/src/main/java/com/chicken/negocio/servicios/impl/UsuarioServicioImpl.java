package com.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.chicken.base.dto.DTO;
import com.chicken.negocio.mapeos.UsuarioMapeador;
import com.chicken.negocio.servicios.IUsuarioServicio;
import com.chicken.persistencia.dao.IUsuarioDAO;
import com.chicken.persistencia.model.UsuarioModel;
import com.chicken.presentacion.bean.dto.UsuarioDTO;

public class UsuarioServicioImpl extends Servicio implements IUsuarioServicio {
UsuarioMapeador usuarioMapeador = new UsuarioMapeador();
	
	@Autowired
	IUsuarioDAO usuarioDAO;
	
	@Override
	public DTO buscar(long id) {
		return usuarioMapeador.map(usuarioDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return usuarioMapeador.map(usuarioDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		usuarioDAO.guardar((UsuarioModel)usuarioMapeador.map(dto, null));
	}

	@Override
	public void modificar(DTO dto) {
		UsuarioModel usuarioModel = (UsuarioModel)usuarioMapeador.map(dto, null);
		UsuarioDTO usuarioDTO = (UsuarioDTO) dto;
		usuarioModel.setId(usuarioDTO.getId());		
		usuarioDAO.modificar(usuarioModel);
	}

	@Override
	public void borrar(DTO dto) {
		usuarioDAO.borrar(((UsuarioDTO)dto).getId());		
	}

}
