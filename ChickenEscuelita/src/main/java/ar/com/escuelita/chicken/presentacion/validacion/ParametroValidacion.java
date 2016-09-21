package ar.com.escuelita.chicken.presentacion.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IParametroValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.ParametroDTO;

public class ParametroValidacion implements Validator {

	@Autowired
	IParametroValidacionServicio parametroValidacionServicio;
	
	public ParametroValidacion() {
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ParametroDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errores) {
		ParametroDTO parametro = (ParametroDTO) target;
		try {
			parametroValidacionServicio.validacionDescripcionParametro(parametro.getDescripcion(), parametro.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("descripcion", e.getMessage(),"Mesnaje default");
		}
		try {
			parametroValidacionServicio.validacionNombreNoVacio(parametro.getDescripcion());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("descripcion", e.getMessage(),"Mesnaje default");
		}
	}
}
