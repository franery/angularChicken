package ar.com.escuelita.chicken.negocio.servicios.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.mapeos.UsuarioMapeador;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.filtro.Filtro;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;

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

	@Override
	public Collection<DTO> listar(Filtro filtro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HashMap<UsuarioDTO, Long> getTotalesProduccion(UsuarioFiltro usuarioFiltro){
		
		HashMap<UsuarioModel, Long> hash = usuarioDAO.getProduccionTotal(usuarioFiltro);
		
		HashMap<UsuarioDTO, Long> hashNuevo = new HashMap<UsuarioDTO, Long>();
		
	    Iterator it = hash.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        hashNuevo.put((UsuarioDTO) usuarioMapeador.map((UsuarioModel)pair.getKey()), (Long)pair.getValue());
	    }
	    return hashNuevo;
	    
	}


}
