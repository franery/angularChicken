package com.chicken.negocio.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.chicken.base.dto.DTO;
import com.chicken.negocio.mapeos.VentaMapeador;
import com.chicken.negocio.servicios.IVentaServicio;
import com.chicken.persistencia.dao.IVentaDAO;
import com.chicken.persistencia.model.VentaModel;
import com.chicken.presentacion.bean.dto.VentaDTO;

public class VentaServicioImpl extends Servicio implements IVentaServicio {
VentaMapeador ventaMapeador = new VentaMapeador();
	
	@Autowired
	IVentaDAO ventaDAO;
	
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

}
