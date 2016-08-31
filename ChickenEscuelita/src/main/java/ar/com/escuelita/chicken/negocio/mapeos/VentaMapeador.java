package ar.com.escuelita.chicken.negocio.mapeos;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.dao.IProveedorDAO;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.modelo.ProveedorModel;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.persistencia.modelo.VentaModel;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.presentacion.dto.ProveedorDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.dto.VentaDTO;

public class VentaMapeador extends Mapeador {

//	private ProveedorMapeador proveedorMapeador = new ProveedorMapeador();
//	private UsuarioMapeador usuarioMapeador = new UsuarioMapeador();
	
	@Autowired
	private IProveedorDAO proveedorDAO;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public DTO map(Modelo vo) {
		VentaModel ventaModel = (VentaModel) vo;
		VentaDTO dto = new VentaDTO();
		
		dto.setId(ventaModel.getId());
		dto.setCantidad(ventaModel.getCantidad());
		dto.setFecha(ventaModel.getFecha());
		dto.setPrecio(ventaModel.getPrecio());
		dto.setUsuarioId(ventaModel.getUsuario().getId());
//		((UsuarioDTO)usuarioMapeador.map(ventaModel.getUsuario()));
//		dto.setProveedor((ProveedorDTO)proveedorMapeador.map(ventaModel.getProveedor()));
		dto.setProveedorId(ventaModel.getProveedor().getId());
		dto.setProveedorNombre(ventaModel.getProveedor().getNombre());
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
//		ventaModel.setUsuario((UsuarioModel)usuarioMapeador.map(ventaDTO.getUsuario(),ventaModel.getUsuario()));
//		ventaModel.setProveedor((ProveedorModel)proveedorMapeador.map(ventaDTO.getProveedor(),ventaModel.getProveedor()));
		ventaModel.setUsuario(usuarioDAO.get(ventaDTO.getUsuarioId()));
		ventaModel.setProveedor(proveedorDAO.get(ventaDTO.getProveedorId()));
		
		return ventaModel;
	}

}
