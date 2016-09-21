package ar.com.escuelita.chicken.presentacion.validacion;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IGallineroValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;
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
		GallineroDTO gallinero= (GallineroDTO) target;
		try {
			gallineroValidacionServicio.validacionNombreUnico(gallinero.getNombre(), gallinero.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("nombre", e.getMessage(),"Mesnaje default");
		}
	}
}