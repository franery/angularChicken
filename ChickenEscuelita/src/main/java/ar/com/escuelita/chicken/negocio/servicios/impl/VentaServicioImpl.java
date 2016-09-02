package ar.com.escuelita.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.mapeos.VentaMapeador;
import ar.com.escuelita.chicken.negocio.servicios.IVentaServicio;
import ar.com.escuelita.chicken.persistencia.dao.IDepositoDAO;
import ar.com.escuelita.chicken.persistencia.dao.IVentaDAO;
import ar.com.escuelita.chicken.persistencia.modelo.DepositoModel;
import ar.com.escuelita.chicken.persistencia.modelo.VentaModel;
import ar.com.escuelita.chicken.presentacion.dto.VentaDTO;
import ar.com.escuelita.chicken.presentacion.filtro.Filtro;
import ar.com.escuelita.chicken.presentacion.filtro.VentaFiltro;

public class VentaServicioImpl extends Servicio implements IVentaServicio {
	
	@Autowired
	VentaMapeador ventaMapeador;
	
	@Autowired
	IVentaDAO ventaDAO;
	
	@Autowired
	IDepositoDAO depositoDAO;
	
	@Override
	public DTO buscar(long id) {
		return ventaMapeador.map(ventaDAO.get(id));
	}

	@Override
	public Collection<DTO> listar() {
		return ventaMapeador.map(ventaDAO.listar());
	}

	@Override
	public void crear(DTO dto) {
		ventaDAO.guardar((VentaModel)ventaMapeador.map(dto, null));
		DepositoModel nuevoDeposito = new DepositoModel();
		for(DepositoModel deposito : depositoDAO.listar()) {
			if(deposito.getStockHuevos() >= ((VentaDTO)dto).getCantidad()) {
				nuevoDeposito = deposito;
				nuevoDeposito.setStockHuevos(nuevoDeposito.getStockHuevos() - ((VentaDTO)dto).getCantidad());
				break;
			}
		}
		depositoDAO.modificar(nuevoDeposito);
	}

	@Override
	public void modificar(DTO dto) {
		VentaModel ventaModel = (VentaModel)ventaMapeador.map(dto, null);
		VentaDTO ventaDTO = (VentaDTO) dto;
		ventaModel.setId(ventaDTO.getId());		
		ventaDAO.modificar(ventaModel);
	}

	@Override
	public void borrar(DTO dto) {
		ventaDAO.borrar(((VentaDTO)dto).getId());		
	}

	@Override
	public Collection<DTO> listar(Filtro filtro) {
		return ventaMapeador.map(ventaDAO.listar((VentaFiltro)filtro));
	}

}
