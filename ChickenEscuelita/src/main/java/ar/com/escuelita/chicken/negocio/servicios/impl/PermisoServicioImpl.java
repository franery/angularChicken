package ar.com.escuelita.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.mapeos.PermisoMapeador;
import ar.com.escuelita.chicken.negocio.servicios.IPermisoServicio;
import ar.com.escuelita.chicken.persistencia.dao.IPermisoDAO;
import ar.com.escuelita.chicken.persistencia.modelo.PermisoModel;
import ar.com.escuelita.chicken.presentacion.dto.PermisoDTO;
import ar.com.escuelita.chicken.presentacion.filtro.Filtro;

public class PermisoServicioImpl extends Servicio implements IPermisoServicio {
	
	@Autowired
	PermisoMapeador permisoMapeador;
	
	@Autowired
	IPermisoDAO permisoDAO;
	
	@Override
	public DTO buscar(long id) {
		return permisoMapeador.map(permisoDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return permisoMapeador.map(permisoDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		PermisoModel p = (PermisoModel)permisoMapeador.map(dto,null);
		permisoDAO.guardar(p);
	}

	@Override
	public void modificar(DTO dto) {
		// Recuperar el modelo
		PermisoModel model = permisoDAO.get(Long.parseLong(((PermisoDTO)dto).getId()));
		PermisoModel permisoModel = (PermisoModel)permisoMapeador.map(dto, model);
		permisoDAO.modificar(permisoModel);
	}

	@Override
	public void borrar(DTO dto) {
		permisoDAO.borrar(Long.parseLong(((PermisoDTO)dto).getId()));		
	}

	
	
	/**
	 * GETTERS & SETTERS
	 */

	
	public PermisoMapeador getPermisoMapeador() {
		return permisoMapeador;
	}

	public void setPermisoMapeador(PermisoMapeador permisoMapeador) {
		this.permisoMapeador = permisoMapeador;
	}

	public IPermisoDAO getPermisoDAO() {
		return permisoDAO;
	}

	public void setPermisoDAO(IPermisoDAO permisoDAO) {
		this.permisoDAO = permisoDAO;
	}

	@Override
	public Collection<DTO> listar(Filtro filtro) {
		// TODO Auto-generated method stub
		return null;
	}
}
