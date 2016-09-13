package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IUsuarioValidacionServicio {
	
	void validacionNombreUsuario(String nombreUsuario, String usuarioId) throws ValidacionExcepcion;
	void validacionBorrarUsuarioRoot(String usuarioId) throws ValidacionExcepcion;
	void validacionModificarUsuarioRoot(String usuarioActualId, String usuarioId) throws ValidacionExcepcion;
}
