package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IProveedorServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IProveedorValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.ProveedorDTO;

public class ProveedorValidacionServicioImpl implements IProveedorValidacionServicio {
	
	@Autowired
	private IProveedorServicio proveedorServicio;
	
	public void validacionNombreUnico(String nombre, String id) throws ValidacionExcepcion {
		for (DTO dto : proveedorServicio.listar()) {
			ProveedorDTO proveedorDTO = (ProveedorDTO) dto;
			if (proveedorDTO.getNombre().equals(nombre) && !proveedorDTO.getId().equals(id)) {
				throw new ValidacionExcepcion("mensajeErrorNombreUnico");
			}
		}
	}
	
	public void validacionNombreNoVacio(String nombre) throws ValidacionExcepcion {
		if (nombre == null || nombre.isEmpty()) {
			throw new ValidacionExcepcion("mensajeErrorNombreVacio");
		}
	}

	@Override
	public void validacionDireccionNoVacio(String direccion)
			throws ValidacionExcepcion {
		if (direccion == null || direccion.isEmpty()) {
			throw new ValidacionExcepcion("mensajeErrorDireccionVacio");
		}
	}

	@Override
	public void validacionMail(String mail) throws ValidacionExcepcion {
		if (mail == null || mail.isEmpty()) {
			throw new ValidacionExcepcion("mensajeErrorMailInvalido");
		}
		if (!mail.matches(".*@.+\\.com(\\..+)?")) {
			throw new ValidacionExcepcion("mensajeErrorMailInvalido");
		}
	}

	@Override
	public void validacionTelefono(String telefono)
			throws ValidacionExcepcion {
		if (telefono == null || telefono.isEmpty() || telefono.length() != 8) {
			throw new ValidacionExcepcion("mensajeErrorTelefonoInvalido");
		}
		try {
			Long.parseLong(telefono);
		} catch (NumberFormatException e) {
			throw new ValidacionExcepcion("mensajeErrorTelefonoInvalido");
		}
	}
}