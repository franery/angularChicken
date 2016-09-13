package ar.com.escuelita.chicken.presentacion.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IUsuarioValidacionServicio;
import ar.com.escuelita.chicken.presentacion.controlador.Controlador;
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
			usuarioValidacionServicio.validacionNombreUsuario(usuario.getNombreUsuario(), usuario.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("nombreUsuario", e.getMessage(),"Mesnaje default");
		}
		try {
			usuarioValidacionServicio.validacionBorrarUsuarioRoot(usuario.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("borrado", e.getMessage(),"Mesnaje default");
		}
		try {
			usuarioValidacionServicio.validacionModificarUsuarioRoot(Controlador.usuario.getId(), usuario.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("id", e.getMessage(),"Mesnaje default");
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
