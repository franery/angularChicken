package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IVentaValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;

public class VentaValidacionServicioImpl implements IVentaValidacionServicio{
	
	@Autowired
	private IDepositoServicio depositoServicio;
	
	public VentaValidacionServicioImpl() {
		
	}
	
	public void validacionCantidad(long cantidad) throws ValidacionExcepcion {
		long cantidadTotalDepositos = 0;
		for(DTO deposito : depositoServicio.listar()) {
			cantidadTotalDepositos += Long.parseLong(((DepositoDTO)deposito).getStockHuevos());
		}
		if(cantidadTotalDepositos < cantidad) {
			throw new ValidacionExcepcion("mensajeErrorVentaCantidad");
		}
	}
	
	public void validacionProveedor(String proveedorId) throws ValidacionExcepcion {
		if(proveedorId == null || proveedorId.isEmpty()) {
			throw new ValidacionExcepcion("mensajeErrorVentaProveedor");
		}
	}
	
	public void validacionFechaNoVacia(Date fecha) throws ValidacionExcepcion {
		if(fecha == null) {
			throw new ValidacionExcepcion("mensajeErrorFechaVacia");
		}
	}
}
