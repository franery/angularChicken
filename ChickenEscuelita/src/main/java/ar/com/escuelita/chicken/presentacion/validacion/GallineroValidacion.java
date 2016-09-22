package ar.com.escuelita.chicken.presentacion.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IGallineroValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;

public class GallineroValidacion implements Validator {
	
	@Autowired
	private IGallineroValidacionServicio gallineroValidacionServicio;
	
	public GallineroValidacion() {
	}
	
	public boolean supports(Class<?> clazz) {
		return GallineroDTO.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errores) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", GallineroValidacion.class, "validate");
		GallineroDTO gallinero= (GallineroDTO) target;
		try {
			gallineroValidacionServicio.validacionNombreUnico(gallinero.getNombre(), gallinero.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("nombre", e.getMessage(),"Mesnaje default");
		}
		try {
			gallineroValidacionServicio.validacionNombreNoVacio(gallinero.getNombre());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("nombre", e.getMessage(),"Mesnaje default");
		}
		try {
			gallineroValidacionServicio.validacionStockSuperiorMinimo(gallinero.getStockGallinas());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("stockGallinas", e.getMessage(),"Mesnaje default");
		}
		try {
			gallineroValidacionServicio.validacionUsuarioExiste(gallinero.getUsuarioId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("usuarioId", e.getMessage(),"Mesnaje default");
		}
	}
}