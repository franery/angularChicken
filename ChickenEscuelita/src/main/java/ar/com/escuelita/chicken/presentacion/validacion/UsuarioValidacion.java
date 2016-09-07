package ar.com.escuelita.chicken.presentacion.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IUsuarioValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class UsuarioValidacion implements Validator {

	@Autowired
	IUsuarioValidacionServicio usuarioValidacionServicio;

	public UsuarioValidacion() {
		
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errores) {
		UsuarioDTO usuario = (UsuarioDTO) target;
		try {
			usuarioValidacionServicio.validacionNombreUsuario(usuario.getNombreUsuario());
		} catch (ValidacionExcepcion e) {
			
			//e.printStackTrace();
//			errores.rejectValue("nombreUsuario", e.getMessage());
			errores.rejectValue("nombreUsuario", "mensajeErrorUsuario","Mesnaje default");
			System.out.println("B");
		}
	}

	public IUsuarioValidacionServicio getUsuarioValidacionServicio() {
		return usuarioValidacionServicio;
	}

	public void setUsuarioValidacionServicio(
			IUsuarioValidacionServicio usuarioValidacionServicio) {
		this.usuarioValidacionServicio = usuarioValidacionServicio;
	}
}
