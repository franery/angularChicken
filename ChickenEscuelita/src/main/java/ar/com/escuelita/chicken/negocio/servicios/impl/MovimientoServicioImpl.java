package ar.com.escuelita.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.mapeos.MovimientoMapeador;
import ar.com.escuelita.chicken.negocio.servicios.IMovimientoServicio;
import ar.com.escuelita.chicken.persistencia.dao.IMovimientoDAO;
import ar.com.escuelita.chicken.persistencia.modelo.MovimientoModel;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;

public class MovimientoServicioImpl extends Servicio implements IMovimientoServicio {
	
	@Autowired
	MovimientoMapeador movimientoMapeador;
	
	@Autowired
	IMovimientoDAO movimientoDAO;
	
	@Override
	public DTO buscar(long id) {
		return movimientoMapeador.map(movimientoDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return movimientoMapeador.map(movimientoDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		movimientoDAO.guardar((MovimientoModel)movimientoMapeador.map(dto, null));
	}

	@Override
	public void modificar(DTO dto) {
		MovimientoModel movimientoModel = (MovimientoModel)movimientoMapeador.map(dto, null);
		MovimientoDTO movimientoDTO = (MovimientoDTO) dto;
		movimientoModel.setId(movimientoDTO.getId());		
		movimientoDAO.modificar(movimientoModel);
	}

	@Override
	public void borrar(DTO dto) {
		movimientoDAO.borrar(((MovimientoDTO)dto).getId());		
	}

}
