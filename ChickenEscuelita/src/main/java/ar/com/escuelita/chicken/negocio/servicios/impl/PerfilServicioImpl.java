package ar.com.escuelita.chicken.negocio.servicios.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.mapeos.PerfilMapeador;
import ar.com.escuelita.chicken.negocio.servicios.IPerfilServicio;
import ar.com.escuelita.chicken.negocio.servicios.IPermisoServicio;
import ar.com.escuelita.chicken.persistencia.dao.IPerfilDAO;
import ar.com.escuelita.chicken.persistencia.modelo.PerfilModel;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;
import ar.com.escuelita.chicken.presentacion.dto.PermisoDTO;
import ar.com.escuelita.chicken.presentacion.filtro.Filtro;

public class PerfilServicioImpl extends Servicio implements IPerfilServicio {
	
	@Autowired
	PerfilMapeador perfilMapeador;
	
	@Autowired
	IPerfilDAO perfilDAO;
	
	@Autowired
	IPermisoServicio permisoServicio;
	
	@Override
	public DTO buscar(long id) {
		return perfilMapeador.map(perfilDAO.get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<DTO> listar() {
		return perfilMapeador.map(perfilDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		PerfilModel p = (PerfilModel)perfilMapeador.map(dto,null);
		perfilDAO.guardar(p);
	}
	
	@Override
	public void crear(String permisos, String nombre) {
		String[] arrayPermisos = permisos.split(";");
		PerfilDTO perfilDTO = new PerfilDTO();
		perfilDTO.setNombre(nombre);
		List<PermisoDTO> listaPermisos = new ArrayList<>();
		for(String permiso : arrayPermisos) {
//			PermisoDTO permisoDTO = (PermisoDTO) permisoServicio.buscar(Long.parseLong(permiso));
			PermisoDTO permisoDTO = new PermisoDTO();
			permisoDTO.setId(permiso);
			listaPermisos.add(permisoDTO);
		}
		perfilDTO.setListaPermisos(listaPermisos);
		crear(perfilDTO);
	}

	@Override
	public void modificar(DTO dto) {
		// Recuperar el modelo
		PerfilModel model = perfilDAO.get(Long.parseLong(((PerfilDTO)dto).getId()));
		PerfilModel perfilModel = (PerfilModel)perfilMapeador.map(dto, model);
		perfilDAO.modificar(perfilModel);
	}

	@Override
	public void borrar(DTO dto) {
		perfilDAO.borrar(Long.parseLong(((PerfilDTO)dto).getId()));		
	}

	
	
	/**
	 * GETTERS & SETTERS
	 */

	
	public PerfilMapeador getPerfilMapeador() {
		return perfilMapeador;
	}

	public void setPerfilMapeador(PerfilMapeador perfilMapeador) {
		this.perfilMapeador = perfilMapeador;
	}

	public IPerfilDAO getPerfilDAO() {
		return perfilDAO;
	}

	public void setPerfilDAO(IPerfilDAO perfilDAO) {
		this.perfilDAO = perfilDAO;
	}

	@Override
	public Collection<DTO> listar(Filtro filtro) {
		// TODO Auto-generated method stub
		return null;
	}
}
