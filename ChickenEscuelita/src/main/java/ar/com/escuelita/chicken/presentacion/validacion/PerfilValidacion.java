package ar.com.escuelita.chicken.presentacion.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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
		PerfilDTO perfil = (PerfilDTO) target;
		try {
			perfilValidacionServicio.validacionPerfilRoot(perfil.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("id", e.getMessage(),"Mesnaje default");
		}
	}
}
