package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IMovimientoValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;

public class MovimientoValidacionServicioImpl implements IMovimientoValidacionServicio {

	@Autowired
	IDepositoServicio depositoServicio;
	
	@Override
	public void validacionStockDeposito(String depositoId, long cantidad) throws ValidacionExcepcion {
		if(depositoId != null && !depositoId.equals("")) {
			DepositoDTO depositoDto = (DepositoDTO) depositoServicio.buscar(Long.parseLong(depositoId));
			long stockMaximo = Long.parseLong(depositoDto.getStockMaximo());
			long stockHuevos = Long.parseLong(depositoDto.getStockHuevos());
			if (stockMaximo - stockHuevos < cantidad) {
				throw new ValidacionExcepcion("mensajeErrorMovimientoDeposito");
			}
		}
	}
	
	public void validacionCantidadNoVacia(long cantidad) throws ValidacionExcepcion {
		if(cantidad == 0) {
			throw new ValidacionExcepcion("mensajeErrorCantidadVacia");
		}
	}
	
	public void validacionCantidadNoNegativa(long cantidad) throws ValidacionExcepcion {
		if(cantidad < 0) {
			throw new ValidacionExcepcion("mensajeErrorCantidadNegativa");
		}
	}
	
	public void validacionFechaNoVacia(Date fecha) throws ValidacionExcepcion {
		if(fecha == null) {
			throw new ValidacionExcepcion("mensajeErrorFechaVacia");
		}
	}
	
	public void validacionGallineroId(String gallineroId) throws ValidacionExcepcion {
		if(gallineroId == null || gallineroId.equals("")) {
			throw new ValidacionExcepcion("mensajeErrorGallineroId");
		}
	}
	
	public void validacionDepositoId(String depositoId) throws ValidacionExcepcion {
		if(depositoId == null || depositoId.equals("")) {
			throw new ValidacionExcepcion("mensajeErrorDepositoId");
		}
	}
}