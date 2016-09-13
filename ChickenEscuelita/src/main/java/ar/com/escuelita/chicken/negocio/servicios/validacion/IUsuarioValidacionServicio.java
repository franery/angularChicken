package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IUsuarioValidacionServicio {
	
	void validacionNombreUsuario(String nombreUsuario, String usuarioId) throws ValidacionExcepcion;
	void validacionBorrarUsuarioRoot(long usuarioId) throws ValidacionExcepcion;
	void validacionModificarUsuarioRoot(long usuarioActualId, long usuarioId) throws ValidacionExcepcion;
}
