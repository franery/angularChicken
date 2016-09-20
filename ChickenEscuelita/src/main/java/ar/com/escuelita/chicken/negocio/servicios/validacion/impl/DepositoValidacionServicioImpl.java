package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IDepositoValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;

public class DepositoValidacionServicioImpl implements IDepositoValidacionServicio{
	
	public static long STOCK_MINIMO = 0;
	
	@Autowired
	private IDepositoServicio depositoServicio;
	
	public void validacionNombreUnico(String nombre, String id) throws ValidacionExcepcion {
		for (DTO dto : depositoServicio.listar()) {
			DepositoDTO depositoDTO = (DepositoDTO) dto;
			if (depositoDTO.getNombre().equals(nombre) && !depositoDTO.getId().equals(id)) {
				throw new ValidacionExcepcion("mensajeErrorNombreUnico");
			}
		}
	}
	
	public void validacionNombreNoVacio(String nombre) throws ValidacionExcepcion {
		if (nombre == null || nombre.isEmpty()) {
			throw new ValidacionExcepcion("mensajeErrorNombreVacio");
		}
	}
	
	public void validacionStockMaximoSuperiorMinimo(long stockMaximo) throws ValidacionExcepcion {
		if(stockMaximo <= STOCK_MINIMO) {
			throw new ValidacionExcepcion("mensajeErrorStockMinimo");
		}
	}
	
	public void validacionStockMaximoMayorActual(long stockMaximo, long stockActual) throws ValidacionExcepcion {
		if(stockMaximo < stockActual) {
			throw new ValidacionExcepcion("mensajeErrorStockMaximoMenorActual");
		}
	}
}
