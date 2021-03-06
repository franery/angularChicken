package ar.com.escuelita.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.mapeos.ProveedorMapeador;
import ar.com.escuelita.chicken.negocio.servicios.IProveedorServicio;
import ar.com.escuelita.chicken.persistencia.dao.IProveedorDAO;
import ar.com.escuelita.chicken.persistencia.modelo.ProveedorModel;
import ar.com.escuelita.chicken.presentacion.dto.ProveedorDTO;
import ar.com.escuelita.chicken.presentacion.filtro.Filtro;

public class ProveedorServicioImpl extends Servicio implements IProveedorServicio {
	
	@Autowired
	ProveedorMapeador proveedorMapeador;
	
	@Autowired
	IProveedorDAO proveedorDAO;
	
	@Override
	public DTO buscar(long id) {
		return proveedorMapeador.map(proveedorDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return proveedorMapeador.map(proveedorDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		proveedorDAO.guardar((ProveedorModel)proveedorMapeador.map(dto, null));
		System.out.println("ProveedorServicioImpl.crear");
	}

	@Override
	public void modificar(DTO dto) {
		ProveedorModel proveedorModel = (ProveedorModel)proveedorMapeador.map(dto, null);
		ProveedorDTO proveedorDTO = (ProveedorDTO) dto;
		proveedorModel.setId(Long.parseLong(proveedorDTO.getId()));		
		proveedorDAO.modificar(proveedorModel);
	}

	@Override
	public void borrar(DTO dto) {
		proveedorDAO.borrar(Long.parseLong(((ProveedorDTO)dto).getId()));		
	}

	@Override
	public Collection<DTO> listar(Filtro filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
