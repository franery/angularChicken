package ar.com.escuelita.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.mapeos.UsuarioMapeador;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class UsuarioServicioImpl extends Servicio implements IUsuarioServicio {
	
	@Autowired
	UsuarioMapeador usuarioMapeador;
	
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
