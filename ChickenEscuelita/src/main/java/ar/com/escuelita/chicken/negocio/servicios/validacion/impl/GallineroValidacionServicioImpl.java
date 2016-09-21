package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IGallineroValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;

public class GallineroValidacionServicioImpl implements IGallineroValidacionServicio {
	
	@Autowired
	private IGallineroServicio gallineroServicio;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
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
	public void validacionStockSuperiorMinimo(String stock) throws ValidacionExcepcion {
		long numeroStock;
		try {
			numeroStock = Long.parseLong(stock);
		} catch (NumberFormatException e) {
			throw new ValidacionExcepcion("mensajeErrorStockGallinasNumero");
		}
		if(numeroStock <= Constantes.STOCK_MINIMO) {
			throw new ValidacionExcepcion("mensajeErrorStockMinimo");
		}
	}

	@Override
	public void validacionUsuarioExiste(String usuarioId) throws ValidacionExcepcion {
		try {
			Long.parseLong(usuarioId);
		} catch (NumberFormatException e) {
			throw new ValidacionExcepcion("mensajeErrorUsuarioInvalido");
		}
	}
}