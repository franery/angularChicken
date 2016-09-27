package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IUsuarioValidacionServicio {
	
	void validacionNombreUnico(String nombreUsuario, String usuarioId) throws ValidacionExcepcion;
	void validacionNombreNoVacio(String nombreUsuario) throws ValidacionExcepcion;
	void validacionUsuarioRoot(String usuarioId) throws ValidacionExcepcion;
	void validacionContraseniaNoVacia(String contrasenia) throws ValidacionExcepcion;
}
