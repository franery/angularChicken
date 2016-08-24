package com.chicken.negocio.mapeos;

import com.chicken.base.dto.DTO;
import com.chicken.base.mapeadores.Mapeador;
import com.chicken.persistencia.model.ProveedorModel;
import com.chicken.persistencia.model.UsuarioModel;
import com.chicken.persistencia.model.VentaModel;
import com.chicken.persistencia.model.Modelo;
import com.chicken.presentacion.bean.dto.ProveedorDTO;
import com.chicken.presentacion.bean.dto.UsuarioDTO;
import com.chicken.presentacion.bean.dto.VentaDTO;

public class VentaMapeador extends Mapeador {

	private ProveedorMapeador proveedorMapeador = new ProveedorMapeador();
	private UsuarioMapeador usuarioMapeador = new UsuarioMapeador();
	
	@Override
	public DTO map(Modelo vo) {
		VentaModel ventaModel = (VentaModel) vo;
		VentaDTO dto = new VentaDTO();
		
		dto.setId(ventaModel.getId());
		dto.setCantidad(ventaModel.getCantidad());
		dto.setFecha(ventaModel.getFecha());
		dto.setPrecio(ventaModel.getPrecio());
		dto.setUsuario((UsuarioDTO)usuarioMapeador.map(ventaModel.getUsuario()));
		dto.setProveedor((ProveedorDTO)proveedorMapeador.map(ventaModel.getProveedor()));
		
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		VentaDTO ventaDTO = (VentaDTO) dto;	
		VentaModel ventaModel = (VentaModel) (vo != null ? vo : new VentaModel());
		
		ventaModel.setId(ventaDTO.getId());
		ventaModel.setCantidad(ventaDTO.getCantidad());
		ventaModel.setFecha(ventaDTO.getFecha());
		ventaModel.setPrecio(ventaDTO.getPrecio());
		ventaModel.setUsuario((UsuarioModel)usuarioMapeador.map(ventaDTO.getUsuario(),ventaModel.getUsuario()));
		ventaModel.setProveedor((ProveedorModel)proveedorMapeador.map(ventaDTO.getProveedor(),ventaModel.getProveedor()));
		
		return ventaModel;
	}

}
