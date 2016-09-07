package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IUsuarioValidacionServicio {
	void validacionNombreUsuario(String nombreUsuario) throws ValidacionExcepcion;
}
