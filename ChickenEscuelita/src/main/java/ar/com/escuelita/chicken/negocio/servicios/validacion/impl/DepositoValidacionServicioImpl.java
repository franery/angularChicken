package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IDepositoValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;

public class DepositoValidacionServicioImpl implements IDepositoValidacionServicio{
	
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
	
	public void validacionStockMaximoSuperiorMinimo(String stockMaximo) throws ValidacionExcepcion {
		if(Long.parseLong(stockMaximo) <= Constantes.STOCK_MINIMO) {
			throw new ValidacionExcepcion("mensajeErrorStockMinimo");
		}
	}
	
	public void validacionStockMaximoMayorActual(String stockMaximo, String stockActual) throws ValidacionExcepcion {
		if(stockActual != null && Long.parseLong(stockMaximo) < Long.parseLong(stockActual)) {
			throw new ValidacionExcepcion("mensajeErrorStockMaximoMenorActual");
		}
	}

	@Override
	public void validacionStockMaximoNumero(String stockMaximo)
			throws ValidacionExcepcion {
		try {
			Long.parseLong(stockMaximo);
		} catch (NumberFormatException e) {
			throw new ValidacionExcepcion("mensajeErrorStockMaximoNumero");
		}
	}
}
