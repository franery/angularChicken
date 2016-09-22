package ar.com.escuelita.chicken.presentacion.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IPerfilValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;

public class PerfilValidacion implements Validator {
	
	@Autowired
	private IPerfilValidacionServicio perfilValidacionServicio;
	
	public PerfilValidacion() {
		
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return PerfilDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errores) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilValidacion.class, "validate");
		PerfilDTO perfil = (PerfilDTO) target;
		try {
			perfilValidacionServicio.validacionPerfilRoot(perfil.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("id", e.getMessage(),"Mesnaje default");
		}
		try {
			perfilValidacionServicio.validacionNombreUnico(perfil.getNombre(),perfil.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("nombre", e.getMessage(),"Mesnaje default");
		}
		try {
			perfilValidacionServicio.validacionNombreNoVacio(perfil.getNombre());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("nombre", e.getMessage(),"Mesnaje default");
		}
	}
}
