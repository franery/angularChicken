package ar.com.escuelita.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.mapeos.GallineroMapeador;
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.persistencia.dao.IGallineroDAO;
import ar.com.escuelita.chicken.persistencia.modelo.GallineroModel;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;
import ar.com.escuelita.chicken.presentacion.filtro.Filtro;
import ar.com.escuelita.chicken.presentacion.filtro.GallineroFiltro;

public class GallineroServicioImpl extends Servicio implements IGallineroServicio {

	@Autowired
	GallineroMapeador gallineroMapeador;
	
	@Autowired
	IGallineroDAO gallineroDAO;
	
	@Override
	public DTO buscar(long id) {
		return gallineroMapeador.map(gallineroDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return gallineroMapeador.map(gallineroDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		gallineroDAO.guardar((GallineroModel)gallineroMapeador.map(dto, null));
	}

	@Override
	public void modificar(DTO dto) {
		GallineroModel gallineroModel = (GallineroModel)gallineroMapeador.map(dto, null);
		GallineroDTO gallineroDTO = (GallineroDTO) dto;
		gallineroModel.setId(gallineroDTO.getId());		
		gallineroDAO.modificar(gallineroModel);
	}

	@Override
	public void borrar(DTO dto) {
		gallineroDAO.borrar(((GallineroDTO)dto).getId());		
	}

	@Override
	public Collection<DTO> listar(Filtro filtro) {
		GallineroFiltro gallineroFiltro = (GallineroFiltro) filtro;
		Collection<GallineroModel> listaGallineroModel = gallineroDAO.listar(gallineroFiltro);
		Collection<DTO> listaGallineroDto = gallineroMapeador.map(listaGallineroModel);
		
		return listaGallineroDto;
	}

}
