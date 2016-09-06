package ar.com.escuelita.chicken.negocio.mapeos;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.dao.IProveedorDAO;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.modelo.VentaModel;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.presentacion.dto.VentaDTO;

public class VentaMapeador extends Mapeador {
	
	@Autowired
	private IProveedorDAO proveedorDAO;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public DTO map(Modelo vo) {
		VentaModel ventaModel = (VentaModel) vo;
		VentaDTO dto = new VentaDTO();
		
		dto.setId(String.valueOf(ventaModel.getId()));
		dto.setCantidad(ventaModel.getCantidad());
		dto.setFecha(ventaModel.getFecha());
		dto.setPrecio(ventaModel.getPrecio());
		dto.setUsuarioId(String.valueOf(ventaModel.getUsuario().getId()));
		dto.setProveedorId(String.valueOf(ventaModel.getProveedor().getId()));
		dto.setProveedorNombre(ventaModel.getProveedor().getNombre());
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		VentaDTO ventaDTO = (VentaDTO) dto;	
		VentaModel ventaModel = (VentaModel) (vo != null ? vo : new VentaModel());
		
		ventaModel.setId(Long.parseLong(ventaDTO.getId()));
		ventaModel.setCantidad(ventaDTO.getCantidad());
		ventaModel.setFecha(ventaDTO.getFecha());
		ventaModel.setPrecio(ventaDTO.getPrecio());
		ventaModel.setUsuario(usuarioDAO.get(Long.parseLong(ventaDTO.getUsuarioId())));
		ventaModel.setProveedor(proveedorDAO.get(Long.parseLong(ventaDTO.getProveedorId())));
		
		return ventaModel;
	}

}
