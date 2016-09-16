package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IPerfilValidacionServicio {
	
	void validacionPerfilRoot(String perfilId) throws ValidacionExcepcion;

	void validacionNombreUnico(String nombre, String id) throws ValidacionExcepcion;

	void validacionNombreNoVacio(String nombre) throws ValidacionExcepcion;
}
