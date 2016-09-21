package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IGallineroValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;

public class GallineroValidacionServicioImpl implements IGallineroValidacionServicio {

	public static long STOCK_MINIMO = 0;
	
	@Autowired
	private IGallineroServicio gallineroServicio;
	
	@Override
	public void validacionNombreUnico(String nombre, String id) throws ValidacionExcepcion {
		for (DTO dto : gallineroServicio.listar()) {
			GallineroDTO gallineroDTO = (GallineroDTO) dto;
			if (gallineroDTO.getNombre().equals(nombre) && !gallineroDTO.getId().equals(id)) {
				throw new ValidacionExcepcion("mensajeErrorNombreUnico");
			}
		}		
	}

	@Override
	public void validacionNombreNoVacio(String nombre) throws ValidacionExcepcion {
		if (nombre == null || nombre.isEmpty()) {
			throw new ValidacionExcepcion("mensajeErrorNombreVacio");
		}
	}

	@Override
	public void validacionStockSuperiorMinimo(long stock) throws ValidacionExcepcion {
		// TODO Auto-generated method stub
		
	}
}