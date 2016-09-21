package ar.com.escuelita.chicken.presentacion.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IProveedorValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.ProveedorDTO;

public class ProveedorValidacion implements Validator {

	@Autowired
	private IProveedorValidacionServicio proveedorValidacionServicio;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ProveedorDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errores) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedorValidacion.class, "validate");
		ProveedorDTO proveedor = (ProveedorDTO) target;
		try {
			proveedorValidacionServicio.validacionNombreNoVacio(proveedor.getNombre());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("nombre", e.getMessage(),"Mesnaje default");
		}
		try {
			proveedorValidacionServicio.validacionNombreUnico(proveedor.getNombre(), proveedor.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("nombre", e.getMessage(),"Mesnaje default");
		}
		try {
			proveedorValidacionServicio.validacionMailNoVacio(proveedor.getMail());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("mail", e.getMessage(),"Mesnaje default");
		}
		try {
			proveedorValidacionServicio.validacionTelefonoNoVacio(proveedor.getTelefono());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("telefono", e.getMessage(),"Mesnaje default");
		}
		try {
			proveedorValidacionServicio.validacionDireccionNoVacio(proveedor.getDireccion());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("direccion", e.getMessage(),"Mesnaje default");
		}
	}
}