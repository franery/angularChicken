package ar.com.escuelita.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.mapeos.DepositoMapeador;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.persistencia.dao.IDepositoDAO;
import ar.com.escuelita.chicken.persistencia.modelo.DepositoModel;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;
import ar.com.escuelita.chicken.presentacion.filtro.Filtro;

public class DepositoServicioImpl extends Servicio implements IDepositoServicio {

	@Autowired
	DepositoMapeador depositoMapeador;
	
	@Autowired
	IDepositoDAO depositoDAO;
	
	@Override
	public DTO buscar(long id) {
		return depositoMapeador.map(depositoDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return depositoMapeador.map(depositoDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		depositoDAO.guardar((DepositoModel)depositoMapeador.map(dto, null));
	}

	@Override
	public void modificar(DTO dto) {
		DepositoModel depositoModel = (DepositoModel)depositoMapeador.map(dto, null);
		DepositoDTO depositoDTO = (DepositoDTO) dto;
		depositoModel.setId(depositoDTO.getId());		
		depositoDAO.modificar(depositoModel);
	}

	@Override
	public void borrar(DTO dto) {
		depositoDAO.borrar(((DepositoDTO)dto).getId());		
	}

	public DepositoMapeador getDepositoMapeador() {
		return depositoMapeador;
	}

	public void setDepositoMapeador(DepositoMapeador depositoMapeador) {
		this.depositoMapeador = depositoMapeador;
	}

	public IDepositoDAO getDepositoDAO() {
		return depositoDAO;
	}

	public void setDepositoDAO(IDepositoDAO depositoDAO) {
		this.depositoDAO = depositoDAO;
	}

	@Override
	public Collection<DTO> listar(Filtro filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
